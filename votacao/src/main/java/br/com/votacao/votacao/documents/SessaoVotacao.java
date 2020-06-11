package br.com.votacao.votacao.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SessaoVotacao {
    @Id
    private String id;
    private String data_hora_inicio;
    private String data_hora_fim;
    private String status;

    public SessaoVotacao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotEmpty(message = "Data e hora de inicio da sessão de votação não pode ser nulo")
    public String getDataHoraInicio() {
        return data_hora_inicio;
    }

    public void setDataHoraInicio(String data_hora_inicio) { this.data_hora_inicio = data_hora_inicio; }

    @NotEmpty(message = "Data e hora de fim da sessão de votação não pode ser nulo")
    public String getDataHoraFim() {
        return data_hora_fim;
    }

    public void setDataHoraFim(String data_hora_fim) { this.data_hora_fim = data_hora_fim; }

    @NotEmpty(message = "Status não pode ser nulo")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
