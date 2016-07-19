package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.EnderecoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnderecoMain extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/EnderecoView.fxml"));
		
		try {
			Scene scene = new Scene(loader.load());
			
			EnderecoController controller = loader.getController();
			controller.setPalco(primaryStage);
			primaryStage.setTitle("Novo Endereço");
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
