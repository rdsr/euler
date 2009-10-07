(ns util)

(defn divisors [n]
  (cons n (proper-divisors n) ))

(defn proper-divisors [n]
  (loop [i 2 nos '(1)]
    (cond
      (> i (Math/sqrt n)) nos
      (= (rem n i) 0) 
        (let [n-by-i (/ n i)]
          (if (= i n-by-i)
            (recur (inc i ) (cons i nos))
            (recur (inc i) (cons i (cons (/ n i) nos)))))
      :else (recur (inc i) nos))))
