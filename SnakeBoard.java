package com.example.snakeladder;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SnakeBoard {
    AnchorPane root;

    SnakeBoard() throws IOException {
        root = FXMLLoader.load(getClass().getResource("SnakeBoard.fxml"));

    }
}
