(defn sqr [n] (* n n))

(defn proper-divs [d divs no]
  (cond
    (>= d (sqrt no)) divs
    :else (if (= 0 (rem no d))
            (recur (+ d 1) (conj divs d) no)
            (recur (+ d 1) divs no))))

(def memoized-proper-divs (memoize proper-divs))

(defn d [n]
  (reduce + (memoized-proper-divs 2 (list 1) n)))

;; [a da/b db]

(reduce
 (fn [partial-sum [a b db]] (+ a db partial-sum))
 0
 (filter (fn [[a b db]] (and (<= b 10000) (not= a b) (= a db)))
         (map (fn [a]
                (let [da (d a)
                      db (d da)]
                  (vector a da db)))
              (range 1 10001))))

