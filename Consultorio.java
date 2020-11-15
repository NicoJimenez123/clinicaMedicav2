import java.util.List;

/**
 * @author Nicolas Jimenez
 * @version 1.0
 * @created 15-nov.-2020 16:07:32
 */
public class Consultorio {

	private List<Laboratorio> laboratoriosAsociados;
	private Medico medico;
	private int numeroConsultorio;
	private Laboratorio m_Laboratorio;

	public Consultorio(){

	}

	public List<Laboratorio> getLaboratoriosAsociados() {
		return laboratoriosAsociados;
	}

	public void setLaboratoriosAsociados(List<Laboratorio> laboratoriosAsociados) {
		this.laboratoriosAsociados = laboratoriosAsociados;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public int getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(int numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	public Laboratorio getLaboratorio() {
		return m_Laboratorio;
	}

	public void setLaboratorio(Laboratorio m_Laboratorio) {
		this.m_Laboratorio = m_Laboratorio;
	}

	public void derivarLaboratorio(){

	}

}