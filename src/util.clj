(ns util
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn square [x] (* x x))

(defn odds [] (iterate #(+ % 2) 1))

(defn prime-factors [n]
  (filter #(= (rem n %) 0)
          (take-while #(< (* % %) n) primes)))

(defn proper-divisors [n]
  (loop [i 2 nos '(1)]
    (cond
      (> i (Math/sqrt n)) nos
      (= (rem n i) 0)
        (let [n-by-i (/ n i)]
          (if (= i n-by-i)
            (recur (inc i ) (cons i nos))
            (recur (inc i) (cons i (cons (/ n i) nos)))))
      :else (recur (inc i) nos))))

(defn divisors [n]
  (cons n (proper-divisors n)))

(defn number-to-digits
  [number]
  (loop [n number digits ()]
    (let [remainder (rem n 10)]
      (if (= n 0)
        digits
        (recur (/ (- n remainder) 10)
               (conj digits remainder))))))

(defn digits-to-number [& digits]
  (reduce
   +
   (map #(* %1 %2)
        (conj (iterate square 10) 1)
        (reverse digits))))

(defn divisible? [n d] (= (rem n d) 0))

(def not-divisible? (complement divisible?))
