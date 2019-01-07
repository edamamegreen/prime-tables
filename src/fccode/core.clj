(ns fccode.core
  (:gen-class))

(defn filter-primes
  "A lazy sequence that returns only the prime numbers from
  a sequence containing integers greater than 1"
  [nums]
  (cons (first nums)
        (lazy-seq (filter-primes (filter #(not= 0 (mod % (first nums)))
                                         (rest nums))))))

;; This method generates
;; 20 primes in 0.034276 msecs
;; 50 primes in 0.102123 msecs
;; 500 primes in 0.166851 msecs
;; 5000 primes in 0.881978 msecs but instead
;; of printing, generates a
;; StackOverflowError   clojure.lang.ASeq.more (ASeq.java:131)
;; 2000 primes in 0.112861 msecs
;; 2000 primes in 0.247917 msecs
;; 2000 primes in 0.056514 msecs
;; Time isn't consistent with the same inputs,
;; perhaps there is an underlying system storing
;; the output in memory

(defn generate-primes
  "Return a list of n prime numbers"
  [n]
  (if (> n 0)
    (cons 1 (take (- n 1) (filter-primes (iterate inc 2))))))

(defn create-product-table
  "Given a list of nums, create a scalar multiple of the list for each num in the list"
  [nums]
  (map
    (fn [y] (map (fn [x] (* x y)) nums))
    nums))

(defn -main
  "Print a multiplication table of n primes where n is the first argument"
  [& args]
  (doseq [row (create-product-table (generate-primes (Integer. (first args))))]
    (println (clojure.string/join " " row))))