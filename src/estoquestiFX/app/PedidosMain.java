package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.PedidosController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PedidosMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/PedidosView.fxml"));
		
		try {
			Scene scene = new Scene(loader.load());
			
			PedidosController controller = loader.getController();
			controller.setStage(primaryStage);
			
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
