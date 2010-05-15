(ns problem-5
  (:use [clojure.contrib.lazy-seqs]
        [util :only (square)]))

;;(* (* 2 3 5 7 11 13 17 19) 2 2 2 3)

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?

;; Answer: 232792560

(defn- pow [p n]
  (let [exponent
        (quot (Math/log n)
              (Math/log p))]
    (int (Math/pow p exponent))))

(defn- div-from-1-n  [n]
  (let [p (take-while #(< % n) primes)
        [p1 p2] (split-with #(< (square %) n) p)]
    (reduce *
            (concat (map #(pow % n) p1)
                    p2))))

(defn problem-5 []
  (div-from-1-n 20))

