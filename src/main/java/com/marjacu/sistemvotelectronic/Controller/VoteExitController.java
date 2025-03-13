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
        stage.show();
    }
}
