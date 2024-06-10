(ns core-test
  (:require [clojure.test :as t]
            [core :as sut]))

(def invalid-letters-case ["A" "B" "C" "D"])
(def valid-letters-case ["Z" "Y" "X" "W"])

(t/deftest decision-tests
  (t/testing "decision should return false"
    (t/is (= false (sut/decision invalid-letters-case))))
  (t/testing "decision should return true"
    (t/is (= true (sut/decision valid-letters-case))))
)

(t/deftest inc-or-dec-tests
  (t/testing "inc-or-dec should return dec row"
    (t/is (= -1 (sut/inc-or-dec 0 0 :up))))
  (t/testing "inc-or-dec should return inc row"
    (t/is (= 1 (sut/inc-or-dec 0 0 :down))))
)

(t/deftest decision-with-recur-tests
  (t/testing "decision-with-recur should return true"
    (t/is (= true (sut/decision-with-recur 0 0 :up))))
  (t/testing "decision-with-recur should return true"
    (t/is (= true (sut/decision-with-recur 0 0 :down))))
)
