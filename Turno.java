import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 15-nov.-2020 16:07:33
 */
public class Turno {

	private Consultorio consultorio;
	private float costo;
	private boolean enCurso;
	private LocalDate fecha;
	private boolean fueAbonado;
	private boolean fueConcurrido;
	private LocalTime horaFinalizacion;
	private LocalTime horaInicio;
	private Paciente Paciente;
	private int turnoID;
	public Consultorio m_Consultorio;
	private SistemaInterno m_SistemaInterno;

	public Turno(){

	}

	public void finalize() throws Throwable {

	}

	public boolean programadoParaHoy(){
		return false;
	}

	public void turnoConcurrido(){

	}

}