import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

    public static void main(String[] args) {

        System.out.println("Bun venit la vot!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FereastraPrincipala.fxml"));
        primaryStage.setTitle("Vot Electronic");
        primaryStage.setScene(new Scene(root,800,800));
        primaryStage.show();
    }
}
