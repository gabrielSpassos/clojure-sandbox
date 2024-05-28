(ns core-test
  (:require [clojure.test :as t]
            [core :as sut]))

(use 'clojure.core.matrix)

(def test_unsafe_queen_matrix (matrix [["Q" "Q"] ["Q" "Q"]]))
(def test_safe_queen_matrix (matrix [["." "Q" "." "."] ["." "." "." "Q"] ["Q" "." "." "."] ["." "." "Q" "."]]))

(t/deftest is-safe-tests
  (t/testing "is safe works as expected"
    (t/is (= false (sut/is-safe? test_unsafe_queen_matrix 0 0)))
    (t/is (= false (sut/is-safe? test_unsafe_queen_matrix 1 1)))
    (t/is (= false (sut/is-safe? test_unsafe_queen_matrix 2 2)))
    (t/is (= false (sut/is-safe? test_unsafe_queen_matrix 3 3)))
    (t/is (= true (sut/is-safe? test_safe_queen_matrix 0 1)))
    (t/is (= true (sut/is-safe? test_safe_queen_matrix 1 3)))
    (t/is (= true (sut/is-safe? test_safe_queen_matrix 2 0)))
    (t/is (= true (sut/is-safe? test_safe_queen_matrix 3 2)))))

(t/deftest solve-n-queens-problem-tests
  (t/testing "solve n queens problem works as expected"
    (t/is (= test_safe_queen_matrix (sut/solve-n-queens-problem 4)))))