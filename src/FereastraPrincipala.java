import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FereastraPrincipala implements Initializable {


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
        labelSectieVot.setText("Bun venit la Sectia de votare #" + Integer.toString(12345) + "\n");
    }

    public void onStartButtonClicked() {
        System.out.println("A inceput votul.");
        votInceput.setText("A inceput votul.");
    }

    public void onExitButton(){
        System.out.println("Aplicatie oprita din buton . . .");
        System.exit(0);
    }
}
