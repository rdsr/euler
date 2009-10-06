(ns problem-24
  (:use [clojure.contrib.combinatorics :only (lex-permutations)]))

(defn problem-24 []
  (nth (lex-permutations (list 0 1 2 3 4 5 6 7 8 9)) (dec 1000000)))

(problem-24)
