;; vector
(get ["abc" false 99] 0)
(get ["abc" false 99] 14)
(count [1 2 3])
(vector 1 2 3)
(conj [1 2 3] 4 5 6) ;; add element, this will not update the previous vector

;; list
(def cards '(10 :ace :jack 9))
(first cards)
(rest cards)
(conj cards :queen) ;; this will not update the previous vector
(peek cards)
(pop cards)