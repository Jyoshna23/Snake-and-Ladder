package com.example.snakeladder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class SnakeBoardController {

    @FXML
    Text number;

    @FXML
    Text turnname;

    @FXML
    ImageView player1;

    @FXML
    ImageView player2;

    int turn = 1;

    HashMap<Pair<Double,Double>, Pair<Double,Double>> SnakeLadderCoordinates;
    @FXML
    public void rolldice(MouseEvent event) throws IOException{
        getCoordinates();
        Random random = new Random();
        int randomnumber = random.nextInt(6) + 1;
        number.setText(""+ randomnumber);

        if(turn == 1) {
            double moveX = player1.getTranslateX();
            double moveY = player1.getTranslateY();

            Pair<Double,Double> p = movepieces(moveX,moveY,randomnumber);

            player1.setTranslateX(p.getKey());
            player1.setTranslateY(p.getValue());

            if(SnakeLadderCoordinates.containsKey(p)){
                player1.setTranslateX(SnakeLadderCoordinates.get(p).getKey());
                player1.setTranslateY(SnakeLadderCoordinates.get(p).getValue());
            }

            if(SnakeLadderCoordinates.containsKey((p))){
                if(p.getValue() > SnakeLadderCoordinates.get(p).getValue()){
                    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                    infoAlert.setHeaderText("Cheers!!");
                    infoAlert.setContentText("Yeah!!!, you Climbed the ladder :)");
                    infoAlert.showAndWait();
                }
                else if(p.getValue() < SnakeLadderCoordinates.get(p).getValue()){
                    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                    infoAlert.setHeaderText("Message");
                    infoAlert.setContentText("OOPS!!!, Snake hissed you :(");
                    infoAlert.showAndWait();
                }
            }

            checkWin(player1.getTranslateX(),player1.getTranslateY());

        }
        else
        {
            double moveX = player2.getTranslateX();
            double moveY = player2.getTranslateY();

            Pair<Double,Double> p = movepieces(moveX,moveY,randomnumber);

            player2.setTranslateX(p.getKey());
            player2.setTranslateY(p.getValue());
            if(SnakeLadderCoordinates.containsKey(p)){
                player2.setTranslateX(SnakeLadderCoordinates.get(p).getKey());
                player2.setTranslateY(SnakeLadderCoordinates.get(p).getValue());
            }

            if(SnakeLadderCoordinates.containsKey((p))){
                if(p.getValue() > SnakeLadderCoordinates.get(p).getValue()){
                    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                    infoAlert.setHeaderText("Cheers!!");
                    infoAlert.setContentText("Yeah!!!, you Climbed the ladder :)");
                    infoAlert.showAndWait();
                }
                else if(p.getValue() < SnakeLadderCoordinates.get(p).getValue()){
                    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                    infoAlert.setHeaderText("Message");
                    infoAlert.setContentText("OOPS!!!, Snake hissed you :(");
                    infoAlert.showAndWait();
                }
            }


            checkWin(player2.getTranslateX(),player2.getTranslateY());
        }
        if(randomnumber != 6){
            if(turn == 1){
                turnname.setText("Player 2 turn");
                turn = 2;
            }
            else{
                turnname.setText("Player 1 turn");
                turn = 1;
            }
        }

    }

    public Pair<Double,Double> movepieces(double moveX, double moveY , int randomnumber)
    {
//        Stack<Pair<Double,Double>> undo = new Stack<>();

        double X = moveX;
        double Y = moveY;

        if(moveY % 100 == 0)
        {
            moveX += randomnumber * 50;

            if(moveX > 500)
            {
                moveX = 500 * 2 - moveX + 50;
                moveY -= 50;
//                undo.push(new Pair<>(moveX,moveY));
            }
//            undo.push(new Pair<>(moveX,moveY));
        }else{
            moveX -= randomnumber * 50;
            if(moveX < 50)
            {
                if(moveY == -450)
                {
                    return new Pair<>(X,Y);
                }
                moveX = -1*(moveX-50);
                moveY -= 50;
//                undo.push(new Pair<>(moveX,moveY));
            }
//            undo.push(new Pair<>(moveX,moveY));
        }
        return new Pair<>(moveX,moveY);
    }


    public void getCoordinates(){
        SnakeLadderCoordinates = new HashMap<>();
        SnakeLadderCoordinates.put(new Pair<>(50.0,0.0),new Pair<>(150.0,-150.0));
        SnakeLadderCoordinates.put(new Pair<>(200.0,0.0),new Pair<>(350.0,-50.0));
        SnakeLadderCoordinates.put(new Pair<>(450.0,0.0),new Pair<>(500.0,-150.0));
        SnakeLadderCoordinates.put(new Pair<>(400.0,-100.0),new Pair<>(200.0,-400.0));
        SnakeLadderCoordinates.put(new Pair<>(50.0,-100.0),new Pair<>(100.0,-200.0));
        SnakeLadderCoordinates.put(new Pair<>(500.0,-250.0),new Pair<>(350.0,-300.0));
        SnakeLadderCoordinates.put(new Pair<>(500.0,-350.0),new Pair<>(500.0,-450.0));
        SnakeLadderCoordinates.put(new Pair<>(50.0,-350.0),new Pair<>(50.0,-450.0));

        SnakeLadderCoordinates.put(new Pair<>(200.0,-50.0),new Pair<>(350.0,0.0));
        SnakeLadderCoordinates.put(new Pair<>(350.0,-250.0),new Pair<>(350.0,-150.0));
        SnakeLadderCoordinates.put(new Pair<>(100.0,-300.0),new Pair<>(100.0,-50.0));
        SnakeLadderCoordinates.put(new Pair<>(200.0,-300.0),new Pair<>(50.0,-250.0));
        SnakeLadderCoordinates.put(new Pair<>(350.0,-400.0),new Pair<>(200.0,-100.0));
        SnakeLadderCoordinates.put(new Pair<>(400.0,-450.0),new Pair<>(400.0,-350.0));
        SnakeLadderCoordinates.put(new Pair<>(300.0,-450.0),new Pair<>(300.0,-350.0));
        SnakeLadderCoordinates.put(new Pair<>(150.0,-450.0),new Pair<>(100.0,-350.0));
    }

    void checkWin(Double X, Double Y) throws IOException{
        if(X == 50 && Y == -450) {
            Alert resultAlert = new Alert(Alert.AlertType.INFORMATION);
            resultAlert.setHeaderText("RESULT");
            if (X == 50.0 && Y == -450) {
                if (turn == 1) {
                    resultAlert.setContentText("Player 1 is Winner");
                    resultAlert.showAndWait();
                } else {
                    resultAlert.setContentText("Player 2 is Winner");
                    resultAlert.showAndWait();
                }
                SnakeGame start = new SnakeGame();
                HelloApplication.root.getChildren().setAll(start.root);
            }
        }
    }
}
