package interciclo.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import interciclo.datos.HorarioDAO;
import interciclo.datos.LugaNiveDAO;
import interciclo.modulos.Horarios;
import interciclo.modulos.LugarNivelacion;

@Path("/lugar")
public class LugarService {
	
	@Inject
	private LugaNiveDAO ldao;
	
	@Inject
	private HorarioDAO hdao;
	
	
	@GET
	@Path("/listalug")
	@Produces("application/json")
	public List<LugarNivelacion> listadoTutor() {
		List<LugarNivelacion> lug = ldao.listadoLugNive();	
		return lug;
	}
	
	@GET
	@Path("/listahor")
	@Produces("application/json")
	public List<Horarios> listadoHor() {
		List<Horarios> hor = hdao.listarHorarios();
		return hor;
	}

}
