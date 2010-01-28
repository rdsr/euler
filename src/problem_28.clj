(ns problem-28)

(defn- square [x] (* x x))
(defn odds [] (iterate #(+ % 2) 1))

(defn problem-28 []
  (let [square-sizes (take 501 (odds))
        ne-nos (fn [] (map #(square %) square-sizes))]
    (apply +
           1 ;; adding it here for the 1x1 square
           (map (fn [ne sq-sz]
                  (let [sq-sz-1 (- sq-sz 1)]
                    (+ ne 
                       (- ne sq-sz-1) 
                       (- ne (* 2 sq-sz-1))
                       (- ne (* 3 sq-sz-1)))))
                ;; leaving out 1x1 square
                (rest (ne-nos)) 
                (rest square-sizes))))) 


(problem-28)