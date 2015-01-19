(ns midje-intro.core)

(def v (atom '()))

(defn throwing-function []
  (throw (Exception. "foo")))

(defn reset-values []
  (reset! v '()))

(defn insert-value [x]
  (swap! v conj x))

(defn exists-value? [x]
 (some #(= x %) @v))

(defn find-user [username]
;; Code that finds the user in the database
)

(defn authenticate [username password]
  (let [user (find-user username)]
    (if (= (:password user) password)
      user)))

(defn third-function [x])

(defn second-function [x]
  (println x))

(defn first-function [x]
  (dotimes [y 5] (second-function x)))


