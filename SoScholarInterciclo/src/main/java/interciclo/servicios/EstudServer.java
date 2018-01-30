package interciclo.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import interciclo.datos.CalificacionDAO;
import interciclo.datos.EstudianteDAO;
import interciclo.datos.HorarioDAO;
import interciclo.datos.LugaNiveDAO;
import interciclo.datos.SolicitudCitaDAO;
import interciclo.datos.TutorDAO;
import interciclo.modulos.Calificacion;
import interciclo.modulos.Estudiante;
import interciclo.modulos.Horarios;
import interciclo.modulos.LugarNivelacion;
import interciclo.modulos.SolicitudCita;
import interciclo.modulos.Tutor;

@Path("/estudiante")
public class EstudServer {

	@Inject
	private EstudianteDAO edao;
	
	@Inject
	private SolicitudCitaDAO scdao;
	
	@Inject
	private HorarioDAO hdao;
	
	@Inject
	private LugaNiveDAO ldao;
	
	@Inject
	private TutorDAO tdao;
	@Inject
	private CalificacionDAO cdao;
	
	
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
	
	@POST
	@Path("/editar")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta editEstu(Estudiante est) {
		Respuesta resp = new Respuesta();
		try {
			edao.guardarEstudiante(est);
			resp.setCodigo(1);
			resp.setMensaje("Registro satisfactorio");
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}
	
	@POST
	@Path("/editadministrador")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta editAdministrador(Estudiante est, @QueryParam("id") int id) {
		Respuesta resp = new Respuesta();
		try {
			Estudiante estudiante=edao.leer(id);
			estudiante.setEst_nombre(est.getEst_nombre());
			
			edao.guardarEstudiante(estudiante);
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
	
	@GET
	@Path("/eliminar")
	@Produces("application/json")
	public Respuesta elimiEst(@QueryParam("id") int id) {
		Respuesta resp = new Respuesta();
		try {
			edao.borrar(id);
			resp.setCodigo(1);
			resp.setMensaje("Registro eliminado");
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error al eliminar registro");
		}			
		return resp;
	}
	
	@GET
	@Path("/login")
	@Produces("application/json")
	public Estudiante getEstudianteLO(@QueryParam("correo") String correo,@QueryParam("pass") String password) {
		if(correo!=null && password!=null) {
			ArrayList<Estudiante> estudiantes=(ArrayList<Estudiante>) edao.listadousuarioLog(correo, password);
			if(estudiantes.size()>0) {
				Estudiante est = edao.leer(estudiantes.get(0).getEst_id());
				return est;
			}
		}
		return new Estudiante();
	}
	
	@GET
	@Path("/listasol")
	@Produces("application/json")
	public ArrayList<SolicitudCita> listSolicitud(@QueryParam("id") int id) {
		Estudiante e = edao.leer(id);
		ArrayList<SolicitudCita> sc=(ArrayList<SolicitudCita>) scdao.listarSolicitud();

		ArrayList<SolicitudCita> sc2= new ArrayList<SolicitudCita>();//) a.getEmpresas();//empresaDao.listadoempresas();
		for (SolicitudCita s:sc) {
			if (s.getEstudiante().getEst_id()==id && s.getAceptado().equals("0")) {
				s.setFecha(null);
				sc2.add(s);
			}
		}
		return sc2;
	}
	
	@GET
	@Path("/listasolA")
	@Produces("application/json")
	public ArrayList<SolicitudCita> listSolicitudA(@QueryParam("id") int id) {
		Estudiante e = edao.leer(id);
		ArrayList<SolicitudCita> sc=(ArrayList<SolicitudCita>) scdao.listarSolicitud();

		ArrayList<SolicitudCita> sc2= new ArrayList<SolicitudCita>();//) a.getEmpresas();//empresaDao.listadoempresas();
		for (SolicitudCita s:sc) {
			if (s.getEstudiante().getEst_id()==id && s.getAceptado().equals("1")) {
				s.setFecha(null);
				sc2.add(s);
			}
		}
		return sc2;
	}
	
	
	
	/*@GET
	@Path("/newSolicitud")
	@Produces("application/json")
	public Respuesta saveUsuario(@QueryParam("est") int id_est, @QueryParam("hor") int id_hor, @QueryParam("lug") int id_lug, @QueryParam("tut") int id_tut) {
		Respuesta resp=new Respuesta();
		try {
			
			Estudiante e=edao.leer(id_est);
			Horarios h=hdao.leer(id_hor);
			LugarNivelacion l=ldao.leer(id_lug);
			Tutor t=tdao.leer(id_tut);
			SolicitudCita sc=new SolicitudCita();
			Date d=new Date("06/05/1994");
			sc.setFecha(d);
			sc.setEstudiante(e);
			sc.setHorarios(h);
			sc.setLugarNivelaciones(l);
			sc.setTutor(t);
			scdao.Guardar(sc);
			resp.setCodigo(1);
			resp.setMensaje("Registro satisfactorio");
			
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}*/
	
	@POST
	@Path("/newSolicitud")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta saveUsuario(SolicitudCita solicitud, @QueryParam("fecha") String fecha, @QueryParam("id") int id) {
		Respuesta resp=new Respuesta();
		Estudiante est=edao.leer(id);
		
		try {
			//"06/05/1994"
			Date d=new Date(fecha);
			solicitud.setFecha(d);
			solicitud.setEstudiante(est);
			scdao.Guardar(solicitud);
			resp.setCodigo(1);
			resp.setMensaje("Registro satisfactorio");
			
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}
	
	@POST
	@Path("/calificacion")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta calificacion(Respuesta r, @QueryParam("id") int id, @QueryParam("idE") int idE, @QueryParam("cal") int cal) {
		Calificacion ca=new Calificacion();
		Estudiante est=edao.leer(idE);
		System.out.println("holaa>>>>>"+est.getEst_apellido());
		SolicitudCita scCita=scdao.leer(id);
		Respuesta resp = new Respuesta();
		ArrayList<Calificacion> listcal=(ArrayList<Calificacion>) cdao.listacalif(scCita, est);
		try {
			Date d=new Date();
			if(d.after(scCita.getFecha())) {
				if (listcal.size()>0) {
					listcal.get(0).setDescripcion(r.getMensaje());		
					listcal.get(0).setDescripcion(r.getMensaje());
					listcal.get(0).setEsp_calificacion(cal);
					listcal.get(0).setEstudiante(est);
					listcal.get(0).setSolicitudCita(scCita);
					cdao.guardar(listcal.get(0));
					resp.setCodigo(1);
					resp.setMensaje("Registro satisfactorio");
					
				}else {
					ca.setDescripcion(r.getMensaje());
					ca.setEsp_calificacion(cal);
					ca.setEstudiante(est);
					ca.setSolicitudCita(scCita);
					cdao.guardar(ca);
					resp.setCodigo(1);
					resp.setMensaje("Registro satisfactorio");
				}
			}else {
				resp.setCodigo(1);
				resp.setMensaje("Aun no fue la cita");
				
			}
			
			
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}
	
	
	@GET
	@Path("/cometarios")
	@Produces("application/json")
	public ArrayList<Calificacion> cometarios(@QueryParam("id") int id) {
		List<Calificacion> calificaciones=cdao.listadoCalificaciones();
		ArrayList<Calificacion> cns= new ArrayList<Calificacion>();
		for(Calificacion c: calificaciones) {
			if(c.getSolicitudCita().getTutor().getTut_id()==id && c.getTutor()==null) {
				cns.add(c);
			}
		}
		
		return cns;
	}
	
}
