package br.edu.up.modelos;

public class Aluno {
    private String matricula;
    private String nome;
    private double nota;

    public Aluno(String matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public String toCSV() {
        return matricula + ";" + nome + ";" + nota;
    }
}
