(ns problem-23
  (use [util :only (proper-divisors not-divisible?)]))

;; A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
;; For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

;; A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

;; As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written
;; as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater
;; than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further
;; by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers
;; is less than this limit.

;; Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

;; Answer: 4179871

(def abndt-map (atom (sorted-map)))
(def abndt-sum-map (atom {}))

(defn abundant? [n]
  (if (and (odd? n)
           (not-divisible? n 5))
    false
    (> (apply + (proper-divisors n)) n)))

(defn fill-abndt-map []
  (doseq [n (range 12 20162)
          i (range 1 (/ 20161 n))
          :when (and (not (@abndt-map n)) (abundant? n))]
    (swap! abndt-map assoc (* n i) true))
  @abndt-map)

(defn problem-23 []
  (let [abndt-nos (vec (keys (fill-abndt-map)))
        len (count abndt-nos)]
    (doseq [i (range 0 len) j (range i len)
            :when (<= (+ (get abndt-nos i) (get abndt-nos j)) 20161)]
      (swap! abndt-sum-map assoc (+ (get abndt-nos i) (get abndt-nos j)) true))
    (apply + (filter (complement @abndt-sum-map)
                     (range 1 20162)))))
