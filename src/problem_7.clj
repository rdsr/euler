(ns problem-7
  (:use [clojure.contrib.lazy-seqs]))

;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13
;; we can see that the 6th prime is 13.

;; What is the 10001st prime number?

;; Answer: 104743

(defn problem-7 []
  (nth primes 10000))  ;; index begins at 0
