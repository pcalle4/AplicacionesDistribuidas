package interciclo.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import interciclo.datos.EstudianteDAO;
import interciclo.modulos.Estudiante;

@Path("/estudiante")
public class EstudServer {

	@Inject
	private EstudianteDAO edao;
	
	@GET
	@Path("/estid")
	@Produces("application/json")
	public Estudiante getTutorId(@QueryParam("id") int id) {
		Estudiante est = edao.read(id);
		System.out.println(est);
		return est;
	}
	
	@POST
	@Path("/guardar")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta saveEstu(Estudiante est) {
		Respuesta resp = new Respuesta();
		try {
			edao.insertar(est);
			resp.setCodigo(1);
			resp.setMensaje("Registro satisfactorio");
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}
	
	@GET
	@Path("/listadoest")
	@Produces("application/json")
	public List<Estudiante> listadoEstudiante() {
		List<Estudiante> est = edao.listadoEstudiante2();		
		return est;
	}
	
}
