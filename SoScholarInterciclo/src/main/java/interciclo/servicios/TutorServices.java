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
import interciclo.datos.SolicitudCitaDAO;
import interciclo.datos.TutorDAO;
import interciclo.modulos.Calificacion;
import interciclo.modulos.Estudiante;
import interciclo.modulos.Horarios;
import interciclo.modulos.SolicitudCita;
import interciclo.modulos.Tutor;

@Path("/tutor")
public class TutorServices {

	

	@Inject
	private TutorDAO tdao;
	
	@Inject
	private SolicitudCitaDAO scdao;
	
	@Inject
	private CalificacionDAO cdao;
	
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
			tdao.guardarTutor(tut);;
			resp.setCodigo(1);
			resp.setMensaje("Registro satisfactorio");
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}
	
	
	@POST
	@Path("/newHorario")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta neHorario(Horarios hor, @QueryParam("id") int id) {
		Respuesta resp = new Respuesta();
		try {
			Tutor t = tdao.leer(id);
			t.addHorarios(hor);
			tdao.guardarTutor(t);
			resp.setCodigo(1);
			resp.setMensaje("Registro satisfactorio");
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}
	
	@GET
	@Path("/login")
	@Produces("application/json")
	public Tutor getTutorLO(@QueryParam("correo") String correo,@QueryParam("pass") String password) {
		if(correo!=null && password!=null) {
			ArrayList<Tutor> tutores=(ArrayList<Tutor>) tdao.listadotutorLog(correo, password);
			if(tutores.size()>0) {
				Tutor tut = tdao.leer(tutores.get(0).getTut_id());
				return tut;
			}
		}
		return new Tutor();
	}
	
	@GET
	@Path("/listasolP")
	@Produces("application/json")
	public ArrayList<SolicitudCita> listSolicitud(@QueryParam("id") int id) {
		Tutor t = tdao.leer(id);
		ArrayList<SolicitudCita> sc=(ArrayList<SolicitudCita>) scdao.listarSolicitud();

		ArrayList<SolicitudCita> sc2= new ArrayList<SolicitudCita>();//) a.getEmpresas();//empresaDao.listadoempresas();
		for (SolicitudCita s:sc) {
			if (s.getTutor().getTut_id()==id && s.getAceptado().equals("0")) {
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
		Tutor t = tdao.leer(id);
		ArrayList<SolicitudCita> sc=(ArrayList<SolicitudCita>) scdao.listarSolicitud();

		ArrayList<SolicitudCita> sc2= new ArrayList<SolicitudCita>();//) a.getEmpresas();//empresaDao.listadoempresas();
		for (SolicitudCita s:sc) {
			if (s.getTutor().getTut_id()==id && s.getAceptado().equals("1")) {
				s.setFecha(null);
				sc2.add(s);
			}
		}
		return sc2;
	}
	
	@GET
	@Path("/listasolN")
	@Produces("application/json")
	public ArrayList<SolicitudCita> listSolicitudN(@QueryParam("id") int id) {
		Tutor t = tdao.leer(id);
		ArrayList<SolicitudCita> sc=(ArrayList<SolicitudCita>) scdao.listarSolicitud();

		ArrayList<SolicitudCita> sc2= new ArrayList<SolicitudCita>();//) a.getEmpresas();//empresaDao.listadoempresas();
		for (SolicitudCita s:sc) {
			if (s.getTutor().getTut_id()==id && s.getAceptado().equals("-1")) {
				s.setFecha(null);
				sc2.add(s);
			}
		}
		return sc2;
	}
	
	
	@GET
	@Path("/aceptado")
	@Produces("application/json")
	public Respuesta listSolicitudAtdo(@QueryParam("id") int id, @QueryParam("acep") String est) {
		SolicitudCita sc= scdao.leer(id);
		Respuesta resp = new Respuesta();
		try {
			sc.setAceptado(est);
			scdao.Guardar(sc);
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
		Tutor tut=tdao.leer(idE);
		System.out.println("holaa>>>>>"+tut.getTut_apellido());
		SolicitudCita scCita=scdao.leer(id);
		Respuesta resp = new Respuesta();
		ArrayList<Calificacion> listcal=(ArrayList<Calificacion>) cdao.listacalifT(scCita, tut);
		try {
			Date d=new Date();
			if(d.after(scCita.getFecha())) {
				if (listcal.size()>0) {
					listcal.get(0).setDescripcion(r.getMensaje());		
					listcal.get(0).setDescripcion(r.getMensaje());
					listcal.get(0).setEsp_calificacion(cal);
					listcal.get(0).setTutor(tut);
					listcal.get(0).setSolicitudCita(scCita);
					cdao.guardar(listcal.get(0));
					resp.setCodigo(1);
					resp.setMensaje("Registro satisfactorio");
					
				}else {
					ca.setDescripcion(r.getMensaje());
					ca.setEsp_calificacion(cal);
					ca.setTutor(tut);
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
	
	

}
