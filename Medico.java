

/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 15-nov.-2020 16:07:32
 */
public class Medico {

	private Especialidad especialidad;
	private String nombre;

	public Medico(){

	}
	public Medico(String n, Especialidad e){
		this.nombre = n;
		this.especialidad = e;
	}
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void cargarEstudio(){

	}

	public void cargarReceta(){

	}

	public void registrarAsistencia(){

	}

}