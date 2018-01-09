package interciclo.servicios;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import interciclo.datos.HorarioDAO;
import interciclo.modulos.Horarios;

@Path("Horarios")
public class HorariosServices {

	private HorarioDAO hdao;
	
	@GET
	@Path("/lista")
	@Produces("application/json")
	public List<Horarios> listarHorarios2(){
		List<Horarios> hor = hdao.listarHorarios2();
		return hor;
	}
}
