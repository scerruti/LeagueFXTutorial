/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * LeagueFX is the main class for the Java FX port of the League Invaders game.
 *
 * @author Stephen Cerruti
 */
public class LeagueFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TitleView.fxml"));
        primaryStage.setTitle("Invasion");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setOnCloseRequest(event -> Platform.exit());

        primaryStage.show();

    }
}
