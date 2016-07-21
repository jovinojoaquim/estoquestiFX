package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.FornecedorController;
import estoquestiFX.viewController.PesquisarEnderecoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PesquisarEnderecoMain extends Application {

	FornecedorController fornecedorController;
	
	@Override
	public void start(Stage primaryStage) {
		try {		
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../viewController/PesquisarEndereco.fxml"));
			
			Scene scene = new Scene(loader.load());
			
			PesquisarEnderecoController controller = loader.getController();
			controller.recebeStage(primaryStage);
			controller.recebeFornecedorController(fornecedorController);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void setFornecedorController(FornecedorController fornecedorController) {
		this.fornecedorController = fornecedorController;
	}
}
