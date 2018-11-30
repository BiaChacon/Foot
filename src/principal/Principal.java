package principal;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Principal extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/visao/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        stage.setTitle("Football Manager");
        
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/visao/img/soccer-ball.png")) {});
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
