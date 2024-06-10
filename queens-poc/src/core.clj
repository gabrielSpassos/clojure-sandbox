(ns core)

(def QUEEN "Q")

(defn is-row-safe? [matrix row column]
  (loop [i 0]
    (if (= i column) ;; stops when the i reach the  column 
      true
      (if (= QUEEN (get-in matrix [row i])) ;; value on row and column (i) is Q?
        false
        (recur (inc i))))))

(defn is-diagonal-safe? [matrix row column direction]
  (loop [i row, j column]
    (if (or (< i 0) (>= i (count matrix)) (>= j (count (get matrix 0)))) ;; stops if row is < 0 OR row >= count matrix OR column >= count first row of matrix
      true
      (if (= QUEEN (get-in matrix [i j]))
        false
        (recur (if (= direction :up) (dec i) (inc i)) ;; if direction is up i-- else i++
              (dec j)))))) ;; jj-- either directions

(defn is-safe? [matrix row column]
  (and (is-row-safe? matrix row column)
       (is-diagonal-safe? matrix row column :up)
       (is-diagonal-safe? matrix row column :down)))

(defn solve-queens-problem [matrix column n-queens-count]
  (if (>= column n-queens-count)
    true
    (loop [i 0]
      (if (= i (count matrix))
        false
        (if (is-safe? matrix i column)
          (do
            (assoc-in matrix [i column] QUEEN)
            (if (solve-queens-problem matrix (inc column) n-queens-count)
              true
              (do
                (assoc-in matrix [i column] ".")
                (recur (inc i)))))
          (recur (inc i)))))))

(defn create-matrix [nqueens-count]
  (vec (repeat nqueens-count (vec (repeat nqueens-count ".")))))

(defn solve-n-queens-problem [nqueens-count]
  (let [matrix (create-matrix nqueens-count)]
    (solve-queens-problem matrix 0 nqueens-count)
    matrix))

(defn -main []
  (println "N Queen Problem POC")
  (println (solve-n-queens-problem 4)))