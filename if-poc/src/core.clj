(ns core)

(defn decision [array]
  (doseq [item array] 
    (prn item))

  ;; (dotimes [index column] 
  ;;   (def matrix-row (get-row matrix row))
  ;;   (when (= "Q" (get matrix-row index))
  ;;     (println "Achou queen")
  ;;     false)
  ;; )

  (println "Saiu do if")
  true ;;todo: change to true
)