# example-apis
A collection of different technologies (SOAP, REST, GraphQL, gRPC) for making Web Services and APIs in Java 8.

### soap
* Start soap (JAX-WS) server with `mvn package embedded-glassfish:run -Dhttp.port=8080` 
* Run SOAP client with `mvn exec:java`
* Also endpoints for [WSDL](http://localhost:8080/CalculadoraWSService?wsdl) and [XSD](http://localhost:8080/CalculadoraWSService?xsd)
* More info - https://docs.oracle.com/javaee/5/tutorial/doc/bnayn.html

### rest
* Start rest (Spring boot 2 + Jersey) server with `mvn spring-boot:run` 
* Open client (browser) url http://localhost:8080/hello/world 
* Also endpoints for [Swagger](http://localhost:8080/) 

### graphql
* Start GraphQL (Jetty + servlet 3.0) server with `mvn jetty:run` 
* Open client (browser) url http://localhost:8080/graphql?query={allLinks{url,description}} 
* Also endpoints for [GraphiQL](http://localhost:8080/) ([An in-browser IDE for exploring GraphQL](https://github.com/graphql/graphiql)).
* More info - https://www.howtographql.com/graphql-java/

### grpc
* Start gRPC (netty) server with `mvn exec:java` 
* Run gRPC client with `mvn exec:java -Pclient`
* More info - https://grpc.io/docs/quickstart/java
