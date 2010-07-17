(ns problem-20
  (:use [util :only (number-to-digits)]))

;; n! means n × (n  − 1) × ... × 3 × 2 × 1
;; Find the sum of the digits in the number 100!

(defn- remove-factor
  "returns a vector containing the number with the given factor
   removed, and how many instances of that factor were removed. If
   'times' is specified, then <= times instances of the factor will be
   removed"
  ([number factor]
     (remove-factor number factor number))
  ([number factor times]
     (loop [n number t 0]
       (if (or (= t times)
               (not= (rem n factor) 0))
         [n t]
        (recur (/ n factor) (inc t))))))

(defn- get-numbers
  "returns the numbers (from 1 to 100) save those which are powers of
   10s. That is, equal number of 2s and 5s are removed because, on
   multipli- cation of these numbers they would only produ- ces powers
   of 10s"
  []
  (loop [cnt 0 number 2 numbers []]
    (if (= number 100)
      numbers
      (let [[number-5 i] (remove-factor number 5)
            [number-5-2 j] (remove-factor number-5  2 (+ i cnt))]
        (recur (- (+ i cnt) j)
               (inc number)
               (if (= number-5-2 1)
                 numbers
                 (conj numbers number-5-2)))))))

(defn problem-20 []
  (reduce + (number-to-digits (reduce * (get-numbers)))))
