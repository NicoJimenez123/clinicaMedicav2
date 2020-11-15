

/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 15-nov.-2020 16:07:32
 */
public class Paciente {

	private String apellido;
	private int dni;
	private String domicilio;
	private String nombre;
	private String numeroTelefono;
	private Turno turnos;
	private Turno m_Turno;
	private SistemaInterno m_SistemaInterno;

	public Paciente(){

	}

	public void finalize() throws Throwable {

	}

	public boolean abonar(){
		return false;
	}

}