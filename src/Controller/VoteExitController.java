package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class VoteExitController {
    public void onExitButton(ActionEvent actionEvent) {
        System.out.println("Aplicatie oprita din buton . . . " + "Final Window");
        System.exit(0);
    }

    public void switchToMainView(ActionEvent event) throws IOException {

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        Parent sessionRoot = FXMLLoader.load(getClass().getResource("../View/MainWindowView.fxml"));
        Scene sessionScene = new Scene(sessionRoot,screenSize.getWidth(), screenSize.getHeight());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Vot Electronic");
        stage.setMaximized(true);
        stage.setScene(sessionScene);
        stage.show();
    }
}
