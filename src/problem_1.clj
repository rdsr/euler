(ns euler.project)

(def m3s (/ (* 333
               (+ 3 999))
            2))

(def m5s (/ (* 199
               (+ 5 995))
            2))

(def m15s (/ (* 66
                (+ 15 990))
             2))

(defn problem-1 []
  (- (+ m3s m5s) m15s))

