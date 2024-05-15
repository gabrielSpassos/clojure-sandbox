(ns core-test
  (:require [clojure.test :as t]
            [core :as sut]))

(def letters ["A" "B" "C" "D"])

(t/deftest decision-tests
  (t/testing "decision works as expected"
    (t/is (= false (sut/decision letters)))))