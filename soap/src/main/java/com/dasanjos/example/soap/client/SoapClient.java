package com.dasanjos.example.soap.client;

import javax.xml.soap.*;

/**
 * The example below requests from the Web Service at: http://localhost:8080/CalculadoraWSService?op=fazerOp
 *
 * To call other WS, change the SOAP Endpoint URL and the SOAP Action
 */
public class SoapClient {

  public static void main(String args[]) {
    String soapEndpointUrl = "http://localhost:8080/CalculadoraWSService";
    String soapAction = "http://www.dasanjos.com/GetInfoByCity";

    callSoapWebService(soapEndpointUrl, soapAction);
  }

/* Constructed SOAP Request Message:
  <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:jax="http://jaxws.ola.jugvale.org/">
      <SOAP-ENV:Header/>
      <SOAP-ENV:Body>
          <jax:fazerOp>
              <num1>3</num1>
              <num2>5</num2>
              <op>+</op>
          </jax:fazerOp>
      </SOAP-ENV:Body>
  </SOAP-ENV:Envelope>
*/

  /**
   * Constructs the inner part of the SOAP envelope that is actually sent.
   *
   * @param soapMessage message to be sent
   * @throws SOAPException if something goes wrong
   */
  private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
    SOAPPart soapPart = soapMessage.getSOAPPart();

    String myNamespace = "jax";
    String myNamespaceURI = "http://jaxws.ola.jugvale.org/";

    // SOAP Envelope
    SOAPEnvelope envelope = soapPart.getEnvelope();
    envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

    // SOAP Body
    SOAPBody soapBody = envelope.getBody();
    SOAPElement operation = soapBody.addChildElement("fazerOp", myNamespace);

    SOAPElement num1 = operation.addChildElement("num1");
    num1.addTextNode("3");

    SOAPElement num2 = operation.addChildElement("num2");
    num2.addTextNode("5");

    SOAPElement op = operation.addChildElement("op");
    op.addTextNode("+");
  }

  private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
    try {
      // Create SOAP Connection
      SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
      SOAPConnection soapConnection = soapConnectionFactory.createConnection();

      // Send SOAP Message to SOAP Server
      SOAPMessage soapResponse = soapConnection
          .call(createSOAPRequest(soapAction), soapEndpointUrl);

      // Print the SOAP Response
      System.out.println("Response SOAP Message:");
      soapResponse.writeTo(System.out);
      System.out.println();

      soapConnection.close();
    } catch (Exception e) {
      System.err.println("Error occurred while sending SOAP Request to Server!");
      System.err.println("Make sure you have the correct endpoint URL and SOAPAction!");
      e.printStackTrace();
    }
  }

  private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
    MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();

    createSoapEnvelope(soapMessage);

    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", soapAction);

    soapMessage.saveChanges();

    /* Print the request message, just for debugging purposes */
    System.out.println("Request SOAP Message:");
    soapMessage.writeTo(System.out);
    System.out.println("\n");

    return soapMessage;
  }

}