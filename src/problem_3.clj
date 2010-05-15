(ns euler.problem-3
  (:use [util :only (prime-factors)]))

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

;; Answer: 6857

(defn problem-3 []
  (last (prime-factors 600851475143)))


