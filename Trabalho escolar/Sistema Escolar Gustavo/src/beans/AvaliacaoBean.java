package beans;

public class AvaliacaoBean {

	
	//Atributos
	private int idAvaliacao, idTurma, idMateria;
	private String nomeAvaliacao, cpfProfessor, dataAvaliacao;
	
	//Set & Get
	public int getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getNomeAvaliacao() {
		return nomeAvaliacao;
	}
	public void setNomeAvaliacao(String nomeAvaliacao) {
		this.nomeAvaliacao = nomeAvaliacao;
	}
	public String getCpfProfessor() {
		return cpfProfessor;
	}
	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}
	public String getDataAvaliacao() {
		return dataAvaliacao;
	}
	public void setDataAvaliacao(String dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

}
