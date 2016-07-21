package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.EnderecoController;
import estoquestiFX.viewController.PesquisarEnderecoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnderecoMain extends Application {
	
	private PesquisarEnderecoController pesquisarEnderecoController;

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/EnderecoView.fxml"));
		
		try {
			Scene scene = new Scene(loader.load());
			
			EnderecoController controller = loader.getController();
			controller.setPalco(primaryStage);
			controller.recebePesquisarEnderecoController(pesquisarEnderecoController);
			
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

	public void recebePesquisarEnderecoController(PesquisarEnderecoController pesquisarEnderecoController) {
		this.pesquisarEnderecoController = pesquisarEnderecoController;
	}
}
