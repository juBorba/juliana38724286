package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import br.edu.up.modelos.Aluno;
public class GerenciadorDeArquivos {
    private String nomeDoArquivo = "alunos.csv";

    public List<Aluno> lerAlunos(String nomeArquivoEntrada) {
        List<Aluno> listaDeAlunos = new ArrayList<>();

        try (Scanner leitor = new Scanner(new File(nomeDoArquivo))) {
            // Ignorar cabeçalho
            if (leitor.hasNextLine()) {
                leitor.nextLine(); // Ignorar cabeçalho
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String matricula = dados[0];
                String nome = dados[1];
                double nota = Double.parseDouble(dados[2]);

                Aluno aluno = new Aluno(matricula, nome, nota);
                listaDeAlunos.add(aluno);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return listaDeAlunos;
    }

    public boolean gravarEstatisticas(List<Aluno> alunos, String nomeArquivoSaida) {
        try (PrintWriter gravador = new PrintWriter(new FileWriter(nomeArquivoSaida))) {
            int aprovados = 0;
            int reprovados = 0;
            double menorNota = Double.MAX_VALUE;
            double maiorNota = Double.MIN_VALUE;
            double somaNotas = 0.0;

            for (Aluno aluno : alunos) {
                somaNotas += aluno.getNota();

                if (aluno.getNota() > 6.0) {
                    aprovados++;
                } else {
                    reprovados++;
                }

                if (aluno.getNota() < menorNota) {
                    menorNota = aluno.getNota();
                }

                if (aluno.getNota() > maiorNota) {
                    maiorNota = aluno.getNota();
                }
            }

            // Calcular média geral
            double mediaGeral = somaNotas / alunos.size();

            // Escrever estatísticas no arquivo
            gravador.println("Aprovados;Reprovados;Menor Nota;Maior Nota;Média Geral");
            gravador.println(aprovados + ";" + reprovados + ";" + menorNota + ";" + maiorNota + ";" + mediaGeral);

            return true;
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo de estatísticas: " + e.getMessage());
        }

        return false;
    }

    public boolean gravar(List<Aluno> alunos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }
}
