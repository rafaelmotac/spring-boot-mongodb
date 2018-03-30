package br.com.lamppit.gocc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lamppit.gocc.model.Escola;

public interface EscolaDAO extends MongoRepository<Escola, String> {

}