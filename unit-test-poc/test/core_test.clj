(ns core-test
  (:require [clojure.test :as t]
            [core :as sut]))

(t/deftest test-assertion
  (t/testing  "true equals false"
    (t/is (= true false))) ;; propose fail
  (t/testing "true is true"
      (t/is (true? true))))

(t/deftest multiply-test
  (t/testing "multiplication works as expected"
    (t/is (= 4 (sut/multiply 2 2)))))

(t/deftest add-test
  (t/testing "add works as expected"
    (t/is (= 9 (sut/add 5 4)))))