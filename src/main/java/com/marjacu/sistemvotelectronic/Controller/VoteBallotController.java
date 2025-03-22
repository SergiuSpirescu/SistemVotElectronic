package com.marjacu.sistemvotelectronic.Controller;

import com.marjacu.sistemvotelectronic.Model.BaseCandidate;
import com.marjacu.sistemvotelectronic.Model.VoteSession;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;


public class VoteBallotController {

    private String selectedCandidate = "";
    private String selectedID = "";
    private Button selButton = new Button();

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
            name.setId(candidate.getCandidateID());

            int i = candidateList.indexOf(candidate);
            int row = i / 2; // 2 items per row
            int col = i % 2;

            name.setOnAction(event -> {
                selectedID = name.getId();
                selectedCandidate = candidate.toString();
                System.out.println(selectedCandidate);
            });

            candidateItems.add(name, row, col);
        });
        candidateItems.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
    }

    public void switchToVoteSessionView(ActionEvent event) throws IOException {
        if (!selectedID.isEmpty()) {

            AtomicBoolean confirmed = new AtomicBoolean(false);
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Confirmați selecția?\n" +
                    selectedCandidate, new ButtonType("Da, confirm"), new ButtonType("Nu, mergi înapoi"));
            confirm.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
                confirm.showAndWait()
                        .filter(resp -> resp.getText().equals("Da, confirm"))
                        .ifPresent(t -> { confirmed.set(true);});
            if (confirmed.get()) {
                // Vote confirmed, remove ballot option
                VoteSessionController.updateSelected(selButton);
                // Load the next view (VoteSessionView)
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/VoteSessionView.fxml"));
                Parent sessionRoot = null;
                try {
                    sessionRoot = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // Get the controller of the loaded FXML view
                VoteSessionController voteSessionController = loader.getController();
                voteSessionController.checkFinish();
                // Pass the list of items to the controller for dynamic loading into the GridPane
                try {
                    voteSessionController.loadBallots(VoteSession.getInstance().getBallotList());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // Get the screen size to make sure the window is maximized
                Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
                Scene sessionScene = new Scene(sessionRoot, screenSize.getWidth(), screenSize.getHeight());
                // Get the stage (current window)
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(sessionScene);
                stage.setFullScreenExitHint("");
                stage.setFullScreen(true);
                stage.setResizable(false);
                stage.setOpacity(1.0);
                // Start the transition
                Parent finalSessionRoot = sessionRoot;
                Platform.runLater(() -> {
                    stage.show(); // Show the stage first (ensure the full-screen transition happens after)
                    // Apply the fade-in transition after the stage is visible
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(300), finalSessionRoot);
                    fadeIn.setFromValue(0.7);
                    fadeIn.setToValue(1.0);
                    fadeIn.setOnFinished(event1 -> {
                        stage.setFullScreen(true);  // Activate full-screen mode here
                        stage.show();
                    });
                    fadeIn.play();
                });
            } else {
                selectedCandidate = "";
                selectedID = "";
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nu ați selectat un candidat!");
            alert.setHeaderText("Atenție!");
            alert.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
            alert.show();
        }
    }

    public void injectButton(Button button) {
        this.selButton = button;
    }
}
