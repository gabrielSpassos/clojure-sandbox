(dotimes [i 3]
  (println i))

(doseq [i (range 3)]
  (println i))

(doseq [letter [:a :b]
        number (range 3)] ; list of 0, 1, 2
  (prn [letter number]))

(for [letter [:a :b]
      number (range 3)] ; list of 0, 1, 2
  [letter number])

(loop [i 0]
  (if (< i 10)
    (recur (inc i))
    i))

(defn increase [i]
  (if (< i 10)
    (recur (inc i))
    i))