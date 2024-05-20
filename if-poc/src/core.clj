(ns core)

(defn decision [array]
  (loop [i 0]
    (if (< i (count array))
      (if (= "B" (nth array i))
        false
        (recur (inc i)))
      true)))
