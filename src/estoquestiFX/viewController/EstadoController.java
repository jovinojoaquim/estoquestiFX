package estoquestiFX.viewController;

import estoquestiFX.app.EstadoMain;
import estoquestiFX.bean.EstadoBean;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EstadoController {

	@FXML
	private TextField textFieldNomeEstado;
	private EstadoMain estadoMain;
	private CidadeController cidadeController;
	private Stage primaryStage;
	
	@FXML
	private void salvar(){
		EstadoBean bean = new EstadoBean();
		try{
			bean.salvar(textFieldNomeEstado.getText());
			cidadeController.listaDeEstados();
			primaryStage.close();
		}catch (RuntimeException e) {
			e.printStackTrace();
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Erro ao salvar Estado");
			alerta.setHeaderText(e.getMessage());
			alerta.showAndWait();
		}
	}
	
	@FXML
	private void cancelar(){
		primaryStage.close();
	}

	public void setMain(EstadoMain estadoMain, CidadeController cidadeController, Stage primaryStage) {
		this.estadoMain = estadoMain;
		this.cidadeController = cidadeController;
		this.primaryStage = primaryStage;
	}
}
