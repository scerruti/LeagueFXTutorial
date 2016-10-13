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

    private static LeagueFX instance;
    private ResourceBundle resources;
    private Stage primaryStage;

    public LeagueFX() {
        instance = this;
    }

    private static LeagueFX getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }

    static void startGame() {
        try {
            LeagueFX.getInstance().loadGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        resources = ResourceBundle.getBundle("leagueFX");

        try {
            getPane(resources, "TitleView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setOnCloseRequest(event -> Platform.exit());
        primaryStage.setTitle(resources.getString("title"));
        primaryStage.show();

    }

    private void loadGame() throws IOException {
        getPane(resources, "GameView.fxml");
    }

    private void getPane(ResourceBundle resources, String viewFile) throws IOException {
        URL location = getClass().getResource(viewFile);
        FXMLLoader loader = new FXMLLoader(location, resources);
        Pane pane = loader.load();

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        
        pane.requestFocus();
    }
}
