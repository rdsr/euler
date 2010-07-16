(ns problem-5
  (:use [clojure.contrib.lazy-seqs]
        [util :only (square)]))

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?

;; Answer: 232792560

(defn- pow
  "calculates p^x, where x satisfies: p^x <= n"
  [p n]
  (let [exponent
        (quot (Math/log n)
              (Math/log p))]
    (int (Math/pow p exponent))))

(defn- div-from-1-n  [n]
  "a no. divisible from 1 to n should
   contain all elements from the set: {p^x}
   where p is a prime and 1 < x < (/ logn logp)
   (i.e log n to the base p)"
  (let [p (take-while #(< % n) primes)
        [p1 p2] (split-with #(< (square %) n) p)]
    (reduce *
            (concat (map #(pow % n) p1)
                    p2))))

(defn problem-5 []
  (div-from-1-n 20))
