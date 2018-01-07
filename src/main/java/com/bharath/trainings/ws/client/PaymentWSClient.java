package com.bharath.trainings.ws.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.trainings.ws.soap.PaymentProcessor;
import com.trainings.ws.soap.PaymentProcessorRequest;
import com.trainings.ws.soap.PaymentProcessorResponse;
import com.trainings.ws.soap.PaymentProcessor_Service;

public class PaymentWSClient {

	public static void main(String[] args) {

		// creamos una instancia del servicio
		// esta vez crearemos nuestro propio cliente, no utilizaremos SoapUi
		try {
			PaymentProcessor_Service service = 
					new PaymentProcessor_Service(new URL("http://localhost:8080/javafirstwsut/services/paymentProcessor?wsdl"));
			PaymentProcessor port = service.getPaymentProcessorPort();
			
			PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
			System.out.println(response.isResult());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
