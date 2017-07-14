package org.academiadecodigo.mindblowers.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by codecadet on 13/07/17.
 */
public class PlayerHandler implements Runnable {

    private Game game;
    private BufferedReader bufferedReader;
    private String playerType;

    public PlayerHandler(Game game, BufferedReader bufferedReader, String playerType) {
       this.game = game;
       this.bufferedReader = bufferedReader;
       this.playerType = playerType;

    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = bufferedReader.readLine()) != null){
                parseString(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void parseString(String message) {
        String[] splittedString = message.split(" ");

        String clientMessage = splittedString[0];

        if(clientMessage.equals("clicked")){
            game.write(playerType, "clicked");
        }

    }

}