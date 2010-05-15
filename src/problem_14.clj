(ns problem-14)

;; The following iterative sequence is defined for the set of positive integers:

;; n  n/2 (n is even)
;; n  3n + 1 (n is odd)

;; Using the rule above and starting with 13, we generate the following sequence:

;; 13  40  20  10  5  16  8  4  2  1
;; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
;; Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

;; Which starting number, under one million, produces the longest chain?

;; NOTE: Once the chain starts the terms are allowed to go above one million.

;; Answer: 837799

;; TODO: have a better solution

(defn- chain-len [no]
  (loop [n no len 0]
    (cond
      (= n 1) len
      (even? n) (recur (/ n 2) (inc len))
      :else (recur (inc (* 3 n)) (inc len)))))

(defn problem-14 []
  (loop [no 1 max 0 no-having-max -1]
    (if (> no 1000000)
     no-having-max
      (let [chn-ln (chain-len no)]
        (if (> chn-ln max)
          (recur (inc no) chn-ln no)
          (recur (inc no) max no-having-max))))))
