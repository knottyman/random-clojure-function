(ns matt.random-clojure-function-test
  (:require [clojure.test :refer [deftest is testing]]
            [matt.random-clojure-function :as SUT]))

(deftest random-function-test
  (testing "Show random functions from Clojure standard library"
    (is (seq SUT/standard-library-functions))
    (is (string? (SUT/random-function SUT/standard-library-functions)))))
