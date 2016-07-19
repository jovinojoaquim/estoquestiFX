package estoquestiFX.viewController;

import estoquestiFX.bean.CategoriaBean;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CategoriaController {
	Stage stageDialog;
	ProdutoController pController;
	
	@FXML
	private TextField categoriaTextField;
	
	@FXML
	public void cancelar(){
		stageDialog.close();
	}
	
	@FXML
	public void salvar(){
		if(categoriaTextField.getText() == null || 
				categoriaTextField.getText().length() == 0){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Digite uma Categoria");
			alerta.setHeaderText("Campo categoria está vazio");
			alerta.setContentText("Por Favor, preencha uma Categoria");		
			alerta.showAndWait();
		}else{
			CategoriaBean bean = new CategoriaBean();
			bean.salvar(categoriaTextField.getText());
			pController.carregaCategorias();
			stageDialog.close();
		}
	}
	
	public CategoriaController(){
	}
	
	public void setDialogStage(Stage stageDialog, ProdutoController pController){
		this.stageDialog = stageDialog;
		this.pController = pController;
	}
}
