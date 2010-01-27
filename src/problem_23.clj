(ns problem-23
  (use [util :only (proper-divisors)]))

(def abndt-map (atom (sorted-map)))
(def abndt-sum-map (atom {}))

(defn abundant? [n]
  (if (not (or (even? n) (= (rem n 5) 0)))
    false
    (> (apply + (proper-divisors n)) n)))

(defn fill-abndt-map []
  (doseq [n (range 12 20162)
          i (range 1 (/ 20161 n)) 
          :when (and (not (@abndt-map n)) (abundant? n))]
    (swap! abndt-map assoc (* n i) true))
  @abndt-map)

(defn problem-23 []
  (let [abndt-nos (vec (keys (fill-abndt-map)))
        len (count abndt-nos)]
    (doseq [i (range 0 len) j (range i len) 
            :when (<= (+ (get abndt-nos i) (get abndt-nos j)) 20161)]
      (swap! abndt-sum-map assoc (+ (get abndt-nos i) (get abndt-nos j)) true))
    (apply + (filter (complement @abndt-sum-map)
                     (range 1 20162)))))

(problem-23)