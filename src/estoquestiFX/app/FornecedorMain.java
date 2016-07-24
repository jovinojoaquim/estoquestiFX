package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.FornecedorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FornecedorMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/FornecedorView.fxml"));
		primaryStage.setTitle("Novo Fornecedor");
		
		try {
			Scene scene = new Scene(loader.load());
			FornecedorController controller = loader.getController();
			
			
			controller.setStage(primaryStage);
			
			
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
