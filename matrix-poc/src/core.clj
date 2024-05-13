(ns core)

(use 'clojure.core.matrix)

(def my_matrix (matrix [[1 2] [3 4]]))

(def my_shape (shape [[1 2] [3 4]]))

(defn -main []
  (println "Matrix")
  (println my_matrix)
  (pm my_matrix)
  (println(get-row my_matrix 0))

  (println "Shape")
  (println my_shape)
  (pm my_shape))
