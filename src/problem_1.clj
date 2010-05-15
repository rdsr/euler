(ns problem-1)

;; if we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
;; The sum of these multiples is 23.

;; Find the sum of all the multiples of 3 or 5 below 1000.

;; Answer: 233168

(def m3s (/ (* 333 (+ 3 999)) 2))
(def m5s (/ (* 199 (+ 5 995)) 2))
(def m15s (/ (* 66 (+ 15 990)) 2))

(defn problem-1 []
  (- (+ m3s m5s) m15s))
