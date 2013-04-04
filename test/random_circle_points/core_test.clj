(ns random-circle-points.core-test
  (:use clojure.test
        random-circle-points.core))

(deftest pi_2_rand_test
  (testing "Generates random numbers"
    (is (not= (pi_2_rand) (pi_2_rand))))

  (testing "Generates numbers between 0 and 2PI"
    (def rlist (take 1000000 (repeatedly #(pi_2_rand))))
    (def delta 0.0001)
    (is (< (apply min rlist) delta))
    (is (> (apply min rlist) 0))
    (is (< (- (apply max rlist) (* 2 (. Math PI))) delta)))
)

(deftest circle_points_test
  (testing "Generates a cartesian point"
    (is (not= nil (:x (circle_points 1 1))))
    (is (not= nil (:y (circle_points 1 1)))))

  (testing "Point belongs to a circle centered in (0,0) with radius 1"
    (def point (circle_points 1 (pi_2_rand)))
    (def delta 0.0001)
    (is (< (- 1 (Math/sqrt (+ (Math/pow (:x point) 2) (Math/pow (:y point) 2)))) delta)))
)
