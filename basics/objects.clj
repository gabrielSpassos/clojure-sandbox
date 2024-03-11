;; "objects"
(def person
  {:first-name "Gabriel"
   :last-name "Passos"
   :age 27
   :occupation "Programmer"})

;; get value from object
(get person :occupation)
(person :age)
(:last-name person)

;; set
(:favorite-color person "blue")

;; update
(assoc person :occupation "Enginner")

;; remove field
(dissoc person :age)

;; nested entities
(def company
  {:name "WidgetCo"
   :address {:street "123 Main St"
             :city "Springfield"
             :state "IL"}})

;; get inner attributes
(get-in company [:address :city])

;; assoc-in or update-in to modify nested entities:
(assoc-in company [:address :street] "303 Broadway")

;; record
;; Define a record structure
(defrecord Person [first-name last-name age occupation])

;; Positional constructor - generated
(def kelly (->Person "Kelly" "Keen" 32 "Programmer"))

;; Map constructor - generated
(def kelly (map->Person
             {:first-name "Kelly"
              :last-name "Keen"
              :age 32
              :occupation "Programmer"}))