(ns user
  (:require
    [luminus-mongodb-evaluation.config :refer [env]]
    [clojure.spec.alpha :as s]
    [expound.alpha :as expound]
    [mount.core :as mount]
    [luminus-mongodb-evaluation.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'luminus-mongodb-evaluation.core/repl-server))

(defn stop []
  (mount/stop-except #'luminus-mongodb-evaluation.core/repl-server))

(defn restart []
  (stop)
  (start))


