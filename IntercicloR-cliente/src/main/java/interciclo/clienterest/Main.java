package interciclo.clienterest;

import interciclo.modulos.Tutor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tutoresid tutid = new Tutoresid();
		
		Tutor tut = tutid.getTutor(1);
		System.out.println(tut);
		
		

	}

}
