(defn flatmap [proc coll] (reduce into '() (map proc coll)))

(defn all-groups-of [n coll]
  (defn collect [lst1 lst2]
    (cond (empty? lst1) lst2
          :else (conj (collect (rest lst1) lst2)
                      (first lst1))))

  (defn groups [coll]
    (cond (< (count coll) n) '()
          :else (cons (take n coll)
                      (groups (drop n coll)))))
  (defn generate [i]
    (cond (>= i n) '()
          (< (count coll) (+ i n)) '()
          :else (collect (groups (drop i coll))
                         (generate (inc i)))))
  (generate 0))

(defn cmul [coll]
  (cond (empty? coll) '()
        :else (cons (reduce * 1 (map (fn [e] (Integer/parseInt (str e))) (first coll)))
                    (cmul (rest coll)))))

(time (apply max 
             (cmul (flatmap 
                    (fn [l] (all-groups-of 5 l))
                    (filter (fn [s] (>= (.length s) 5))
                            (seq (.split n-str "0")))))))

