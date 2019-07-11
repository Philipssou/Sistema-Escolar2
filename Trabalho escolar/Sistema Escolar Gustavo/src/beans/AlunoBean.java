package beans;

public class AlunoBean {

	// ATRIBUTOS
	private String cpfAluno, nomeAluno, senhaAluno, telefoneAluno, dataNascimentoAluno;
	private String enderecoAluno, nomeResponsavel, telefoneResponsavel;
	private String observacao;
	
	// SET & GET
	public String getCpfAluno() {
		return cpfAluno;
	}
	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getSenhaAluno() {
		return senhaAluno;
	}
	public void setSenhaAluno(String senhaAluno) {
		this.senhaAluno = senhaAluno;
	}
	public String getTelefoneAluno() {
		return telefoneAluno;
	}
	public void setTelefoneAluno(String telefoneAluno) {
		this.telefoneAluno = telefoneAluno;
	}
	public String getDataNascimentoAluno() {
		return dataNascimentoAluno;
	}
	public void setDataNascimentoAluno(String dataNascimentoAluno) {
		this.dataNascimentoAluno = dataNascimentoAluno;
	}
	public String getEnderecoAluno() {
		return enderecoAluno;
	}
	public void setEnderecoAluno(String enderecoAluno) {
		this.enderecoAluno = enderecoAluno;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}
	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
