(ns problem-21
  (:use [util :only (proper-divisors)]))

;; Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
;; If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.

;; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
;; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

;; Evaluate the sum of all the amicable numbers under 10000.

;; Answer: 31626

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
