package beans;

public class MateriaBean {

	//Atributos
	private int idMateria;
	private String cpfPrefessor, nomeMateria;
	
	//Set & Get
	public String getNomeMateria() {
		return nomeMateria;
	}
	public String getCpfPrefessor() {
		return cpfPrefessor;
	}
	public void setCpfPrefessor(String cpfPrefessor) {
		this.cpfPrefessor = cpfPrefessor;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

}
