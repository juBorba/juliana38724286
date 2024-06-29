package br.edu.up;

import br.edu.up.controles.ControleAluno;
import br.edu.up.modelos.Aluno;
import br.edu.up.daos.GerenciadorDeArquivos;

import java.util.List;

public class Programa {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "alunos.csv"; // Nome do arquivo de entrada
        String nomeArquivoSaida = "resumo.csv"; // Nome do arquivo de saída

        // Criar instância do controlador
        ControleAluno controleAluno = new ControleAluno();
        GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();

        // Ler os alunos do arquivo
        List<Aluno> alunos = gerenciadorDeArquivos.lerAlunos(nomeArquivoEntrada);

        // Adicionar alunos ao controle
        for (Aluno aluno : alunos) {
            controleAluno.incluir(aluno);
        }

        // Calcular estatísticas e gravar no arquivo CSV
        if (gerenciadorDeArquivos.gravarEstatisticas(controleAluno.getAlunos(), nomeArquivoSaida)) {
            System.out.println("Estatísticas calculadas e gravadas em " + nomeArquivoSaida);
        } else {
            System.out.println("Erro ao calcular e gravar estatísticas.");
        }
    }
}
