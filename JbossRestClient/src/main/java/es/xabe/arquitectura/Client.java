package es.xabe.arquitectura;

import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;



public class Client {
	public static final String URL = "http://localhost:8080/JbossRestServer/rest/registro/";
	
	public static void main(String args[]) throws Exception {
		
		ClientRequest request = new ClientRequest(URL+"estado?tipo=pepe");
		request.accept("application/json");
		ClientResponse<Acta> response = request.get(Acta.class);

		int apiResponseCode = response.getResponseStatus().getStatusCode();
		if (response.getResponseStatus().getStatusCode() != 200) {
			throw new RuntimeException("Failed with HTTP error code : "+ apiResponseCode);
		}

		Acta acta = response.getEntity();
		System.out.println(acta.getNombre());
		response.releaseConnection();
		
		request = new ClientRequest(URL+"estados");
		request.accept("application/json");
		ClientResponse<List<Acta>> responses = request.get(new GenericType<List<Acta>>(){});

		apiResponseCode = response.getResponseStatus().getStatusCode();
		if (response.getResponseStatus().getStatusCode() != 200) {
			throw new RuntimeException("Failed with HTTP error code : "+ apiResponseCode);
		}

		List<Acta> actas = responses.getEntity();
		for(Acta acta2 : actas){
			System.out.println(acta2.getNombre());
		}
		responses.releaseConnection();

		
	}
}
