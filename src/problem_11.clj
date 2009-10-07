(ns problem-11)

(defn- line-to-nos [line]
  (map #(Integer. %) (.split line " ")))

(defn- read-nos []
  (vec (reduce (fn [r lon] (concat r lon))
               ()
               (map line-to-nos
                    (.split (slurp "../data/problem_11") 
                            "\n")))))

(defn- prdt-e [nos i]
  (cond
    (= 0 (rem (- i 17) 20)) 0
    (= 0 (rem (- i 18) 20)) 0
    (= 0 (rem (- i 19) 20)) 0
    :else (apply * (map #(get nos %) (range i (+ i 4))))))

(defn- prdt-se [nos i]
  (cond
    (>= i 340) 0
    (= 0 (rem (- i 17) 20)) 0
    (= 0 (rem (- i 18) 20)) 0
    (= 0 (rem (- i 19) 20)) 0
    :else (apply * (map #(get nos %) (range i (+ i (* 4 21)) 21)))))

(defn- prdt-s [nos i]
  (cond
    (>= i 340) 0
    :else (apply * (map #(get nos %) (range i (+ i (* 4 20)) 20)))))

(defn- prdt-sw [nos i]
  (cond
    (>= i 340) 0
    (= 0 (rem (- i 0) 20)) 0
    (= 0 (rem (- i 1) 20)) 0
    (= 0 (rem (- i 2) 20)) 0
    :else (apply * (map #(get nos %) (range i (+ i (* 4 19)) 19)))))

(defn problem-11 []
  (let [nos (read-nos)]
    (apply
     max
     (map #(max (prdt-e nos %) (prdt-se nos %) (prdt-s nos %) (prdt-sw nos %))
          (range 0 400)))))

(problem-11) 

