/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author AJC
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane pane0;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private Pane pane6;
    @FXML
    private Pane pane7;
    @FXML
    private Pane pane8;

    public Color player1Color = Color.BLACK;
    public Color player2Color = Color.AQUA;

    public int currentPlayer = 0;

    public int spot0 = 0;
    public int spot1 = 0;
    public int spot2 = 0;
    public int spot3 = 0;
    public int spot4 = 0;
    public int spot5 = 0;
    public int spot6 = 0;
    public int spot7 = 0;
    public int spot8 = 0;

    public int winner = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void colorPane0(MouseEvent event) {

        if (spot0 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane0.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot0 = 1;
            } else {
                pane0.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot0 = 2;
            }
            pane0.setTranslateX(pane0.getPrefWidth() / 2);
            pane0.setTranslateY(pane0.getPrefHeight() / 2);
        } 
        won();

    }

    @FXML
    private void colorPane1(MouseEvent event) {
        if (spot1 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane1.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot1 = 1;
            } else {
                pane1.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot1 = 2;
            }
            pane1.setTranslateX(pane1.getPrefWidth() / 2);
            pane1.setTranslateY(pane1.getPrefHeight() / 2);
        } 
        won();

    }

    @FXML
    private void colorPane2(MouseEvent event) {
        if (spot2 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane2.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot2 = 1;
            } else {
                pane2.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot2 = 2;
            }
            pane2.setTranslateX(pane2.getPrefWidth() / 2);
            pane2.setTranslateY(pane2.getPrefHeight() / 2);
        } 
        won();

    }

    @FXML
    private void colorPane3(MouseEvent event) {
        if (spot3 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane3.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot3 = 1;
            } else {
                pane3.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot3 = 2;
            }
            pane3.setTranslateX(pane3.getPrefWidth() / 2);
            pane3.setTranslateY(pane3.getPrefHeight() / 2);
        } 
        won();

    }

    @FXML
    private void colorPane4(MouseEvent event) {
        if (spot4 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane4.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot4 = 1;
            } else {
                pane4.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot4 = 2;
            }
            pane4.setTranslateX(pane4.getPrefWidth() / 2);
            pane4.setTranslateY(pane4.getPrefHeight() / 2);
        } 
        won();

    }

    @FXML
    private void colorPane5(MouseEvent event) {
        if (spot5 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane5.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot5 = 1;
            } else {
                pane5.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot5 = 2;
            }
            pane5.setTranslateX(pane5.getPrefWidth() / 2);
            pane5.setTranslateY(pane5.getPrefHeight() / 2);
        } 
        won();

    }

    @FXML
    private void colorPane6(MouseEvent event) {
        if (spot6 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane6.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot6 = 1;
            } else {
                pane6.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot6 = 2;
            }
            pane6.setTranslateX(pane6.getPrefWidth() / 2);
            pane6.setTranslateY(pane6.getPrefHeight() / 2);

        } 
        won();

    }

    @FXML
    private void colorPane7(MouseEvent event) {
        if (spot7 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane7.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot7 = 1;
            } else {
                pane7.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot7 = 2;
            }
            pane7.setTranslateX(pane7.getPrefWidth() / 2);
            pane7.setTranslateY(pane7.getPrefHeight() / 2);

        }
        won();
    }

    @FXML
    private void colorPane8(MouseEvent event) {
        if (spot8 == 0 && winner == 0) {
            if (currentPlayer == 0) {
                pane8.getChildren().add(new Circle(0, 0, 36, player1Color));
                currentPlayer = 1;
                spot8 = 1;
            } else {
                pane8.getChildren().add(new Circle(0, 0, 36, player2Color));
                currentPlayer = 0;
                spot8 = 2;
            }
            pane8.setTranslateX(pane8.getPrefWidth() / 2);
            pane8.setTranslateY(pane8.getPrefHeight() / 2);

        } 
        won();
    }

    public void won() {

        if ((spot0 == spot1) && (spot1 == spot2)) 
        {
            winner = spot0;
        }
        else if ((spot3 == spot4) && (spot4 == spot5))
        {
            winner = spot3; 
        }
        else if ((spot6 == spot7) && (spot7 == spot8))
        {
            winner = spot6;
        }
        else if ((spot0 == spot3) && (spot3 == spot6)) 
        {
            winner = spot0;
        }
        else if ((spot1 == spot4) && (spot4 == spot7))
        {
            winner = spot1;
        }
        else if ((spot2 == spot5) && (spot5 == spot8))
        {
            winner = spot2;
        }
        else if ((spot0 == spot4) && (spot4 == spot8))
        {
            winner = spot0; 
        }
        else if ((spot2 == spot4) && (spot4 == spot6))
        {
            winner = spot2; 
        }

        System.out.print("Player " + winner + " is winner winner chicken dinner!");

    }

}
