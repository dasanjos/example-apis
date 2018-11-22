# example-apis
A collection of different technologies (SOAP, REST, GraphQL, gRPC) for making Web Services and APIs in Java 8.

## soap
Start WS-JAX server with `mvn package embedded-glassfish:run -Dhttp.port=8080` 
Run SOAP client with `TBD`
Also endpoints for [WSDL](http://localhost:8080/CalculadoraWSService?wsdl) and [XSD](http://localhost:8080/CalculadoraWSService?xsd)

## rest
Start spring boot 2 (Jersey) server with `mvn spring-boot:run` 
Open client (browser) url http://localhost:8080/hello/world 
Also endpoints for [Swagger](http://localhost:8080/) 

## graphql
Start GraphQL (Jetty servlet 3.0) server with `mvn jetty:run` 
Open client (browser) url http://localhost:8080/graphql?query={allLinks{url,description}} 
Also endpoints for [GraphiQL](http://localhost:8080/) 

## grpc
Start gRPC (netty) server with `TBD` 
Run gRPC client with `TBD`
