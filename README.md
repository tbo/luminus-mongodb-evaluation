# Queryserver

A generic MongoDB query server written in clojure.

## Prerequisites

You will need [Leiningen](https://github.com/technomancy/leiningen) 2.0 or above installed.

## Running

Define database:
    
    export DATABASE_URL="mongodb://127.0.0.1/luminus_mongodb_evaluation_dev"
    
To start a web development server for the application, run:

    lein run 
    
Build and run production:

    lein uberjar
    java -jar target/uberjar/luminus-mongodb-evaluation.jar 

Example request:

    http://localhost:3000/collection_name?limit=5&query={"locale":"en"}
    

