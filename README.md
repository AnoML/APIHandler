# APIM Custom Handler

## How-to-run

* `cd APIHandler/`
* `mvn clean install`
* `cp target/api-handler-1.0-SNAPSHOT.jar [APIM-HOME]/repository/components/lib`
* Add API Handler logic (`<handler class="com.anoml.api.handler.CustomAPIHandler"/>`) to the Synapse configuration of the API found in [APIM-HOME]/repository/deployment/server/synapse-configs/default/
* Restart APIM
* Invoke the API

## TODO

Implement business logic to reflect disk I/O usage in JVM while APIM is up and running.

