package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.CidadeController;
import estoquestiFX.viewController.EstadoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EstadoMain extends Application {

	private CidadeController cidadeController;
	
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../viewController/EstadoView.fxml"));
		
		try {
			
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			
			EstadoController controller = loader.getController();
			controller.setMain(this, cidadeController, primaryStage);
			
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CidadeController getCidadeController() {
		return cidadeController;
	}
	public void setCidadeController(CidadeController cidadeController) {
		this.cidadeController = cidadeController;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
