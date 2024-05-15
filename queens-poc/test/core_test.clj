(ns core-test
  (:require [clojure.test :as t]
            [core :as sut]))

(use 'clojure.core.matrix)

(def test_queen_matrix (matrix [["Q" "Q"] ["Q" "Q"]]))

(t/deftest is-safe-tests
  (t/testing "is safe works as expected"
    (t/is (= false (sut/is-safe test_queen_matrix 1 1)))))