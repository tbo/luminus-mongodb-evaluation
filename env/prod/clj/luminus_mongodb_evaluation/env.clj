(ns luminus-mongodb-evaluation.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[luminus-mongodb-evaluation started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[luminus-mongodb-evaluation has shut down successfully]=-"))
   :middleware identity})
