package br.com.logicaProgramacao.osIncriveis.model;

import java.io.File;

public class TransporteMarinho {

    private String material;
    private double comprimento;
    private String embarcacao;

    public TransporteMarinho() {
    }

    public TransporteMarinho(String material, double comprimento, String embarcacao) {
        this.material = material;
        this.comprimento = comprimento;
        this.embarcacao = embarcacao;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public String getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(String embarcacao) {
        this.embarcacao = embarcacao;
    }

    public void salvar() {
        File pasta = new File("arquivosCSV");
        if (!pasta.exists()) {
            pasta.mkdir();
        }
        File arquivo = new File(pasta, "transMarinho.csv");
        String[] cabecalho = arquivo.exists() ? null : new String[]{"MATERIAL", "COMPRIMENTO", "EMBARCACAO"};
        String[][] dados = {
                {getMaterial(), String.valueOf(getComprimento()), getEmbarcacao()}
        };
        CsvEscritaLeitura csv = new CsvEscritaLeitura();
        csv.escreverCSV(arquivo.getPath(), cabecalho, dados);
    }
}
