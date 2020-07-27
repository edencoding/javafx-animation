package com.edencoding.controllers;

import com.edencoding.animation.SimpleAnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    public VBox backgroundPane;
    public Label FPSLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SimpleAnimationTimer timer = new SimpleAnimationTimer() {
            @Override
            public void tick() {
            }
        };
        timer.start();
        FPSLabel.textProperty().bindBidirectional(timer.frameRateProperty(), new NumberStringConverter("FPS: "));
    }

    @FXML
    private void handleGitButtonClicked(ActionEvent event) {
        new Application() {
            @Override
            public void start(Stage stage) {
            }
        }.getHostServices().showDocument("https://github.com/edencoding/javafx-ui/");
        event.consume();
    }

    @FXML
    private void handleExitButtonClicked(ActionEvent event) {
        Platform.exit();
        event.consume();
    }
}
