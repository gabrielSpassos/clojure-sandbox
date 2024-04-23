(try
  (/ 2 0)
  (catch ArithmeticException e
    "can't divide by zero")
  (finally
    (println "cleanup")))

(try
  (throw (Exception. "something went wrong"))
  (catch Exception e (.getMessage e)))


(try
  (throw (ex-info "There was a problem" {:detail 42}))
  (catch Exception e
    (prn (:detail (ex-data e)))
    (.getMessage e)
    ))