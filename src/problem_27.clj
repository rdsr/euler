(ns problem-27
  (:use [clojure.contrib.lazy-seqs]))

(defn- square [x] (* x x))

(defn- generate-eqn [a b]
  (fn [x]
    (+ (square x)
       (* a x)
       b)))

(defn- prime? [n]
  (if (neg? n)
    false
    (every? #(not= (rem n %) 0)
            (take-while (fn [i] (<= (square i) n)) primes))))

(defn primes-count [a b]
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


(problem-27)