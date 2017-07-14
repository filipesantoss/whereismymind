package org.academiadecodigo.mindblowers.client;

import javafx.scene.control.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dgcst on 14/07/17.
 */

public class ButtonTimer {

    private Timer timer;
    private Button button;
    private Controller controller;


    public ButtonTimer(Button button, Controller controller) {
        final int BUTTON_SHOW_SECONDS = 3;
        this.button = button;
        this.controller = controller;
        timer = new Timer();
        timer.schedule(new HideButton(), BUTTON_SHOW_SECONDS * 1000);
    }

    private class HideButton extends TimerTask {
        public void run() {
            button.setVisible(false);
            timer.cancel();
            controller.checkButtons();
        }
    }

    public void cancelTimer() {
        timer.cancel();
    }
}
