(ns problem-29)

(def terms (atom #{}))

(defn problem-29 []
  (doseq [a (range 2 101) b (range 2 101)]
    (swap! terms conj (Math/pow a b)))
  (count @terms))
