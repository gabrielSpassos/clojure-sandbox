(ns core)

(use 'clojure.core.matrix)

(defn is-safe [matrix, row, column]
  (dotimes [index column] 
    (def matrix-row (get-row matrix row))
    (when (= "Q" (get matrix-row index))
      (println "Achou queen")
      false)
  )

  (println "Saiu do if")
  true ;;todo: change to true
)

(defn -main []
  (println "N Queen Problem POC"))