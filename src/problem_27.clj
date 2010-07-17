(ns problem-27
  (:use [clojure.contrib.lazy-seqs]
        [util :only (not-divisible?)]))

;; Euler published the remarkable quadratic formula:

;; n^2 + n + 41

;; It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
;; However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41
;; and certainly when n = 41, 41^2 + 41 + 41 is clearly divisible by 41.

;; Using computers, the incredible formula  n^2 -79n + 1601 was discovered
;; which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, 79 and 1601, is 126479.

;; Considering quadratics of the form:

;; n^2 + an + b, where |a|  1000 and |b|  1000

;; where |n| is the modulus/absolute value of n
;; e.g. |11| = 11 and |4| = 4
;; Find the product of the coefficients, a and b, for the quadratic expression that produces
;; the maximum number of primes for consecutive values of n, starting with n = 0.


;; Answer: -59231

(defn- square [x] (* x x))

(defn- generate-eqn [a b]
  (fn [x]
    (+ (square x)
       (* a x)
       b)))

(defn- prime? [n]
  (if (neg? n)
    false
    (every? #(not-divisible? n %)
            (take-while (fn [i] (<= (square i) n)) primes))))

(defn- primes-count [a b]
  (let [eqn (generate-eqn a b)]
    (loop [prime-count 0 x 0]
      (if (prime? (eqn x))
        (recur (inc prime-count)
               (inc x))
        prime-count))))

(defn problem-27 []
  (let [prime-vec (atom [0 0 0])
        update-prime-cnt (fn [[pc1 :as v1] [pc2 :as v2]]
                           (if (> pc1 pc2) v1 v2))]
    (doseq [b (take 168 primes) a (range -999 1000 2)]
      (swap! prime-vec update-prime-cnt [(primes-count a b) a b]))
    (* (@prime-vec 1)
       (@prime-vec 2))))
