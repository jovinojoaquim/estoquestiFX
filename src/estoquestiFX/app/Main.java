package estoquestiFX.app;

import java.io.IOException;

import estoquestiFX.viewController.CategoriaController;
import estoquestiFX.viewController.DepartamentoController;
import estoquestiFX.viewController.PesquisarProdutoController;
import estoquestiFX.viewController.ProdutoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane tela;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		//iniciaTela();
		iniciaProduto();
	}
	
	private void iniciaTela(){
		try {
			//Carrega a tela Root
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/RootPane.fxml"));		
			tela = loader.load();
			
			Scene scene = new Scene(tela);
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void iniciaProduto(){
		try {
			//Carrega a tela Root
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/ProdutoView.fxml"));		
			AnchorPane telaAncora = (AnchorPane) loader.load();
			
			//tela.setCenter(telaAncora);
			Scene scene = new Scene(telaAncora);
			
			this.primaryStage.setScene(scene);
			
			ProdutoController controller = loader.getController();
			controller.setMainApp(this);		
			
			this.primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void iniciaTelaCategoria(ProdutoController pcontroller){		
		try {
//			Carrega a tela de categoria
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/CategoriaView.fxml"));
			AnchorPane telaCategoria = (AnchorPane) loader.load();
			
//			Cria o palco
			Stage stageDialog = new Stage();
			stageDialog.setTitle("Categoria");
			stageDialog.setResizable(false);
			stageDialog.initModality(Modality.WINDOW_MODAL);
			stageDialog.initOwner(primaryStage);
//			Cria a scene e altera
			Scene scene = new Scene(telaCategoria);
			stageDialog.setScene(scene);
			
//			Chama o controlador da Categoria
			CategoriaController controller = loader.getController();
			controller.setDialogStage(stageDialog, pcontroller);
			
			stageDialog.showAndWait();
		} catch (IOException e) {
			e.getMessage();
		}
		
		
	}
	
	public void iniciaTelaDepartamento(){		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/DepartamentoView.fxml"));
			AnchorPane telaAncora = (AnchorPane) loader.load();
			
			//Cria o palco
			Stage stageDialog = new Stage();
			stageDialog.setTitle("Departamento");
			stageDialog.initModality(Modality.WINDOW_MODAL);
			stageDialog.initOwner(primaryStage);
			stageDialog.setResizable(false);
			//Cria a scene e altera
			Scene scene = new Scene(telaAncora);
			stageDialog.setScene(scene);
			
			//Chama o controlador
			DepartamentoController controller = loader.getController();
			controller.setDialogStage(stageDialog);
			
			stageDialog.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void iniciaTelaPesquisaProduto(ProdutoController pController){		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/PesquisarProduto.fxml"));
			AnchorPane telaAncora = (AnchorPane) loader.load();
			
			Stage stageDialog = new Stage();
			stageDialog.setTitle("Pesquisar Produto");
			stageDialog.initModality(Modality.WINDOW_MODAL);
			stageDialog.initOwner(primaryStage);
			//stageDialog.setResizable(false);
			//Cria a scene e altera
			Scene scene = new Scene(telaAncora);
			stageDialog.setScene(scene);
			
			//Chama o controlador
			PesquisarProdutoController controller = loader.getController();
			controller.setDialogStage(stageDialog);
			controller.recebeTela(pController);
					
			stageDialog.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
