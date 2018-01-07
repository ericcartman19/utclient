package com.trainings.ws.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2018-01-07T07:29:37.123+01:00
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "PaymentProcessor", 
                  wsdlLocation = "file:/home/benito/workspace/parent-user-token-profile-demo/parent-user-token-profile/utclient/src/main/resources/paymentProcessor.wsdl",
                  targetNamespace = "http://soap.ws.trainings.com/") 
public class PaymentProcessor_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.ws.trainings.com/", "PaymentProcessor");
    public final static QName PaymentProcessorPort = new QName("http://soap.ws.trainings.com/", "PaymentProcessorPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/benito/workspace/parent-user-token-profile-demo/parent-user-token-profile/utclient/src/main/resources/paymentProcessor.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PaymentProcessor_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/home/benito/workspace/parent-user-token-profile-demo/parent-user-token-profile/utclient/src/main/resources/paymentProcessor.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PaymentProcessor_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PaymentProcessor_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PaymentProcessor_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentProcessor_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentProcessor_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentProcessor_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns PaymentProcessor
     */
    @WebEndpoint(name = "PaymentProcessorPort")
    public PaymentProcessor getPaymentProcessorPort() {
        return super.getPort(PaymentProcessorPort, PaymentProcessor.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PaymentProcessor
     */
    @WebEndpoint(name = "PaymentProcessorPort")
    public PaymentProcessor getPaymentProcessorPort(WebServiceFeature... features) {
        return super.getPort(PaymentProcessorPort, PaymentProcessor.class, features);
    }

}
