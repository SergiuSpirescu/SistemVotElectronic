package com.marjacu.sistemvotelectronic.Controller;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class VoteExitController {
    public void onExitButton(ActionEvent actionEvent) {
        System.out.println("Aplicatie oprita din butonul X din: Final Window");
        System.exit(0);
    }

    public void switchToMainView(ActionEvent event) throws IOException {

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent sessionRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/MainWindowView.fxml")));
        Scene sessionScene = new Scene(sessionRoot,screenSize.getWidth(), screenSize.getHeight());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Vot Electronic");
        stage.setScene(sessionScene);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setResizable(false);
        stage.setOpacity(1.0);
        // Start transition
        Platform.runLater(() -> {
            stage.show(); // Show the stage first (ensure the full-screen transition happens after)

            // Apply the fade-in transition after the stage is visible
            FadeTransition fadeIn = new FadeTransition(Duration.millis(300), sessionRoot);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setOnFinished(event1 -> {
                stage.setFullScreen(true);  // Activate full-screen mode here
                stage.show();
            });
            fadeIn.play();
        });
    }
}
