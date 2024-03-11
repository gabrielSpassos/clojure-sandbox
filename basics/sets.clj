;; sets
(def players #{"Alice", "Bob", "Kelly"})
(conj players "Fred") ;; add to set, this will not update the previous vector
(disj players "Bob" "Sall")  ;; remove from set, this will not update the previous vector
(contains? players "Kelly") ;; contains
(conj (sorted-set) "Bravo" "Charlie" "Sigma" "Alpha") ;; sorted set

;; (def new-players ["Tim" "Sue" "Greg"])
(into players new-players) ;; add one collection into another, returns a collection of the same type as its first argument.