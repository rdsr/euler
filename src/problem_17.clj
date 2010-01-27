(ns problem-17)

(def number->wrd-cnt
     {1 (count "one")
      2 (count "two")
      3 (count "three")
      4 (count "four")
      5 (count "five")
      6 (count "six")
      7 (count "seven")
      8 (count "eight")
      9 (count "nine")
 
      10 (count "ten")
      11 (count "eleven")
      12 (count "twelve")
      13 (count "thirteen")
      14 (count "fourteen")
      15 (count "fifteen")
      16 (count "sixteen")
      17 (count "seventeen")
      18 (count "eighteen")
      19 (count "nineteen")
      20 (count "twenty")
      30 (count "thirty")
      40 (count "forty")
      50 (count "fifty")
      60 (count "sixty")
      70 (count "seventy")
      80 (count "eighty")
      90 (count "ninety")

      ;; dec used for space
      100 (dec (count "one hundred"))
      200 (dec (count "two hundred"))
      300 (dec (count "three hundred"))
      400 (dec (count "four hundred"))
      500 (dec (count "five hundred"))
      600 (dec (count "six hundred"))
      700 (dec (count "seven hundred"))
      800 (dec (count "eight hundred"))
      900 (dec (count "nine hundred"))
     
      1000 (dec (count "one thousand"))})

(defn number->parts [n]
  "23 -> (list 20 3)"
  "120 -> (list 100 20)"
  "113 -> (list 100 13)"
  (loop [no n d 10 parts ()]
    (cond
      (zero? no) parts
      :else (let [r (rem no d)]
              (cond 
                (= r 0) (recur no (* d 10) parts)
                (= r 10) (recur (- no r) (* d 10) ;; having for instance 13 instead of 10 and 3 in the list
                                (cons (+ 10 (or (first parts) 0))
                                      (rest parts))) 
                :else (recur (- no r) (* d 10) (cons r parts)))))))

(defn problem-17 []
  (reduce 
   + 
   (map (fn [parts]
          (let [cnt (reduce + (map #(number->wrd-cnt %) parts))]
            (cond
              ;; length of "and" is added only if we a part of len 3, e.g (300 40 2) 
              ;; i.e three hundred and forty two or a part of len 2 e.g (300 40) 
              ;; i.e three hundred and forty
              (= (count parts) 3) (+ (count "and") cnt)
              (and (= (count parts) 2) (>= (first parts) 100)) (+ (count "and") cnt)
              :else cnt)))
        (map number->parts (range 1 1001)))))

(problem-17)