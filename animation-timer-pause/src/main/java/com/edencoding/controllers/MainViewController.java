package com.edencoding.controllers;

import com.edencoding.animation.PausableAnimationTimer;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    public VBox backgroundPane;
    public Button playPauseSwitch;
    public Label timerClock;

    PausableAnimationTimer timer = new PausableAnimationTimer() {
        @Override
        public void tick(long animationTime) {
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timer.start();
        timerClock.textProperty().bindBidirectional(timer.animationDurationProperty(), new NumberStringConverter("Animation Duration: "));
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

    public void resetTimer(ActionEvent event) {
        timer.start();
        event.consume();
    }


    public void stopTimer(ActionEvent event) {
        timer.stop();
        playPauseSwitch.getStyleClass().remove("pause");
        playPauseSwitch.getStyleClass().add("play");
        event.consume();
    }

    public void playPauseSwitchPressed(ActionEvent event) {
        if (!timer.isActive()) {
            timer.start();
            playPauseSwitch.getStyleClass().remove("play");
            playPauseSwitch.getStyleClass().add("pause");
        } else {
            if (timer.isPaused()) {
                timer.play();
                playPauseSwitch.getStyleClass().remove("play");
                playPauseSwitch.getStyleClass().add("pause");
            } else {
                timer.pause();
                playPauseSwitch.getStyleClass().remove("pause");
                playPauseSwitch.getStyleClass().add("play");
            }
        }
    }
}
