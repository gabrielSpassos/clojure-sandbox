(ns core)

(use 'clojure.core.matrix)

(def my_matrix (shape [[1 2] [3 4]]))

(defn -main []
  (println my_matrix))

