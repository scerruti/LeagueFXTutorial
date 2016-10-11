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
    public void start(Stage primaryStage) throws IOException {
        resources = ResourceBundle.getBundle("leagueFX");

        Pane titlePane = getPane(resources, "TitleView.fxml");
        Scene titleScene = new Scene(titlePane);
        titleScene.getStylesheets().add(getClass().getResource("leagueFX.css").toExternalForm());
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(titleScene);

        primaryStage.setOnCloseRequest(event -> Platform.exit());
        primaryStage.setTitle(resources.getString("title"));
        primaryStage.show();

        titlePane.requestFocus();

    }

    private void loadGame() throws IOException {
        Pane titlePane = getPane(resources, "GameView.fxml");
        Scene titleScene = new Scene(titlePane);
        titleScene.getStylesheets().add(getClass().getResource("leagueFX.css").toExternalForm());
        primaryStage.setScene(titleScene);
    }

    private Pane getPane(ResourceBundle resources, String view) throws IOException {
        URL location = getClass().getResource(view);
        FXMLLoader loader = new FXMLLoader(location, resources);
        return loader.load();
    }
}
