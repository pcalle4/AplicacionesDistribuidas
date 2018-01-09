package interciclo.servicios;



import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import interciclo.datos.TutorDAO;
import interciclo.modulos.Tutor;

@Path("/tutor")
public class TutorServices {

	

	@Inject
	private TutorDAO tdao;
	
	@GET
	@Path("/tutorid")
	@Produces("application/json")
	public Tutor getTutorId(@QueryParam("id") int id) {
		Tutor tut = tdao.read(id);
		System.out.println(tut);
		return tut;
	}
	
	@GET
	@Path("/listadotut")
	@Produces("application/json")
	public List<Tutor> listadoTutor() {
		List<Tutor> tut = tdao.listadoTutor2();	
		return tut;
	}
	
	@POST
	@Path("/guardar")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta saveTut(Tutor tut) {
		Respuesta resp = new Respuesta();
		try {
			tdao.insertar(tut);
			resp.setCodigo(1);
			resp.setMensaje("Registro satisfactorio");
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}

}
