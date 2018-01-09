package interciclo.servicios;



import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import interciclo.datos.TutorDAO;
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
	
 @GET
 @Path("/tutorcedula")
 @Produces("application/json")
 
 public Tutor getTutorcedula(@QueryParam("cedula") String cedula) {
	 Tutor tut = tdao.getTutorByCedula(cedula);
	 System.out.println(tut);
	 return tut;
 }
	

}
