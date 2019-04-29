(ns luminus-mongodb-evaluation.db.core
    (:require
      [monger.core :as mg]
      [monger.collection :as mc]
      [monger.operators :refer :all]
      [mount.core :refer [defstate]]
      [monger.query :as mq]
      [luminus-mongodb-evaluation.config :refer [env]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(defn query [collection {:keys [query limit skip fields sort]}]
  (mq/with-collection db collection
     (mq/find (or query {}))
     (mq/fields (or fields {}))
     (mq/limit (or limit 100))
     (mq/sort (or sort (array-map)))
     (mq/skip (or skip 0))))

