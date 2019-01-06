(ns fccode.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (first args) (second args)))

(defn prime?
  [x known-primes]
  (every? #(not= 0 (mod x %)) known-primes))

;; The problem with this approach is it requires choosing
;; a range of numbers within to search for primes.
;; A lazy sequence is needed to be able to query for a given
;; number of primes.
;; This function needs to be refactored to convert it into
;; a lazy sequence.

(defn find-primes
  [n]
  (reduce
    #(if (prime? %2 %1) (conj %1 %2) (identity %1))
    #{2}
    (drop 3 (take n (range)))))