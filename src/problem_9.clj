(ns problem-9)

;; A Pythagorean triplet is a set of three natural numbers, a  b  c, for which

;; a^2 + b^2 = c^2
;; For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.

;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.


;; Answer: 31875000

(defn- f [a c]
  (* 2
     (+ a c)
     (- 1000 a)))

;; the soln use the below formula to filter out a,b and c
;; (1000 - (a + c))^2 = (c^2 - a^)      using eqns: a^2 + b^2 = c^2 and a + b + c = 1000
;; => 2(a + c)(1000 - a) = 1000000

(defn problem-9 []
  (reduce
   *
   (first
    (for [a (range 1 500) ;; a, b and c will all be < 500 by triangle inequality
          c (range 1 500)
          :when (= (f a c) 1000000)]
      [a (- 1000 a c) c]))))

