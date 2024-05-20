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

(defn is-safe? [matrix row column]
  (let [queen? #(= % QUEEN)]
    (letfn [(check-row [i]
              (if (< i column)
                (if (queen? (get-in matrix [row i]))
                  false
                  (recur (inc i)))
                true))
            (check-upper-diagonal [i j]
              (if (and (>= i 0) (>= j 0))
                (if (queen? (get-in matrix [i j]))
                  false
                  (recur (dec i) (dec j)))
                true))
            (check-lower-diagonal [i j]
              (if (and (>= j 0) (< i (count matrix)))
                (if (queen? (get-in matrix [i j]))
                  false
                  (recur (inc i) (dec j)))
                true))]
      (and (check-row 0)
           (check-upper-diagonal row column)
           (check-lower-diagonal row column)))))

;; Usage example:
(def QUEEN "Q")

(def matrix [["." "." "." "."]
             [QUEEN "." "." "."]
             ["." "." "." "."]
             ["." "." "." "."]])

(def row 0)
(def column 0)

(is-safe? matrix row column)

(defn -main []
  (println "N Queen Problem POC"))
