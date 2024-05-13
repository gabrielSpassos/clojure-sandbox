(ns core)

(use 'clojure.core.matrix)

(defn is-safe [matrix, row, column]
  (dotimes [i column] 
    (def matrix-row (get-row matrix row))
    (println (get matrix-row i))
    (if (= "Q" (get matrix-row i))
      (do (println "Queen Found")
        false)
    )
  )

  true
)

(defn -main []
  (println "N Queen Problem POC"))