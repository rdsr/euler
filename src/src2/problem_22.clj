(use '[clojure.contrib.duck-streams :only (reader read-lines)])

(def letter->index
     {\A 1
      \B 2
      \C 3
      \D 4
      \E 5
      \F 6
      \G 7
      \H 8
      \I 9
      \J 10
      \K 11
      \L 12
      \M 13
      \N 14
      \O 15
      \P 16
      \Q 17
      \R 18
      \S 19
      \T 20
      \U 21
      \V 22
      \W 23
      \X 24
      \Y 25
      \Z 26})

(defn name-score [word index]
  (* (reduce + (map #(letter->index %) word))
     index))

(defn problem-22 []
  (reduce 
   +
   (map name-score
        ;; map should not have been necessary below, but the input contains
        ;; strings like "john" instead of john, so removing the extra double quotes
        (sort (map #(.substring % 1 (- (.length %) 1)) 
                   (.split (first (read-lines (reader "http://projecteuler.net/project/names.txt"))) ",")))
        (iterate inc 1))))