import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 15-nov.-2020 16:07:33
 */
public class Turno {
	public static int ultimoIDDisponible = 0;
	
	private int consultorio;
	private float costo;
	private boolean enCurso;
	private LocalDate fecha;
	private boolean fueAbonado;
	private boolean fueConcurrido;
	private LocalTime horaFinalizacion;
	private LocalTime horaInicio;
	private Paciente Paciente;
	private int turnoID;
	
	public Turno(int consultorio, float costo, LocalDate fecha, LocalTime horaFinalizacion, LocalTime horaInicio, Paciente paciente) {
		this.consultorio = consultorio;
		this.costo = costo;
		this.enCurso = false;
		this.fecha = fecha;
		this.fueAbonado = false;
		this.fueConcurrido = false;
		this.horaFinalizacion = horaFinalizacion;
		this.horaInicio = horaInicio;
		this.Paciente = paciente;
		this.turnoID = Turno.ultimoIDDisponible;
		Turno.ultimoIDDisponible++;
	}
	
	public int getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(int consultorio) {
		this.consultorio = consultorio;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public boolean enCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean fueAbonado() {
		return fueAbonado;
	}

	public void setFueAbonado(boolean fueAbonado) {
		this.fueAbonado = fueAbonado;
	}

	public boolean fueConcurrido() {
		return fueConcurrido;
	}

	public void setFueConcurrido(boolean fueConcurrido) {
		this.fueConcurrido = fueConcurrido;
	}

	public LocalTime getHoraFinalizacion() {
		return horaFinalizacion;
	}

	public void setHoraFinalizacion(LocalTime horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Paciente getPaciente() {
		return Paciente;
	}

	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}

	public int getTurnoID() {
		return turnoID;
	}

	public void setTurnoID(int turnoID) {
		this.turnoID = turnoID;
	}

	public boolean programadoParaHoy(){
		return false;
	}

	public void turnoConcurrido(){

	}

}