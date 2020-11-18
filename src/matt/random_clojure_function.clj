(ns matt.random-clojure-function
  (:gen-class))

(defn function-list
  [namespace]
  (vals (ns-publics namespace)))

(def all-public-functions
  (mapcat #(vals (ns-publics %)) (all-ns)))

(defn random-function
  [function-list]
  (let [function-details (meta (rand-nth function-list))]
    (str (function-details :ns) "/" (function-details :name)
         "\n" (function-details :doc)
         "\n" (function-details :arglists))))

(defn -main
  "Return a function name form the Clojure Standard library"
  [& args]
  (if (seq args)
    (println (random-function (mapcat #(function-list (symbol %))  args))))
  (println (random-function all-public-functions)))


(comment

  (ns-publics 'clojure.core)

  (meta #'map)

  (meta (rand-nth (vals (ns-publics 'clojure.core))))

  (all-ns)

  (symbol "clojure.string")
  )
