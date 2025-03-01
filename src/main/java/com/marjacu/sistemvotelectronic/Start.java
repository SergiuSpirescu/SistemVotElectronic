package com.marjacu.sistemvotelectronic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Objects;

public class Start extends Application {

    public static void main(String[] args) {

        System.out.println("Bun venit la vot!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/MainWindowView.fxml")));

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        primaryStage.setTitle("Vot Electronic");
        primaryStage.setScene(new Scene(root,screenSize.getWidth(),screenSize.getHeight()));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
