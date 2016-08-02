package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.domain.Produto;
import estoquestiFX.viewController.PedidosController;
import estoquestiFX.viewController.ProdutoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProdutoMain extends Application {

	private Stage primaryStage;
	private PedidosController pedidosController = null;
	private Produto p = null;

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/ProdutoView.fxml"));
		
		try {
			Scene scene = new Scene(loader.load());
			
			ProdutoController controller = loader.getController();
			controller.setMainApp(primaryStage);
			if(p != null && pedidosController != null){
				controller.recebePedidosController(pedidosController);
				controller.recebeProduto(p);
				controller.recebeProdutoCompra(p);
				System.out.println("a");
			}
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void setPedidosController(PedidosController pedidosController, Produto p) {
		this.pedidosController = pedidosController;
		this.p = p;
	}
}
