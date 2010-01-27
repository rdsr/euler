(ns problem-21
  (:use [util :only (proper-divisors)]))

(defn d [n]
  (apply + (proper-divisors n)))

(def amicable-nos (atom {}))

(defn amicable? [a]
  (if (@amicable-nos a) true
      (let [b (d a)
            db (d b)]
        (if (and (not= a b) (= a db))
          (do (swap! amicable-nos assoc b true) true)
          false))))

(defn problem-21 []
  (apply 
   +
   (filter amicable? (range 1 10000))))

(problem-21)

