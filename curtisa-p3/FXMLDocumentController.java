/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 *
 * @author AJC
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button runHorse;
    @FXML
    private Button resetHorse;
    @FXML
    private Button quitHorse;
    @FXML
    private ImageView H1;
    @FXML
    private ImageView H2;
    @FXML
    private ImageView H3;
    @FXML
    private ImageView H4;
    @FXML
    private ImageView H5;

    public int wins = 0;

    public long start;
    public long end;

    
    public Timer timer;
    public float totalTime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        end = System.currentTimeMillis();
        timer = new Timer();
    }

    @FXML
    private void runHorse(ActionEvent event) {
        start = System.currentTimeMillis();
        timer = new Timer();

        TimerTask horsesMoving = new TimerTask() {
            public void run() {
                moving();
            }
        };
        timer.scheduleAtFixedRate(horsesMoving, 0, 300l);
        if (wins > 0) {
            hChamp(); //declares winner
            end = System.currentTimeMillis();
            totalTime = totalTime + end;
        }

    }

    private void moving() {
        Random r = new Random();
        int gottaGoFast;
        if (H1.getLayoutX() >= 519) {
            wins = 1;
        } else if (H2.getLayoutX() >= 519) {
            wins = 2;
        } else if (H3.getLayoutX() >= 519) {
            wins = 3;
        } else if (H4.getLayoutX() >= 519) {
            wins = 4;
        } else if (H5.getLayoutX() >= 519) {
            wins = 5;
        } else {
            gottaGoFast = r.nextInt(10) + 10;
            H1.setLayoutX(H1.getLayoutX() + gottaGoFast);

            gottaGoFast = r.nextInt(10) + 10;
            H2.setLayoutX(H2.getLayoutX() + gottaGoFast);

            gottaGoFast = r.nextInt(10) + 10;
            H3.setLayoutX(H3.getLayoutX() + gottaGoFast);

            gottaGoFast = r.nextInt(10) + 10;
            H4.setLayoutX(H4.getLayoutX() + gottaGoFast);

            gottaGoFast = r.nextInt(10) + 10;
            H5.setLayoutX(H5.getLayoutX() + gottaGoFast);
        }

    }

    @FXML
    private void resetHorse(ActionEvent event) {
        wins = 0;

        //X Layouts after resets
        H1.setLayoutX(32.0);
        H2.setLayoutX(32.0);
        H3.setLayoutX(32.0);
        H4.setLayoutX(32.0);
        H5.setLayoutX(32.0);

        //Y Layouts after reset
        H1.setLayoutY(35.0);
        H2.setLayoutY(101.0);
        H3.setLayoutY(179.0);
        H4.setLayoutY(255.0);
        H5.setLayoutY(331.0);
    }

    @FXML
    private void quitHorse(ActionEvent event) {
        System.exit(0); //exit program
    }

    private void hChamp() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Champion");
        alert.setHeaderText(null);
        alert.setContentText("The champion of this race is Horse: " + wins + " Time of: " + totalTime + " seconds");
        alert.showAndWait();
    }

}
