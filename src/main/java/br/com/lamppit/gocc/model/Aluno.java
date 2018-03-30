package br.com.lamppit.gocc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

// @Document(collection="Aluninhos")
public class Aluno {

    @Id
    private String id;

    @NotBlank(message="Aluno necessita de um nome, insira um nome.")
    @Size(max = 99, min = 6)
    private String nome;

    @NotNull(message="Aluno necessita de uma escola.")
    private Escola escola;

    @Override
    public String toString() {
        return String.format("Alunos[id= $s, name = $s", id, nome);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

	/**
	 * @return the escola
	 */
	public Escola getEscola() {
		return escola;
	}

	/**
	 * @param escola the escola to set
	 */
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
}