package es.xabe.arquitectura.ws;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.xabe.arquitectura.model.Acta;
import es.xabe.arquitectura.service.RegistroService;

@Path("/registro")
@Controller
public class RegistroWS {
	
	@Autowired
	private RegistroService registroService;

	
	@GET
	@Path("/estado")
	@Produces({ MediaType.APPLICATION_JSON  })
	public Acta getestado(@DefaultValue("alta") @QueryParam("tipo") String value){
		Acta acta = new Acta();
		acta.setNombre(value);
		return acta;
	}
	
	@GET
	@Path("/estados")
	@Produces({ MediaType.APPLICATION_JSON  })
	public List<Acta> getestados(){
		return registroService.getActas();
	}
}
