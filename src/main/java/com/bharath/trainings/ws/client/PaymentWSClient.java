package com.bharath.trainings.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.trainings.ws.soap.PaymentProcessor;
import com.trainings.ws.soap.PaymentProcessorRequest;
import com.trainings.ws.soap.PaymentProcessorResponse;
import com.trainings.ws.soap.PaymentProcessor_Service;

public class PaymentWSClient {

	public static void main(String[] args) {

		// creamos una instancia del servicio
		// esta vez crearemos nuestro propio cliente, no utilizaremos SoapUi
		try {
			// configuramos una instancia del service provider
			PaymentProcessor_Service service = 
					new PaymentProcessor_Service(new URL("http://localhost:8080/javafirstwsut/services/paymentProcessor?wsdl"));
			PaymentProcessor port = service.getPaymentProcessorPort();
			
			// creamos una instancia del client
			Client client = ClientProxy.getClient(port);
			Endpoint endpoint = client.getEndpoint();
			
			// necesitamos implementar un interceptor en el client side, en contrapartida
			// al que hemos creado en el provider
			Map<String, Object> props = new HashMap<>();
			// queremos indicar que queremos utilizar the User Name Token Profile Security
			props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
			// and the username that should be used
			props.put(WSHandlerConstants.USER, "cxf");
			props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			// indicamos la clase que va a configurar los call backs
			props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
			
			WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
			endpoint.getOutInterceptors().add(wssOut);
			
			PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
			System.out.println(response.isResult());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
