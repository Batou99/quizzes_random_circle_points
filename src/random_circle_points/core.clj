(ns random-circle-points.core)

(defn pi_2_rand [] (* (* 2 (rand)) (. Math PI)))

(defn circle_points [radius alpha] 
  (zipmap '(:x :y) (map #(* radius %1) [(Math/cos alpha) (Math/sin alpha)])))

(defn seq_rand_points_circle [x y radius]
  (repeatedly (apply merge-with + [(circle_points radius pi_2_rand) {:x x :y y}])))

(defn -main [] (println (circle_points 1 (pi_2_rand))))
