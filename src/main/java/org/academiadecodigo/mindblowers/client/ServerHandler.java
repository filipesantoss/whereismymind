package org.academiadecodigo.mindblowers.client;

import org.academiadecodigo.mindblowers.constants.Messages;

import java.io.IOException;

/**
 * Created by codecadet on 13/07/17.
 */
public class ServerHandler implements Runnable{

    private Controller controller;

    public ServerHandler(Controller controller) {
        this.controller = controller;

    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = Session.getInstance().getInput().readLine()) != null){
                parseString(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void parseString(String message) {
        String[] splittedString = message.split(" ");
        String serverMessage = splittedString[0];

        if (serverMessage.equals(Messages.EGO)) {
            System.out.println("ego");
            return;
        }
        if (serverMessage.equals(Messages.ALTEREGO)) {
            System.out.println("alterego");
            return;
        }

        System.out.println(serverMessage);


    }
}

