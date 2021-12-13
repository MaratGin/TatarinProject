package org.openjfx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class GameField implements Initializable {

    @FXML
    public Label timer_str;

    public void initialize(URL location, ResourceBundle resources) {
        setTimer();
    }

    public void setTimer() {
        AtomicInteger time = new AtomicInteger(60);
        Timeline timeline = new Timeline (
                new KeyFrame (
                        Duration.millis(1000), //1000 мс * 60 сек = 1 мин
                        ae -> {
                            timer_str.setText("Осталось времени: "+ time);
                            time.getAndDecrement();
                            System.out.println("Жопа");
                        }
                )
        );

        timeline.setCycleCount(60); //Ограничим число повторений
        timeline.play();
    }
}



