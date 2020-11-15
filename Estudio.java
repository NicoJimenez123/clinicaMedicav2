import java.time.LocalDate;

/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 15-nov.-2020 16:07:32
 */
public class Estudio {

	private boolean asistencia;
	private LocalDate fechaRealizar;

	public Estudio(){

	}

	public boolean isAsistencia() {
		return asistencia;
	}

	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}

	public LocalDate getFechaRealizar() {
		return fechaRealizar;
	}

	public void setFechaRealizar(LocalDate fechaRealizar) {
		this.fechaRealizar = fechaRealizar;
	}

}