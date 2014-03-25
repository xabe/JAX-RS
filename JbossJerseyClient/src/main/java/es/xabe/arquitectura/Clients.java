package es.xabe.arquitectura;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;



public class Clients {
	public static final String URL = "http://localhost:8080/JbossJerseyServer/rest/registro/";
	
	public static void main(String args[]) throws Exception {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			 
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(URL+"estado?tipo=pepe");
		
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
					 
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        
        Acta acta = response.getEntity(Acta.class);
		System.out.println(acta.getNombre());
		response.close();
		
		
		webResource = client.resource(URL+"estados");
		
		response = webResource.accept("application/json").get(ClientResponse.class);
					 
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        
        List<Acta> actas = response.getEntity(new GenericType<List<Acta>>(){});
        for(Acta acta2 : actas){
			System.out.println(acta2.getNombre());
		}
		response.close();
		
	}
}
