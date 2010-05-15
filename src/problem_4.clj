(ns problem-4)

;; A palindromic number reads the same both ways.
;; The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.

;; Find the largest palindrome made from the product of two 3-digit numbers.

;; Answer: 906609

(defn- palindrome? [n]
  (let [v (into [] (str n))
        rv (rseq v)]
    (= v rv)))

(defn problem-4 []
  (apply
   max
   (for [i (range 999 0 -1)
         j (range 999 i -1)
         :when (and (or (= (rem i 11) 0) (= (rem j 11) 0))
                    (palindrome? (* i j)))]
     (* i j))))



