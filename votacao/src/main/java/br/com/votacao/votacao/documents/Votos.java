package br.com.votacao.votacao.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Votos {

	@Id
	private String id;
	private String cpf_associado;
	private String id_pauta;
	private String voto;

	public Votos() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "CPF não pode ser vazio")
	@CPF(message = "CPF inválido")
	public String getCpfAssociado() {
		return cpf_associado;
	}

	public void setCpfAssociado(String cpf_associado) {
		this.cpf_associado = cpf_associado;
	}

	@NotEmpty(message = "Pauta para votacção não pode ser vazia")
	public String getIdPauta() {
		return id_pauta;
	}

	public void setIdPauta(String id_pauta) {
		this.id_pauta = id_pauta;
    }
    
    @NotEmpty(message = "Voto não pode ser nulo")
	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

}