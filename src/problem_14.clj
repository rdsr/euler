(ns problem-14)

;; (def collatz-cache (atom {}))

;; (defn cached-chain []
;;   (doseq [no (range 1 1000000)]
;;     (if (even? no)
;;       (swap! collatz-cache assoc no (inc (@collatz-cache (/ no 2) 0)))
;;       (swap! collatz-cache assoc no (inc (@collatz-cache (inc (* 3 no)) 0))))))

;; (defn problem-14 []
;;   (reduce (fn [a b]
;;             (if (> (val a) (val b)) (key a) (key b)))
;;           (cached-chain)))

;; TODO have a better solution for this problem

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
  
(problem-14)



