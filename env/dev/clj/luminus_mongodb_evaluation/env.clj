(ns luminus-mongodb-evaluation.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [luminus-mongodb-evaluation.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[luminus-mongodb-evaluation started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-mongodb-evaluation has shut down successfully]=-"))
   :middleware wrap-dev})
