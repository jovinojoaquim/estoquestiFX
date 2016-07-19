package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.PesquisarCidadeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PesquisarCidadeMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../viewController/PesquisarCidade.fxml"));
		
			Scene scene = new Scene(loader.load());
			PesquisarCidadeController controller = loader.getController();
			
			
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
