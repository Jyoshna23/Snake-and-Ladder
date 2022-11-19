package com.example.snakeladder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SnakeGameController {

    @FXML

    public void start(MouseEvent event) throws IOException {
        System.out.println("Start");
        AnchorPane start;
        start = FXMLLoader.load(getClass().getResource("SnakeBoard.fxml"));
        HelloApplication.root.getChildren().setAll(start);

    }
}
