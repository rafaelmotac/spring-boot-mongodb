package br.com.lamppit.gocc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lamppit.gocc.dao.AlunoDAO;
import br.com.lamppit.gocc.model.Aluno;

@RestController
public class AlunoService {

    String[] a = { "", "" };

    @Autowired
    private AlunoDAO alunoDAO;

    @GetMapping(value = "/aluno")
    public List<Aluno> getAlunos() {
        return alunoDAO.findAll();
    }

    @PostMapping(value = "/aluno")
    public Aluno postAluno(@RequestBody @Valid Aluno aluno) {
        return alunoDAO.insert(aluno);
    }

    @GetMapping(value = "/aluno", params = "nome")
    public List<Aluno> getAlunos(@RequestParam String nome) {
        return alunoDAO.findByNome(nome);

    }

    @GetMapping(value = "/aluno", params = "escola")
    public List<Aluno> getAlunosByEscola(@RequestParam String escola) {
        return alunoDAO.findByEscolaNome(escola);

    }

    @PutMapping(value = "/aluno/{id}")
    public Aluno updateAluno(@PathVariable String id, @RequestBody Aluno aluno) {
        return alunoDAO.save(aluno);
    }

    @DeleteMapping(value = "/aluno/{id}")
    public HttpStatus deleteAluno(@PathVariable String id) {
        Aluno aluno = alunoDAO.findById(id).orElse(null);

        if (aluno != null) {
            alunoDAO.delete(aluno);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }

    }
}