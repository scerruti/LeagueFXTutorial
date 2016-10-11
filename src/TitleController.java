/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

/**
 * TitleController handles input and alters the display of the Title Screen for LeagueFX
 *
 * @author Stephen Cerruti
 */
public class TitleController {
    public TextArea instructionsArea;

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case ESCAPE:
                Platform.exit();
                break;
            case SPACE:
                instructionsArea.setVisible(!instructionsArea.isVisible());
                break;
            default:
                break;
        }
    }

    public void handlePlayButtonAction(ActionEvent actionEvent) {
        LeagueFX.startGame();
    }
}
