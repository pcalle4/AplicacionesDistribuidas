package interciclo.servicios;



import java.util.List;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import interciclo.datos.LugaNiveDAO;
import interciclo.datos.TutorDAO;
import interciclo.modulos.LugarNivelacion;
import interciclo.modulos.Tutor;

@Path("/web")
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
	
	@Inject
	private LugaNiveDAO ldao;
	
	@GET
	@Path("/lugares")
	@Produces("application/json")
	public List<LugarNivelacion> listadoLugNive(){
		List<LugarNivelacion> lugares = ldao.listadoLugNive();
		return lugares;
	}


	

}
