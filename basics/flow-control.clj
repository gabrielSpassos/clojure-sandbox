;; samples
(str "2 is " (if (even? 2) "even" "odd"))
(if (true? false) "impossible!")

;; true vs false
(if true :truthy :falsey)
(if (Object.) :truthy :falsey)
(if [] :truthy :falsey)
(if 0 :truthy :falsey)
(if false :truthy :falsey)
(if nil :truthy :falsey)

(if (>= 1 2) 
    [true [1]] ;; returns a tuple [bool, array]
    (loop [i 0]
      (if (= 3 3) ;; stops when index is equals to matrix length (row length)
        [false [2]]
        [true [3]]
      )
    )
)

;; multiple if options
(if (even? 5)
  (do (println "even")
      true)
  (do (println "odd")
      false))

(def x -1)
(when (neg? x)
  (throw (RuntimeException. (str "x must be positive: " x))))

(let [x 5]
  (cond
    (< x 2) "x is less than 2"
    (< x 10) "x is less than 10"))

(let [x 11]
  (cond
    (< x 2)  "x is less than 2"
    (< x 10) "x is less than 10"
    :else  "x is greater than or equal to 10"))

(defn case-sample [x]
    (case x
    5 "x is 5"
    10 "x is 10"))
(case-sample 10)
(case-sample 11)

(defn case-else-sample [x]
    (case x
    5 "x is 5"
    10 "x is 10"
    "x isn't 5 or 10"))
(case-else-sample 5)
(case-else-sample 11)