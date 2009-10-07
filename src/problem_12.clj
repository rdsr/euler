(ns problem-12
  (use [util :only (divisors)]))

(defn problem-12 []
  (first (filter #(>= (count (divisors %)) 500)
                 (map #(/ (* % (inc %)) 2) (iterate inc 1)))))

(problem-12)

