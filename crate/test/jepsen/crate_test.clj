(ns jepsen.crate-test
  (:require [clojure.test :refer :all]
            [jepsen.core :as jepsen]
            [jepsen.crate :refer :all]
            [jepsen.crate.lost-updates :as lost-updates]
            [jepsen.crate.dirty-read :as dirty-read]))

;(deftest a-test
;  (jepsen/run! (an-test {})))

;(deftest lost-updates-test
;  (jepsen/run! (lost-updates/test {})))

(deftest dirty-read-test
  (every? (comp empty? :some-lost :dirty-read :results)
          (take 100 (repeatedly #(jepsen/run! (dirty-read/test {}))))))
