package br.com.logicaProgramacao.osIncriveis.model;

import java.io.File;

public class MeioInformacao {

    private String titulo;
    private int qtdPalavras;
    private String fonte;

    public MeioInformacao() {
    }

    public MeioInformacao(String titulo, int qtdPalavras, String fonte) {
        this.titulo = titulo;
        this.qtdPalavras = qtdPalavras;
        this.fonte = fonte;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQtdPalavras() {
        return qtdPalavras;
    }

    public void setQtdPalavras(int qtdPalavras) {
        this.qtdPalavras = qtdPalavras;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public void salvar() {
        File pasta = new File("arquivosCSV");
        if (!pasta.exists()) {
            pasta.mkdir();
        }
        File arquivo = new File(pasta, "meioInformacao.csv");
        String[] cabecalho = arquivo.exists() ? null : new String[]{"TITULO", "QTDPALAVRAS", "FONTE"};
        String[][] dados = {
                {getTitulo(), String.valueOf(getQtdPalavras()), getFonte()}
        };
        CsvEscritaLeitura csv = new CsvEscritaLeitura();
        csv.escreverCSV(arquivo.getPath(), cabecalho, dados);
    }
}
