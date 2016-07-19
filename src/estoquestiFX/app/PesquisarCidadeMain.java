package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.EnderecoController;
import estoquestiFX.viewController.PesquisarCidadeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PesquisarCidadeMain extends Application {

	EnderecoController controllerEndereco = null;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../viewController/PesquisarCidade.fxml"));
		
			Scene scene = new Scene(loader.load());
			PesquisarCidadeController controller = loader.getController();
			controller.setStage(primaryStage);
			controller.setEnderecoController(controllerEndereco);
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EnderecoController getControllerEndereco() {
		return controllerEndereco;
	}
	
	public void setControllerEndereco(EnderecoController controllerEndereco) {
		this.controllerEndereco = controllerEndereco;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
