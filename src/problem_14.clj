(ns problem-14)

(defn cnt-chain [n]
  (cond (= n 1) 1
        (even? n) (inc (recur (/ n 2)))
        (odd? n) (inc (recur (inc  (* 3 n))))))

(defn problem-14 []
  (apply max (map (memoize cnt-chain) (range 1 1000000))))