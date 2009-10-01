(defn fib
  ([] (concat [1 1] (fib 1 1)))
  ([a b]
     (lazy-seq (cons (+ a b)
                     (fib b (+ a b))))))

(defn problem-25 []
  (second
   (first 
    (filter (fn [[fi i]] 
              (= (.length (str fi)) 1000))
            (map (fn [fi i] [fi i]) (fib) (iterate inc 1))))))
