(ns problem-16
  (:use [util :only (number-to-digits)]))

;; 2^(15) = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

;; What is the sum of the digits of the number 2^(1000)?

;; Answer: 1366

(defn problem-16 []
  (reduce + (number-to-digits (bit-shift-left 1 1000))))
