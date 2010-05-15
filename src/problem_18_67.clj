(ns problem-18-67
  (use [clojure.contrib.duck-streams :only (reader read-lines)]))

;; By starting at the top of the triangle below and moving to adjacent numbers on the row below
;; the maximum total from top to bottom is 23.

;; 3
;; 7 4
;; 2 4 6
;; 8 5 9 3

;; That is, 3 + 7 + 4 + 9 = 23.

;; Find the maximum total from top to bottom of the triangle below:

;; 75
;; 95 64
;; 17 47 82
;; 18 35 87 10
;; 20 04 82 47 65
;; 19 01 23 75 03 34
;; 88 02 77 73 07 63 67
;; 99 65 04 28 06 16 70 92
;; 41 41 26 56 83 40 80 70 33
;; 41 48 72 33 47 32 37 16 94 29
;; 53 71 44 65 25 43 91 52 97 51 14
;; 70 11 33 28 77 73 17 78 39 68 17 57
;; 91 71 52 38 17 14 91 43 58 50 27 29 48
;; 63 66 04 68 89 53 67 30 73 16 69 87 40 31
;; 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

;; NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
;; However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
;; it cannot be solved by brute force, and requires a clever method! ;o)

;; Answer to 18: 1074
;; Answer to 67: 7273

(defn- build-sum-mtx [triangle]
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
                            ;; converting back lazyseq from map to a vector since
                            ;; we would access on line 8 in the next iteration
                            (vec (map sum (get triangle i) (range 0 (inc i)))))
                      (inc i)))))))

(defn- max-sum [mtx] (apply max (last mtx)))

(defn- solve [src]
  (max-sum
   (build-sum-mtx
    ;; reduce below build a triangle
    (reduce conj []
            (map (fn [line]
                   (vec (map #(Integer. %)
                             (.split line " "))))
                 (read-lines (reader src)))))))

(defn problem-18 []
  (solve (java.io.File. "../data/problem_18")))

(defn problem-67 []
  (solve (java.io.File. "../data/problem_67")))
