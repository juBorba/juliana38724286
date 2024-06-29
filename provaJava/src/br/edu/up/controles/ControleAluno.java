package br.edu.up.controles;

import java.util.List;
import java.util.ArrayList;
import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Aluno;

public class ControleAluno {
    private List<Aluno> alunos;
    private GerenciadorDeArquivos gArquivos;

    public ControleAluno() {
        this.alunos = new ArrayList<>();
        this.gArquivos = new GerenciadorDeArquivos();
    }

    public void incluir(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public boolean gravarDados() {
        return gArquivos.gravar(alunos);
    }
}
