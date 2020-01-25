/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;

/**
 *
 * @author AJC
 */
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public final class Client extends Application{
    @SuppressWarnings("unused")
    public void start(Stage stage) throws Exception {
    }
    
    public static String player;
    PrintWriter pw;
    BufferedReader br;
    Socket socket;
    public static final P4 board = new P4();
    public static Stage stage = new Stage();
    
    
    public Client(String PlayerName, String AddPlayer) throws Exception{
        player = PlayerName; // puts in the players name
        socket = new Socket(AddPlayer , 80); // client to the server
        br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
        pw = new PrintWriter(socket.getOutputStream(),true); 
        pw.println(PlayerName); 
        System.out.println("Player: " + player); 
        new MessageThread().start();
    }

    public static void main(String[] args){   
        String SetPlayerName = JOptionPane.showInputDialog(null, "Enter name: " , "TicTacToe", JOptionPane.PLAIN_MESSAGE);
        String servername = "localhost";
            Platform.runLater(new Runnable() {
        @Override
            public void run() {

            try {
                stage.setTitle(player);
                board.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
        });
        try{
            new Client(SetPlayerName, servername); 
        }catch(Exception e){
            System.out.println("main: " +e.getMessage());
        }
    }
    
    public class MessageThread extends Thread {
        @Override
        public void run(){
            String move;
            try{
                while(true){
                    move=br.readLine(); 
                }
            }catch(Exception e){
                System.out.println("MessageThread: " + e.getMessage());
            }
        }
    }
    
}
