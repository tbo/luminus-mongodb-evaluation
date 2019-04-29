(ns luminus-mongodb-evaluation.routes.home
  (:require
    [luminus-mongodb-evaluation.layout :as layout]
    [clojure.java.io :as io]
    [luminus-mongodb-evaluation.middleware :as middleware]
    [luminus-mongodb-evaluation.db.core :as db]
    [monger.conversion :refer [from-db-object]]
    [clojure.data.json :as json]))

(defn readme [request]
  (layout/render request "home.html" {:docs (slurp "./README.md")}))

(defn parse-query-params [params]
  (reduce-kv (fn [m k v] (assoc m k (json/read-str v))) {} params))

(defn query-db [{:keys [params path-params]}]
  {:body (db/query  (path-params :collection) (parse-query-params params))})

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get readme}]
   ["/:collection" {:get query-db}]])

