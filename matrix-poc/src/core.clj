(ns core)

(use 'clojure.core.matrix)

(def my_matrix (matrix [[1 2] [3 4]]))

(def my_shape (shape [[1 2] [3 4]]))

(def raw_matrix [["."]])

(defn -main []
  (println "Matrix")
  (println my_matrix)
  (pm my_matrix)
  (println(get-row my_matrix 0))

  (println "Shape")
  (println my_shape)
  (pm my_shape)
  
  (println "Raw Matrix")
  (println "Original before update:" raw_matrix)
  (def update_raw_matrix (assoc-in raw_matrix [0 0] "A"))
  (println "Original after update:" raw_matrix)
  (println "Updated:" update_raw_matrix)
)
