import java.util.List;

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
	private List<Turno> turnos;

	public Paciente(){

	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void anadirTurno(Turno turno) {
		this.turnos.add(turno);
	}

	public boolean abonar(){
		return false;
	}

}