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
import static java.lang.System.out;
import java.util.Vector;

public class Server {

    public static void main(String[] args) throws Exception {
        new Server().MakeServer();
    }

    Vector<String> players = new Vector<String>();
    Vector<PlayerMan> clients = new Vector<PlayerMan>();

    private void MakeServer() throws Exception {
        ServerSocket server = new ServerSocket(80, 10);
        out.println("You can create the client now");
        while (true) {
            Socket client = server.accept();
            PlayerMan c = new PlayerMan(client);
            clients.add(c);
        }
    }

    public void pass(String player, String message) {
        for (PlayerMan c : clients) {
            if (!c.getchatplayer().equals(player)) {
                c.passMessage(player, message);
            }
        }
    }

    public class PlayerMan extends Thread {

        String gotplayer = "";
        BufferedReader input = null;
        PrintWriter output = null;

        private PlayerMan(Socket socket) throws Exception {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            gotplayer = input.readLine();
            players.add(gotplayer);
            start();
        }

        private void passMessage(String chatplayer, String passreply) {
            output.println(chatplayer + " Says:" + passreply);

        }

        private String getchatplayer() {
            return gotplayer;
        }

        @Override
        public void run() {
            String line;
            try {
                while (true) {
                    line = input.readLine();
                    if (line.equals("end")) {
                        clients.remove(this);
                        players.remove(gotplayer);
                        break;
                    }
                    pass(gotplayer, line);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

}
