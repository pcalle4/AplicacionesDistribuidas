package interciclo.servicios;
import javax.ws.rs.Produces;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import interciclo.datos.EstudianteDAO;
import interciclo.datos.SolicitudCitaDAO;
import interciclo.datos.TutorDAO;
import interciclo.modulos.Estudiante;
import interciclo.modulos.EstudianteLs;
import interciclo.modulos.Tutor;

@Path("/solicitud")
public class SolicitudServices {

	@Inject
	private EstudianteDAO edao;
	private TutorDAO tdao;
	
	@GET
	@Path("/tutor")
	@Produces("application/json")
	public Tutor getTutor(@QueryParam(" id ") int id) {
		Tutor tut = new Tutor();
		tut.setTut_id(id);
		tut.setTut_nombre("Holger");
		return tut;
	}
	
	@GET
	@Path("/estudiante")
	@Produces("application/json")
	public Estudiante getEstudiante(@QueryParam(" id ") int id) {
		Estudiante est = new Estudiante();
		est.setEst_id(id);
		est.setEst_nombre("Andres");
		return est;
	}
	@GET
	@Path("/estudianteid")
	@Produces("application/json")
	public Estudiante getEstudianteId(@QueryParam("id") int id) {
		Estudiante est = edao.read(id);
		System.out.println(est);
		return est;
		
	}
	@GET
	@Path("/tutid")
	@Produces("application/json")
	public Tutor getTutorId(@QueryParam("id") int id) {
		Tutor tut = tdao.read(id);
		System.out.println(tut);
		return tut;
		
	}
	
	@GET
	@Path("/lista")
	@Produces("application/json")
	public List<Estudiante> getEstudiantes2(){
		List<Estudiante> estudiantes = edao.getEstudiantes2();
		return estudiantes;
	}
	
	@GET
	@Path("/lista2")
	@Produces("application/json")
	public List<EstudianteLs> getEstudiantes(){
		List<Estudiante> estudiantes = edao.getEstudiantes();
		List<EstudianteLs> ests = new ArrayList<>();
		for(Estudiante est : estudiantes) {
			EstudianteLs ls = new EstudianteLs();
			ls.setEst_id(est.getEst_id());
			ls.setEst_nombre(est.getEst_nombre());
			ls.setEst_apellido(est.getEst_apellido());
			ests.add(ls);
		}
		return ests;
	}
	
	
	
	
	
	
	
	
}
