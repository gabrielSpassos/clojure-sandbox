(ns core)

(def QUEEN "Q")

;; ["." "." "Q", "."]
(defn is-row-safe? [matrix row column]
  (loop [i 0]
    (if (= i column) ;; stops when the i reach the  column 
      true
      (if (= QUEEN (get-in matrix [row i])) ;; value on row and column (i) is Q?
        false
        (recur (inc i))
      )
    )
  )
)

(defn is-diagonal-safe? [matrix row column direction]
  (loop [i row, j column]
    (if (or (< i 0) (>= i (count matrix)) (>= j (count matrix))) ;; stops if row is < 0 OR row >= count matrix (elements of row) OR column >= count matrix
      true
      (if (= QUEEN (get-in matrix [i j])) ;; check if matrix[i j] == "Q"
        false
        (recur (if (= :up direction) (dec i) (inc i)) ;; if direction is up i-- else i++
              (dec j) ;; jj-- either directions
        )
      )
    )
  )
) 

(defn is-safe? [matrix row column]
  (and (is-row-safe? matrix row column) ;; row is safe?
       (is-diagonal-safe? matrix row column :up) ;; upper diagonal is safe?
       (is-diagonal-safe? matrix row column :down))) ;; lower diagonal is safe?

(defn solve-queens-problem [matrix column n-queens-count]
  (if (>= column n-queens-count) ;; stops when column is >= than n-queens-count
    (do
      (println "Stop recursive call, column: " column)
      [true matrix] ;; returns a tuple [bool, matrix]
    )

    ;; else
    (loop [i 0]
      (if (= i (count matrix)) ;; stops when index is equals to matrix length (row length)
        (do
          (println "Stop inner loop i:" i)
          [false matrix]
        )
        
        ;; else
        (if (is-safe? matrix i column)
          (do
            (def matrix-add-queen (assoc-in matrix [i column] QUEEN)) ;; add "Q" to row:i column:column
            (println "Add queen:" matrix-add-queen) ;; since is immutable need to create a new variable 
            (if (first (solve-queens-problem matrix-add-queen (inc column) n-queens-count)) ;; recursive call
              [true matrix-add-queen]

              ;; else
              (do
                (println "Else recursive call. Matrix:" matrix-add-queen)
                (recur (inc i))
              )
            )
          )

          ;; else
          (do 
            (println "row:" i, "column:" column "is not safe. Matrix:" matrix)
            (recur (inc i))
          )
        )
      )
    )
  )
)

(defn create-matrix [nqueens-count]
  (vec (repeat nqueens-count (vec (repeat nqueens-count "."))))) ;; create array of arrays, and fills with "."

(defn solve-n-queens-problem [nqueens-count]
  (let [matrix (create-matrix nqueens-count)]
    (second (solve-queens-problem matrix 0 nqueens-count))
  )
)

(defn -main []
  (println "N Queen Problem POC")
  (println "Final result:" (solve-n-queens-problem 4)))