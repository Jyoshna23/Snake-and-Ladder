package com.example.snakeladder;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SnakeGame {
    AnchorPane root;

    SnakeGame() throws IOException {
        root = FXMLLoader.load(getClass().getResource("SnakeGame.fxml"));
    }
}
