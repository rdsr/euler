(ns problem-18
  (use [clojure.contrib.duck-streams :only (reader read-lines)]))

(defn build-sum-mtx [triangle]
  (let [len (count triangle)]
    (loop [mtx [] i 0]
      (cond
        (= i len) mtx
        :else (let [row (get mtx (dec i))
                    sum (fn [n j]
                          (let [a (or (get row (dec j)) 0)
                                b (or (get row j) 0)]
                            (+ (max a b) n)))]
                (recur (conj mtx 
                             (vec (map sum (get triangle i) (range 0 (inc i))))) ;; converting back lazyseq from map to a vector since we would access on line 8 in the next iteration
                       (inc i)))))))

(defn max-sum [mtx] (apply max (last mtx)))

(defn problem-67 []
  (max-sum
   (build-sum-mtx
    ;; reduce below build a triangle
    (reduce conj [] 
            (map (fn [line]
                   (vec (map #(Integer. %)
                             (.split line " "))))
                 (read-lines (reader "http://projecteuler.net/project/triangle.txt")))))))