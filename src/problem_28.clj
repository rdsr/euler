(ns problem-28
  (:use [util :only (square odds)]))

;; Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

;; 21 22 23 24 25
;; 20  7  8  9 10
;; 19  6  1  2 11
;; 18  5  4  3 12
;; 17 16 15 14 13

;; It can be verified that the sum of the numbers on the diagonals is 101.

;; What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?


;; Answer: 669171001

(defn problem-28 []
  "ne specifies a no. in the upper right diagonal
   nw specifies a no. in the upper left  diagonal
   sw specifies a no. in the lower left  diagonal
   se specifies a no. in the lower right diagonal"
  (let [square-sizes (take 501 (odds))
        ne-nos (fn [] (map #(square %) square-sizes))]
    (apply
     +
     1 ;; adding it here for the 1x1 square
     (map (fn [ne square-size]
            (let [square-size-1 (dec square-size)]
              (+ ne
                 (- ne square-size-1)                ;; nw no
                 (- ne (* 2 square-size-1))          ;; sw no
                 (- ne (* 3 square-size-1)))))       ;; se no
          ;; leaving out 1x1 square
          (rest (ne-nos))
          (rest square-sizes)))))
