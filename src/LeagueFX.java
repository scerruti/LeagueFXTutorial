/*
 * Copyright (c) 2016. The League of Amazing Programmers, All Rights Reserved
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
        URL location = getClass().getResource("TitleView.fxml");
        ResourceBundle resources = ResourceBundle.getBundle("leagueFX");
        FXMLLoader loader = new FXMLLoader(location, resources);
        Pane titlePane = loader.load();

        Scene titleScene = new Scene(titlePane);
        titleScene.getStylesheets().add(getClass().getResource("leagueFX.css").toExternalForm());
        primaryStage.setScene(titleScene);

        primaryStage.setOnCloseRequest(event -> Platform.exit());
        primaryStage.setTitle(resources.getString("title"));
        primaryStage.show();

        titlePane.requestFocus();

    }
}
