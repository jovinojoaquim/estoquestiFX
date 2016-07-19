package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.CidadeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CidadeMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/CidadeView.fxml"));
		
		try {
			Scene scene = new Scene(loader.load());
			
			CidadeController controller = loader.getController();
			controller.setPalco(primaryStage);
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
