package com.marjacu.sistemvotelectronic.Controller;

import com.marjacu.sistemvotelectronic.Model.JSONHandler.JsonReader;
import com.marjacu.sistemvotelectronic.Model.VoteSession;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private int idSectieVot;
    @FXML
    private Label labelSectieVot = new Label("");

    @FXML
    private Button startButton = new Button();

    @FXML
    private Label votInceput = new Label("");

    public void setIdSectieVot(int idSectieVot) {
        this.idSectieVot = idSectieVot;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sourceFile = "resources\\Data Inputs\\basicDataFile.json";
        if (!VoteSession.getInstance().isInitialized())
        {
            try {
                JsonReader.initSession(sourceFile, VoteSession.getInstance());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String nrSesiune = VoteSession.getInstance().getVoteSessionName();
        String numeSectie = VoteSession.getInstance().getVotePrecintID();
        labelSectieVot.setText("Bun venit la Sesiunea de Vot " + nrSesiune + " in Sectia de votare #" + numeSectie + "\n");
    }

    public void onStartButtonClicked() {

        System.out.println("A inceput votul.");
        votInceput.setText("A inceput votul.");
    }

    public void onExitButton(){
        System.out.println("Aplicatie oprita din buton . . . " + "Main Window");
        System.exit(0);
    }

    public void switchToVoteSessionView(ActionEvent event) throws IOException {
        onStartButtonClicked();

        // Load the next view (VoteSessionView)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/VoteSessionView.fxml"));
        Parent sessionRoot = loader.load();
        // Get the controller of the loaded FXML view
        VoteSessionController voteSessionController = loader.getController();
        // Pass the list of items to the controller for dynamic loading into the GridPane
         voteSessionController.loadBallots(VoteSession.getInstance().getBallotList());
        // Get the screen size to make sure the window is maximized
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Scene sessionScene = new Scene(sessionRoot, screenSize.getWidth(), screenSize.getHeight());
        // Get the stage (current window)
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(VoteSession.getInstance().getVoteSessionName()); //TODO: Refactor to a label showing which ballot is selected
        stage.setScene(sessionScene);
        stage.setFullScreenExitHint("");;
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setOpacity(1.0);
        // Start the transition
        Platform.runLater(() -> {
            stage.show(); // Show the stage first (ensure the full-screen transition happens after)

            // Apply the fade-in transition after the stage is visible
            FadeTransition fadeIn = new FadeTransition(Duration.millis(300), sessionRoot);
            fadeIn.setFromValue(0.7);
            fadeIn.setToValue(1.0);
            fadeIn.setOnFinished(event1 -> {
                stage.setFullScreen(true);  // Activate full-screen mode here
                stage.show();
            });
            fadeIn.play();
        });
    }

}
