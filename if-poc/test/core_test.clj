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
