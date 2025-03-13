package com.marjacu.sistemvotelectronic.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class VoteSessionController {
    public void onExitButton(ActionEvent actionEvent) {

        System.out.println("Aplicatie oprita din butonul X din: Sesiune Vot");
        System.exit(0);
    }

    public void switchToBallotView(ActionEvent event) throws IOException {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent sessionRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/VoteBallotView.fxml")));
        Scene sessionScene = new Scene(sessionRoot,screenSize.getWidth(), screenSize.getHeight());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Vot Electronic");
        stage.setScene(sessionScene);
        stage.setMaximized(true);
        stage.show();
    }
}
