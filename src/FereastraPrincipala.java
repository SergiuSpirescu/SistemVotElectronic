import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FereastraPrincipala implements Initializable {


    private int idSectieVot;
    @FXML
    private Label labelSectieVot = new Label("Bun venit la Sectia de votare");

    public void setIdSectieVot(int idSectieVot) {
        this.idSectieVot = idSectieVot;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelSectieVot.setText("Bun venit la Sectia de votare #" + Integer.toString(12345));
    }
}
