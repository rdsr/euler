(ns problem-8)

(defn- max-prdt [son]
  (apply
   max
   (map #(apply * %) (partition 5 1 (map #(Integer. (str %)) son)))))

(defn problem-8 []
  (apply
   max
   (map max-prdt 
        (filter #(>= (.length %) 5) 
                (.split (slurp "../data/problem_8") "[\n0]")))))

(problem-8)