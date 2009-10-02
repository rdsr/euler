(ns problem-12
  (use [util :only (divisors)]))

(defn problem-12 []
  (first (filter #(>= (count (divisors %)) 500)
                 (map #(/ (* % (+ % 1)) 2) (iterate inc 1)))))

