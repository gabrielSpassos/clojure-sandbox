(ns core)

(use 'clojure.core.matrix)

(def my_matrix (matrix [[1 2] [3 4]]))

(def my_shape (shape [[1 2] [3 4]]))

(defn -main []
  (println my_matrix)
  (pm my_matrix)
  (println my_shape)
  (pm my_shape))
