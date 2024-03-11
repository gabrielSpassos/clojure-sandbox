;; map
(def scores {"Fred"  1400
             "Bob"   1240
             "Angela" 1024})
;; (def scores {"Fred" 1400, "Bob" 1240, "Angela" 1024})
(assoc scores "Sally" 0) ;; add/update key value to map
(dissoc scores "Bob") ;; remo item from map
(get scores "Angela") ;; get value from map
(get scores "Sam" 0) ;; get with default value

(def directions {:north 0
                 :east 1
                 :south 2
                 :west 3})
(directions :north)

(contains? scores "Fred") ;; check if contains - return true
(find scores "Fred") ;; return - ["Fred" 1400]

(keys scores) ;; get only keys
(vals scores) ;; get only values