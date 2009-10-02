(ns util)

(defn divisors [n]
  (loop [i 1 nos ()]
    (cond
      (> i (Math/sqrt n)) nos
      (= (rem n i) 0) (recur (inc i) (cons i (cons (/ n i) nos)))
      :else (recur (inc i) nos))))