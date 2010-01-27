(ns problem-14)

(def collatz-cache (atom {1 0 2 1 3 7}))

(defn cached-chain []
  (doseq [no (range 4 (inc 3000001))]
    (when (even? no)
      (do (swap! collatz-cache assoc no (inc (/ no 2))) ;; calculate no's chain length since n/2 has already been calculated before
          (when (= (rem (dec no) 3) 0)
            ;; calculate (/ (dec no) 3)'s chain length since no's chain length was not known before
            (swap! collatz-cache assoc (/ (dec no) 3) (@collatz-cache no))))))
  @collatz-cache)


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
