(ns hello-world)

;; Different ways to produce "Hello, World!" in Clojure
(defn hello-world-print []
  (println "Hello, World!"))
(hello-world-print)


(defn hello-world-return []
  "Hello, World!")
(def message (hello-world-return))
(println message)


(def greet (fn [] "Hello, World!"))
(defn execute [f]
  (f))

(println (execute greet))
(println (execute (fn [] "Hello, World!")))


(println (.toUpperCase "hello, world!"))