import java.util.HashMap;
import java.util.List;

/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 15-nov.-2020 16:07:33
 */
public class SistemaInterno {

	public Laboratorio m_Laboratorio;

	public SistemaInterno(){

	}

	public boolean brindarTurno(){
		return false;
	}

	public int cantidadEstudiosRealizados(){
		return 0;
	}

	public void concurrirTurno(){

	}

	/**
	 * 
	 * @param dni
	 */
	public Turno consultarTurno(int dni){
		return null;
	}

	public List<Paciente> contarInasistenciasPacientes(){
		return null;
	}

	public HashMap<Medico,Integer> prestacionesBrindadas(){
		return null;
	}

}