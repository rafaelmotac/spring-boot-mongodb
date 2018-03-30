package br.com.lamppit.gocc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lamppit.gocc.model.Aluno;

public interface AlunoDAO extends MongoRepository<Aluno, String> {
    public List<Aluno> findByNome(String nome);

    public List<Aluno> findByEscolaNome(String nome);
}