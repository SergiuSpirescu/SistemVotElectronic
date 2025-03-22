package com.marjacu.sistemvotelectronic.Controller;

import com.marjacu.sistemvotelectronic.Model.BaseCandidate;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VoteBallotController {

    @FXML
    private GridPane candidateItems;

    public void onExitButton(ActionEvent actionEvent) {
        System.out.println("Aplicatie oprita din butonul X din: Ballot Window");
        System.exit(0);
    }

    public void loadCandidates(ArrayList<BaseCandidate> candidateList) {
        candidateItems.getChildren().clear(); // Clear any existing items before adding new items

        candidateList.forEach(candidate -> {
            Button name = new Button(candidate.getNameList().toString() + "\n" +
                    candidate.getPartyName());
            int i = candidateList.indexOf(candidate);
            int row = i / 2; // 2 items per row
            int col = i % 2;

            candidateItems.add(name, row, col);
        });
        candidateItems.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    }

    public void switchToFinalView(ActionEvent event) throws IOException {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent sessionRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/VoteExitView.fxml")));
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
            fadeIn.setFromValue(0.4);
            fadeIn.setToValue(1.0);
            fadeIn.setOnFinished(event1 -> {
                stage.setFullScreen(true);  // Activate full-screen mode here
                stage.show();
            });
            fadeIn.play();
        });
    }
}
