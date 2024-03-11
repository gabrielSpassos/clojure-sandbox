42         ; integer
-1.5       ; floating point
22/7       ; ratio
"hello
world!"    ; string
\e         ; character
#"[0-9]+"  ; regular expression

map             ; symbol
+               ; symbol - most punctuation allowed
clojure.core/+  ; namespaced symbol
nil             ; null value
true false      ; booleans
:alpha          ; keyword
:release/alpha  ; keyword with namespace

'(1 2 3) ; list
[1 2 3] ; vector
#{1 2 3} ; set
{:a 1 :b 2} ; map

(def x 7) ; create var

(+ 7654 1234)

(/ (+ 7 (* 3 4) 5) 10)

(defn greet [name] (str "Hello, " name "!")) ; creates greet function

(defn messenger
  ([]     (messenger "Hello world!"))
  ([msg]  (println msg))) ; create function with optional argument

(defn hello [greeting & who]
  (println greeting who)) ; Variadic functions

(fn  [message]  (println message) ) ; Anonymous function

;; Equivalent to: (fn [x] (+ 6 x))
#(+ 6 %)

;; Equivalent to: (fn [x y] (+ x y))
#(+ %1 %2)

;; Equivalent to: (fn [x y & zs] (println x y zs))
#(println %1 %2 %&)

; apply
(defn plot [shape coords]   ;; coords is [x y]
  (plotxy shape (first coords) (second coords)))

(defn plot [shape coords]
  (apply plotxy shape coords))

; let
(let [x 1
      y 2]
  (+ x y))

(defn messenger-builder [greeting]
  (fn [who] (println greeting who))) ; closes over greeting

;; greeting provided here, then goes out of scope
(def hello-er (messenger-builder "Hello"))

;; greeting value still available because hello-er is a closure
(hello-er "world!")
;; Hello world!
