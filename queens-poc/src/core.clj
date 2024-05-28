(ns core)

(def QUEEN "Q")

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

(defn solve-queens-problem [matrix column n-queens-count]
  (if (>= column n-queens-count)
    true
    (loop [i 0]
      (if (>= i (count matrix))
        false
        (if (is-safe? matrix i column)
          (let [new-matrix (assoc-in matrix [i column] QUEEN)]
            (if (solve-queens-problem new-matrix (inc column) n-queens-count)
              true
              (recur (inc i))))
          (recur (inc i)))))))

(defn solve-n-queens-problem [n-queens-count]
  (let [matrix (vec (repeat n-queens-count (vec (repeat n-queens-count "."))))]
    (solve-queens-problem matrix 0 n-queens-count)
    matrix))

(defn -main []
  (println "N Queen Problem POC")
  (println (solve-n-queens-problem 4)))