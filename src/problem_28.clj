(ns problem-28)

(defn- square [x] (* x x))
(defn- odds [] (iterate #(+ % 2) 1))

(defn problem-28 []
  "ne specifies a no. in the upper right diagonal
   nw            ''           ''   left     ''
   sw            ''          lower  ''      ''    
   se            ''           ''   right    ''   "
  (let [square-sizes (take 501 (odds))
        ne-nos (fn [] (map #(square %) square-sizes))]
    (apply +
           1 ;; adding it here for the 1x1 square
           (map (fn [ne square-size]
                  (let [square-size-1 (dec square-size)]
                    (+ ne 
                       (- ne square-size-1)           ;; nw no
                       (- ne (* 2 square-size-1))     ;; sw no
                       (- ne (* 3 square-size-1)))))  ;; se no
                ;; leaving out 1x1 square
                (rest (ne-nos)) 
                (rest square-sizes))))) 

(problem-28)