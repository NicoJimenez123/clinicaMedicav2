import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.*;
/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 03-nov.-2020 09:21:53
 */
public class SistemaInterno {

	private List<Turno> turnos;
	private List<AreaMedica> areasMedicas;
	private List<Paciente> pacientes;
	
	public SistemaInterno(){
		// Habria que hacer un metodo para rellenar estos atributos y no tener que escribir a cada rato
		this.turnos = new ArrayList<Turno>();
		this.areasMedicas = new ArrayList<AreaMedica>();
		this.pacientes = new ArrayList<Paciente>();
	}
	
	public int cantidadEstudiosRealizados(){
		int estudiosRealizados = Laboratorio.getCantEstudiosRealizados();
		return estudiosRealizados;
	}

	public List<Paciente> contarInasistenciasPacientes(){
		List<Paciente> pacientesInasistentes = new ArrayList<Paciente>();
		HashMap<Paciente, Integer> pacientesEInasistencias = new HashMap<Paciente,Integer>();
		// Reviso los turnos que no fueron concurridos
		for(Turno t : this.turnos) {
			if(!t.fueConcurrido()) {
				// Voy contando las inasistencias por paciente mientras lo guardo en un diccionaro del tipo Paciente-Inasistencias
				Paciente p = t.getPaciente();
				Integer i = 0;
				if(pacientesEInasistencias.containsKey(t.getPaciente())) {
					// Pregunto si el paciente ya se encuentra en la lista y si lo está le sumo una inasistencia
					i = pacientesEInasistencias.get(p) + 1;
					pacientesEInasistencias.put(p, i);
				}
				else {
					// Si el paciente no esta en la lista, lo agrego con una asistencia
					pacientesEInasistencias.put(p, 1);
				}
			}
			// Si fue concurrido no hago nada
		}
		// Una vez que tengo a los pacientes y sus inasistencias, voy comparando las inasistencias con el numero permitido de ellas.
		int inasistenciasMaximas = 3;
		for(Paciente p : pacientesEInasistencias.keySet()) {
			if(pacientesEInasistencias.get(p) >= inasistenciasMaximas) {
				// Si supera las inasistencias maximas lo agrego a la lista de pacientes a llamar por el personal administrativo
				pacientesInasistentes.add(p);
			}
		}
		return pacientesInasistentes;
	}
	
	public void prestacionesBrindadas(){
		// Metodo para obtener un reporte de la cantidad de prestaciones brindadas por cada metodo
		/*
		HashMap<Medico,Integer> medicos = new HashMap<Medico,Integer>();
		for(Medico m : this.prestaciones.getMedico()) {
			medicos.put(m, new Integer(m.getAsistenciasRegistradas()));
		}
		return medicos;
		*/
	}
	
	public boolean brindarTurno(int consultorio, float costo, LocalDate fecha, LocalTime horaFinalizacion, LocalTime horaInicio, Paciente paciente){
		List<Turno> turnosFechaIndicada = new ArrayList<Turno>();
		for(Turno t : this.turnos) {
			// Voy recorriendo los turnos
			if(t.getFecha().isEqual(fecha)) {
				// Si la fecha del turno es igual a la pasada por parametro, agrego el turno a la lista
				turnosFechaIndicada.add(t);
			}
		}
		boolean band = false; // bandera para saber si se encontró un turno con la misma horaInicio que el pasado por parametro.
		for(Turno t : turnosFechaIndicada) {
			// Voy recorriendo cada turno y hago la comparacion
			if(t.getHoraInicio().compareTo(horaInicio) == 1) {
				// Si ambos turnos empiezan a la misma hora ya no puedo crear uno con los parametros pasados
				band = true;
			}
		}
		// Ahora pregunto el estado de la bandera para saber si hubo algun turno con el que se superpondria
		if(band) {
			// Si hubo algun turno con la misma hora de inicio, no puedo crear uno
			return false;
		}
		//por el contrario creo el turno y aviso con el return true que pudo ser creado
		Turno turno = new Turno(consultorio, costo, fecha, horaFinalizacion, horaInicio, paciente);
		this.turnos.add(turno);
		paciente.anadirTurno(turno);
		return true;
	}

	public List<Especialidad> especialidadesTurnosDisponibles(){
		// Voy a desarrollar el metodo en base a que se pregunta por los turnos que se pueden dar en el dia de la fecha
		return null;
	}

	public List<Turno> verTurnos(Paciente p){
		return p.getTurnos();
	}




	
	public void concurrirTurno(int nro){
		//confirmo si el cliente tiene turno
		for(Paciente estePaciente : this.pacientes){
			if(estePaciente.getDni.equals(nro)){
				for(Turno esteTurnoLista : estePaciente.turnos){
					if(esteTurnoLista.programadoParaHoy() && !esteTurnoLista.fueConcurrido()){
						estePaciente.abonar();
						esteTurnoLista.fueConcurrido(true);
						break;
					}
				}
				break;
			}
			
		}
		

	}


	public Turno consultarTurno(int nro){
		//reviso la lista de pacientes
		for(Paciente estePaciente : this.pacientes){
			//busco un paciente que tenga el dni igial al pasado por parametro
			if(estePaciente.getDni().equals(nro))
				//retorno el ultimo turno agregado
				/*NOTA: asumo que el sistema apila los turnos ordenandolos del mas antiguo al mas nuevo*/
				return estePaciente.turnos.get(estePaciente.turnos.size -1);

		}
		return null;
	}



	public void agregarPaciente(Paciente paciente){
		this.pacientes.add(paciente);
	}

	public void agregarAreaMedica(AreaMedica areaMedica){
		this.areasMedicas.add(areaMedica);
	}






}