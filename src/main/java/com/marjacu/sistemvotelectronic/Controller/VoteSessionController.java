package com.marjacu.sistemvotelectronic.Controller;

import com.marjacu.sistemvotelectronic.Model.Ballot;
import com.marjacu.sistemvotelectronic.Model.VoteSession;
import com.marjacu.sistemvotelectronic.Model.VoteSessionContainer;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class VoteSessionController {

    private static final List<String> selectedButtons = new ArrayList<>();

    @FXML
    private GridPane ballotItems;

    @FXML
    private Button finishButton;
    private BooleanProperty finished = new SimpleBooleanProperty(false);

    public void onExitButton(ActionEvent actionEvent) {
        System.out.println("Aplicatie oprita din butonul X din: Sesiune Vot");
        System.exit(0);
    }

    public void loadBallots(ArrayList<Ballot> ballots) throws IOException {
        ballotItems.getChildren().clear(); // Clear any existing children before adding new items

        ballots.forEach(ballot -> {
            Button button = new Button(ballot.getBallotName());  // Create a button for each item

            // Add the button to the grid (adjusting row/column dynamically)
            int i = ballots.indexOf(ballot);
            int row = i / 2; // 2 items per row
            int col = i % 2;

            // Set ballot ID for traceability
            button.setId("ballot-" + ballot.getBallotID());
            button.autosize();

            if (selectedButtons.contains(button.getId())) {
                button.setDisable(true);
                button.setStyle("-fx-background-color: grey; -fx-text-fill: white;");
            }

            button.setOnAction(event -> {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/VoteBallotView.fxml"));
                Parent ballotRoot = null;
                try {
                    ballotRoot = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert ballotRoot != null;
                Parent finalBallotRoot = ballotRoot;
                VoteBallotController voteBallotController = loader.getController();
                voteBallotController.loadCandidates(ballot.getCandidateList());
                voteBallotController.injectButton(button);
                Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
                Scene sessionScene = new Scene(ballotRoot, screenSize.getWidth(), screenSize.getHeight());
                // Get the stage (current window)
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle(ballot.getBallotName());
                stage.setScene(sessionScene);
                stage.setMaximized(true);
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("");
                stage.setResizable(false);
                stage.setOpacity(1.0);
                // Start the transition
                Platform.runLater(() -> {
                    stage.show(); // Show the stage first (ensure the full-screen transition happens after)

                    // Apply the fade-in transition after the stage is visible
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(300), finalBallotRoot);
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.setOnFinished(event1 -> {
                        stage.setFullScreen(true);  // Activate full-screen mode here
                        stage.show();
                    });
                    fadeIn.play();
                });
            });
            // Add button to the GridPane
            ballotItems.add(button, col, row);
        });
        ballotItems.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        finishButton.visibleProperty().bind(finished);
    }

    public void switchToVoteBallotView(ActionEvent event) throws IOException {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent sessionRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/VoteBallotView.fxml")));
        Scene sessionScene = new Scene(sessionRoot,screenSize.getWidth(), screenSize.getHeight());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(sessionScene);
        stage.setFullScreenExitHint("");
        stage.setMaximized(true);
        stage.setFullScreen(true);
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

    public static void updateSelected (Button button) {
        selectedButtons.add(button.getId());
    }

    public void checkFinish() {
        this.finished.set(selectedButtons.size() == VoteSession.getInstance().getNumberOfBallots());
    }

    public void switchToExitView(ActionEvent event) throws IOException{
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent sessionRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/VoteExitView.fxml")));
        Scene sessionScene = new Scene(sessionRoot,screenSize.getWidth(), screenSize.getHeight());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(sessionScene);
        stage.setFullScreenExitHint("");
        stage.setMaximized(true);
        stage.setFullScreen(true);
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
