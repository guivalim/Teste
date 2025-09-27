package br.com.logicaProgramacao.osIncriveis.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvEscritaLeitura {

    public void escreverCSV(String caminhoArquivo, String[] cabecalho, String[][] dados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            // Cabeçalho só se for a primeira vez
            if (cabecalho != null) {
                writer.write(String.join(";", cabecalho));
                writer.newLine();
            }
            // Dados
            for (String[] linha : dados) {
                writer.write(String.join(";", linha));
                writer.newLine();
            }
            System.out.println("Arquivo salvo em: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> lerCSV(String caminhoArquivo, String separador) {
        List<String[]> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha.split(separador));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }
}










