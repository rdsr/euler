(ns problem-10
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

;; Find the sum of all the primes below two million.


;; Answer: 142913828922

(defn problem-10 []
  (reduce + (take-while #(< % 2000000) primes)))
