package br.com.votacao.votacao.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pautas {

	@Id
	private String id;
	private String nome;
	private String descricao;
    private String dataCadastro;

	public Pautas() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome da pauta não pode ser vazio")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "A descrição da pauta não pode ser vazia")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotEmpty(message = "A data do cacastro da pauta não pode ser vazio")
	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
    }
    
}