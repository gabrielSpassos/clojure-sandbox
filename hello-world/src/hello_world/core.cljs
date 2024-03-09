(ns hello-world.core)

(println (clojure.string/upper-case "hello world!"))

;; ADDED
(defn average [a b]
  (/ (+ a b) 2.0))
