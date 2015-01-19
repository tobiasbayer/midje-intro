(ns midje-intro.core-test
  (:use midje.sweet)
  (:use [midje-intro.core]))

(facts "about +"
  (fact "1 plus 2 equals 3"
    (+ 1 2) => 3)

  (fact
    (+ -1 -1) => -2)

  (fact
    (+ 1 1) =not=> 3))

(future-fact "it returns fancy"
  (fancy-function) => "fancy")

(facts "about my list"
  (fact "it contains the value 5"
    '(1 2 3 4 5 6) => (contains 5))
  (fact "it contains the values 2 and 3"
    '(1 2 3 4 5 6) => (contains 2 3))
  (fact "it contains an odd number followed by an even number"
    '(1 2 3 4 5 6) => (contains odd? even?)))

(facts "about my map"
  (fact "the value of x is 1"
    {:x 1 :y 2} => (contains {:x 1}))
  (fact "the value of y is even"
    {:x 1 :y 2} => (contains {:y even?})))

(defn each-element-is-one-of [expected-elements]
  (fn [actual]
    (every? (set expected-elements) actual)))

(fact "each element is one of 1-10"
  '(1 2 3 4 5 6) => (each-element-is-one-of (range 1 11)))

(fact
  (throwing-function) =>
    (throws Exception)
  (throwing-function) =>
    (throws Exception "foo")
  (throwing-function) =>
    (throws Exception #"(foo|bar)"))

(fact "insert-value has a side effect"
  (reset-values) => irrelevant
  (exists-value? "foo") => falsey
  (insert-value "foo") => irrelevant
  (exists-value? "foo") => true)

(fact "it authenticates a user with a valid password"
  (authenticate "the fly" "12345") => truthy
    (provided
      (find-user "the fly") =>
        {:name "the fly" :password "12345"}))

(fact "it calls the second function 5 times with argument 'foo'"
  (first-function "foo") => irrelevant
    (provided
      (second-function "foo") => irrelevant :times 5))

(fact "it never calls the third function with any argument"
  (first-function "foo") => irrelevant
    (provided
      (third-function anything) => irrelevant :times 0))
