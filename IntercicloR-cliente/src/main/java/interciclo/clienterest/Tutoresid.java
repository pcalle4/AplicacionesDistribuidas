package interciclo.clienterest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import interciclo.modulos.Tutor;

public class Tutoresid {

	private String WS_GET_ID= "http://localhost:8080/intercicloR/srv/web/tutorid";
	private String WS_GET_CEDULA= "http://localhost:8080/intercicloR/srv/web/tutorcedula";
	
	public Tutor getTutor(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(
				WS_GET_ID).queryParam("id", id);
		Tutor tutor = target.request().get(Tutor.class);
		client.close();
		return tutor;
	}
	
	public Tutor gethorarios(String cedula) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(
				WS_GET_CEDULA).queryParam("cedula", cedula);
		Tutor tutorced = target.request().get(Tutor.class);
		client.close();
		return tutorced;
	}
}
