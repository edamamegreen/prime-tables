(ns fccode.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (first args) (second args)))

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


(defn filter-primes
  [nums]
  (cons (first nums)
        (lazy-seq (filter-primes (filter #(not= 0 (mod % (first nums)))
                                       (rest nums))))))

(defn generate-primes
  "Return a list of n prime numbers"
  [n]
  (cons 1 (take (- n 1) (filter-primes (iterate inc 2)))))

