package br.com.logicaProgramacao.osIncriveis.controller;

import br.com.logicaProgramacao.osIncriveis.model.Construcao;
import br.com.logicaProgramacao.osIncriveis.model.MeioInformacao;
import br.com.logicaProgramacao.osIncriveis.model.TransporteMarinho;
import br.com.logicaProgramacao.osIncriveis.utils.AlertUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class telaEX3Controller {

        @FXML
        private Button btn_salvar;

        @FXML
        private ComboBox<String> cbox_construcao_andar;

        @FXML
        private ComboBox<String> cbox_informacao_fonte;

        @FXML
        private ComboBox<String> cbx_transMarinho_embarcacao;

        @FXML
        private Tab tab_construcao;

        @FXML
        private Tab tab_informacao;

        @FXML
        private Tab tab_transporteMarinho;

        @FXML
        private TabPane tbp_exe3;

        @FXML
        private TextField txf_construcao_cor;

        @FXML
        private TextField txf_construcao_localizacao;

        @FXML
        private TextField txf_informacao_qtdPalavras;

        @FXML
        private TextField txf_informacao_titulo;

        @FXML
        private TextField txtf_transMarinho_comprimento;

        @FXML
        private TextField txtf_transMarinho_material;

    @FXML
    public void initialize() {
        // Popula ComboBoxes
        ObservableList<String> opcoesAndar = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        cbox_construcao_andar.setItems(opcoesAndar);
        cbox_construcao_andar.setValue("1");

        ObservableList<String> opcoesFonte = FXCollections.observableArrayList("Preto", "Azul", "Vermelho", "Verde", "Amarelo", "Branco");
        cbox_informacao_fonte.setItems(opcoesFonte);
        cbox_informacao_fonte.setValue("Preto");

        ObservableList<String> opcoesEmbarcacao = FXCollections.observableArrayList("Barco", "Navio", "Submarino");
        cbx_transMarinho_embarcacao.setItems(opcoesEmbarcacao);
        cbx_transMarinho_embarcacao.setValue("Barco");
    }

    @FXML
    void Click_salvar(ActionEvent event) {
        Tab abaSelecionada = tbp_exe3.getSelectionModel().getSelectedItem();

        // Compara diretamente com a aba do FXML, evitando erro de "aba desconhecida"
        if (abaSelecionada == tab_construcao) {
            salvarConstrucao();
        } else if (abaSelecionada == tab_informacao) {
            salvarInformacao();
        } else if (abaSelecionada == tab_transporteMarinho) {
            salvarTransMarinho();
        } else {
            AlertUtils.mostrarAlerta("Erro", "Aba desconhecida!");
        }
    }

    private void salvarConstrucao() {
        String cor = txf_construcao_cor.getText();
        String localizacao = txf_construcao_localizacao.getText();
        String andar = cbox_construcao_andar.getValue();

        if (cor.isEmpty() || localizacao.isEmpty() || andar == null) {
            AlertUtils.mostrarAlerta("Campos obrigatórios", "Preencha todos os campos da aba Construção!");
            return;
        }

        Construcao construcao = new Construcao(cor, localizacao, Integer.parseInt(andar));
        construcao.salvar();

        AlertUtils.mostrarAlerta("Sucesso", "Construção salva com sucesso!");

        txf_construcao_cor.clear();
        txf_construcao_localizacao.clear();
        cbox_construcao_andar.setValue("1");
    }

    private void salvarInformacao() {
        String titulo = txf_informacao_titulo.getText();
        String qtdPalavrasStr = txf_informacao_qtdPalavras.getText();
        String fonte = cbox_informacao_fonte.getValue();

        if (titulo.isEmpty() || qtdPalavrasStr.isEmpty() || fonte == null) {
            AlertUtils.mostrarAlerta("Campos obrigatórios", "Preencha todos os campos da aba Informação!");
            return;
        }

        int qtdPalavras;
        try {
            qtdPalavras = Integer.parseInt(qtdPalavrasStr);
        } catch (NumberFormatException e) {
            AlertUtils.mostrarAlerta("Erro", "Quantidade de palavras inválida!");
            return;
        }

        MeioInformacao info = new MeioInformacao(titulo, qtdPalavras, fonte);
        info.salvar();

        AlertUtils.mostrarAlerta("Sucesso", "Informação salva com sucesso!");

        txf_informacao_titulo.clear();
        txf_informacao_qtdPalavras.clear();
        cbox_informacao_fonte.setValue("Preto");
    }

    private void salvarTransMarinho() {
        String material = txtf_transMarinho_material.getText();
        String comprimentoStr = txtf_transMarinho_comprimento.getText();
        String embarcacao = cbx_transMarinho_embarcacao.getValue();

        if (material.isEmpty() || comprimentoStr.isEmpty() || embarcacao == null) {
            AlertUtils.mostrarAlerta("Campos obrigatórios", "Preencha todos os campos da aba Transporte Marinho!");
            return;
        }

        double comprimento;
        try {
            comprimento = Double.parseDouble(comprimentoStr);
        } catch (NumberFormatException e) {
            AlertUtils.mostrarAlerta("Erro", "Comprimento inválido!");
            return;
        }

        TransporteMarinho trans = new TransporteMarinho(material, comprimento, embarcacao);
        trans.salvar();

        AlertUtils.mostrarAlerta("Sucesso", "Transporte Marinho salvo com sucesso!");

        txtf_transMarinho_material.clear();
        txtf_transMarinho_comprimento.clear();
        cbx_transMarinho_embarcacao.setValue("Barco");
    }
}
