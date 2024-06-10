(ns core)

(defn decision [array]
  (loop [i 0]
    (if (< i (count array))
      (if (= "B" (nth array i))
        false
        (recur (inc i)))
      true)))

(defn inc-or-dec [row column direction]
  (if (= :up direction) (dec row) (inc row))
)

(defn decision-with-recur [row column direction]
  (loop [i row, j column]
    (if (or (= 10 i) (= -10 i) (= -10 j))
    true 
    (recur (if (= direction :up) (dec i) (inc i))
          (dec j)))))
    