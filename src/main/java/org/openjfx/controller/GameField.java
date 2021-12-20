package org.openjfx.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class GameField implements Initializable {

    @FXML
    public ImageView pudge;

    @FXML
    public Label timer_str;

    private boolean isGameFinished = false;

    public void initialize(URL location, ResourceBundle resources) {

        setTimer();
        pudge.setImage(new Image(getClass().getResourceAsStream("/img/pudge_model.png")));
        pudge.setFitHeight(131);
        pudge.setFitWidth(201);

    }

    private void setTimer() {
        AtomicInteger time = new AtomicInteger(5);
        Timeline timeline = new Timeline (
                new KeyFrame (
                        Duration.millis(1000), //1000 мс * 60 сек = 1 мин
                        ae -> {
                            pudge.setTranslateX(100);
                            timer_str.setText("Осталось времени: "+ time);
                            time.getAndDecrement();
                            System.out.println("Жопа");
                            if (time.get()==-2) {
                                isGameFinished = true;
                                moveFuther();
                            }
                        }
                )
        );

        timeline.setCycleCount(60); //Ограничим число повторений
        timeline.play();
    }

    private void moveFuther() {
        try {
            App.setRoot("endScreen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void shotPudge(){


    }
}



