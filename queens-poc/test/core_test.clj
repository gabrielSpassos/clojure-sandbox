(ns core-test
  (:require [clojure.test :as t]
            [core :as sut]))

(def test_unsafe_queen_matrix [["Q" "Q"] ["Q" "Q"]])
(def test_safe_queen_simple_matrix [["." "."] ["." "."]])
(def test_safe_queen_matrix [["." "Q" "." "."] ["." "." "." "Q"] ["Q" "." "." "."] ["." "." "Q" "."]])

(t/deftest get-matrix-tests
  (t/testing "count matrix"
    (t/is (= ["Q" "Q"] (get test_unsafe_queen_matrix 0)))
    (t/is (= ["Q" "." "." "."] (get test_safe_queen_matrix 2)))
    (t/is (= "Q" (get-in test_safe_queen_matrix [0 1])))
    (t/is (= "." (get-in test_safe_queen_matrix [0 2])))
  )
)

(t/deftest count-matrix-tests
  (t/testing "count matrix"
    (t/is (= 2 (count test_unsafe_queen_matrix)))
    (t/is (= 4 (count test_safe_queen_matrix)))
    (t/is (= 5 (count ["." "." "Q" "." "."])))
  )
)

(def assoc-matrix-test [["."]])
(t/deftest assoc-in-matrix-tests
  (t/testing "assoc-in matrix"
    (t/is (= [["Q"]] (assoc-in [["."]] [0 0] "Q")))
    (t/is (= [["Q"]] (assoc-in assoc-matrix-test [0 0] "Q")))
  )
)

(t/deftest is-row-safe-tests
  (t/testing "is row safe working as expected"
    (t/is (= true (sut/is-row-safe? [["Q"]] 0 0)))
    (t/is (= true (sut/is-row-safe? [["." "."]] 0 1)))
    (t/is (= false (sut/is-row-safe? [["." "." "Q" "."]] 0 3)))
    (t/is (= false (sut/is-row-safe? [["." "Q" "."]] 0 2)))
    (t/is (= false (sut/is-row-safe? [["Q" "." "." "."]] 0 1)))
  )
)

(t/deftest is-diagonal-safe-tests
  (t/testing "is upper diagonal safe working as expected"
    (t/is (= true (sut/is-diagonal-safe? [["." "Q"] ["Q" "."]] 1 1 :up)))
    (t/is (= true (sut/is-diagonal-safe? [["Q" "."] ["." "Q"]] 1 0 :up)))
    (t/is (= true (sut/is-diagonal-safe? [["Q" "Q"] ["Q" "Q"]] -1 0 :up))) ;; negative row case
    (t/is (= true (sut/is-diagonal-safe? [["Q" "Q"] ["Q" "Q"]] 3 0 :up))) ;; row > count matrix
    (t/is (= true (sut/is-diagonal-safe? [["Q" "Q"] ["Q" "Q"]] 2 0 :up))) ;; row = count matrix
    (t/is (= true (sut/is-diagonal-safe? [["Q" "Q"] ["Q" "Q"]] 0 3 :up))) ;; column > count first row of matrix
    (t/is (= true (sut/is-diagonal-safe? [["Q" "Q"] ["Q" "Q"]] 0 2 :up))) ;; column = count first row of matrix
    (t/is (= false (sut/is-diagonal-safe? [["Q" "."] ["." "Q"]] 0 0 :up)))
    (t/is (= false (sut/is-diagonal-safe? [["Q" "."] ["." "Q"]] 1 1 :up)))
    (t/is (= false (sut/is-diagonal-safe? [["." "." "Q"] ["." "Q" "."] ["Q" "." "."]] 2 0 :up)))
  )
)

(t/deftest is-safe-tests
  (t/testing "is safe works as expected"
    (t/is (= false (sut/is-safe? test_unsafe_queen_matrix 0 0)))
    (t/is (= false (sut/is-safe? test_unsafe_queen_matrix 0 1)))
    (t/is (= false (sut/is-safe? test_unsafe_queen_matrix 1 0)))
    (t/is (= false (sut/is-safe? test_unsafe_queen_matrix 1 1)))
    (t/is (= true (sut/is-safe? test_safe_queen_simple_matrix 0 0)))
    (t/is (= true (sut/is-safe? test_safe_queen_simple_matrix 0 1)))
    (t/is (= true (sut/is-safe? test_safe_queen_simple_matrix 1 0)))
    (t/is (= true (sut/is-safe? test_safe_queen_simple_matrix 1 1)))
  )
)

(t/deftest solve-queens-problem-tests
  (t/testing "solve queens problem"
    (t/is (= [true [["Q"]]] (sut/solve-queens-problem [["."]] 0 1)))
    (t/is (= [false [["Q"]]] (sut/solve-queens-problem [["Q"]] 0 1)))
    (t/is (= [true [["Q" "."] ["." "."]]] (sut/solve-queens-problem test_safe_queen_simple_matrix 0 1)))
    (t/is (= [false [["Q" "Q"] ["Q" "Q"]]] (sut/solve-queens-problem test_unsafe_queen_matrix 0 1)))
  )
)

(t/deftest create-matrix-tests
  (t/testing "create matrix is working as expected"
    (t/is (= [["."]] (sut/create-matrix 1)))
    (t/is (= [["." "."] ["." "."]] (sut/create-matrix 2)))
    (t/is (= [["." "." "." "."] ["." "." "." "."] ["." "." "." "."] ["." "." "." "."]] (sut/create-matrix 4)))
  )
)

(t/deftest solve-n-queens-problem-tests
  (t/testing "solve n queens problem works as expected"
    (t/is (= [["." "." "Q" "."] ["Q" "." "." "."] ["." "." "." "Q"] ["." "Q" "." "."]] (sut/solve-n-queens-problem 4)))))