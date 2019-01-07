(ns fccode.core-test
  (:require [clojure.test :refer :all]
            [fccode.core :refer :all]))

(deftest test-generate-primes
  (testing "Generate primes function"
    (is (= nil (generate-primes -1)))
    (is (= nil (generate-primes 0)))
    (is (= '(1) (generate-primes 1)))
    (is (= '(1 2 3 5) (generate-primes 4)))))
