package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.PedidosController;
import estoquestiFX.viewController.PesquisarProdutoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PesquisarProdutoMain extends Application {

	private PedidosController pedidosController;
	private PesquisarProdutoController controller;

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/PesquisarProduto.fxml"));
		
		try {
			Scene scene = new Scene(loader.load());
			primaryStage.setTitle("Pesquisar Produto");
			
			controller = loader.getController();
			controller.setDialogStage(primaryStage);
			
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

	public void setPedidosController(PedidosController pedidosController) {
		this.pedidosController = pedidosController;
		controller.setPedidosController(pedidosController);
	}
}
