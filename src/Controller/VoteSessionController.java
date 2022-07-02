package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

public class VoteSessionController {
    public void onExitButton(ActionEvent actionEvent) {

        System.out.println("Aplicatie oprita din buton . . . " + "Sesiune");
        System.exit(0);
    }
}
