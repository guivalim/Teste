module br.com.logicaProgramacao.osIncriveis {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    exports br.com.logicaProgramacao.osIncriveis;
    opens br.com.logicaProgramacao.osIncriveis to javafx.fxml;

    opens br.com.logicaProgramacao.osIncriveis.controller to javafx.fxml;
}
