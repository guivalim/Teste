package br.com.logicaProgramacao.osIncriveis.model;

import java.io.File;

public class Construcao {

    private String cor;
    private String localizacao;
    private int andar;

    public Construcao() {
    }

    public Construcao(String cor, String localizacao, int andar) {
        this.cor = cor;
        this.localizacao = localizacao;
        this.andar = andar;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public void salvar() {
        File pasta = new File("arquivosCSV");
        if (!pasta.exists()) {
            pasta.mkdir();
        }
        File arquivo = new File(pasta, "construcao.csv");
        String[] cabecalho = arquivo.exists() ? null : new String[]{"COR", "LOCALIZACAO", "ANDAR"};
        String[][] dados = {
                {getCor(), getLocalizacao(), String.valueOf(getAndar())}
        };
        CsvEscritaLeitura csv = new CsvEscritaLeitura();
        csv.escreverCSV(arquivo.getPath(), cabecalho, dados);
    }
}
