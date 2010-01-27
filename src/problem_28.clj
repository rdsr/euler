(ns problem-28)

(defn- square [x] (* x x))
(defn odds [] (iterate #(+ % 2) 1))

(defn problem-28 []
  (let [square-sizes (take 501 (odds))
        ne-nos (fn [] (map #(square %) square-sizes))]
    (apply +
           1 ;; adding it here for the 1x1 square
           (map (fn [ne sq-sz]
                  (+ ne
                     (- ne (- sq-sz 1))
                     (- ne (* 2 (- sq-sz 1)))
                     (- ne (* 3 (- sq-sz 1)))))
                (rest (ne-nos)) ;; leaving out 1
                (rest square-sizes)))))
(problem-28)

