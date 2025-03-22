package com.marjacu.sistemvotelectronic.Controller;

import com.marjacu.sistemvotelectronic.Model.JSONHandler.JsonReader;
import com.marjacu.sistemvotelectronic.Model.VoteSession;
import com.marjacu.sistemvotelectronic.Model.VoteSessionContainer;
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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
        String sourceFile = "resources\\Data Inputs\\simpleDataFile.json";
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

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent sessionRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/VoteSessionView.fxml")));
        Scene sessionScene = new Scene(sessionRoot,screenSize.getWidth(), screenSize.getHeight());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Vot Electronic");
        stage.setScene(sessionScene);
        stage.setMaximized(true);
        stage.show();
    }

}
