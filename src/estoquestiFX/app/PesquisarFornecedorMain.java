package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.FornecedorController;
import estoquestiFX.viewController.PedidosController;
import estoquestiFX.viewController.PesquisarFornecedorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PesquisarFornecedorMain extends Application {

	private PedidosController pedidosController = null;

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/PesquisarFornecedor.fxml"));
		
		try {
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			
			primaryStage.setTitle("Pesquisar Fornecedor");
			
			PesquisarFornecedorController controller = loader.getController();
			controller.setMain(primaryStage);
			controller.setPedidosController(pedidosController);
			
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void setPedidosController(PedidosController pedidosController) {
		this.pedidosController = pedidosController;		
	}
}
