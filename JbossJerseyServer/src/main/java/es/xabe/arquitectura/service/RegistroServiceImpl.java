package es.xabe.arquitectura.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.xabe.arquitectura.model.Acta;

@Service("registroService")
public class RegistroServiceImpl implements RegistroService{

	@Override
	public List<Acta> getActas() {
		List<Acta> actas = new ArrayList<Acta>();
		Acta acta = new Acta();
		acta.setNombre("Acta 1");
		actas.add(acta);
		acta = new Acta();
		acta.setNombre("Acta 2");
		actas.add(acta);
		return actas;
	}
}
