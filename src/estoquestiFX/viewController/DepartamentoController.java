package estoquestiFX.viewController;

import estoquestiFX.app.Main;
import estoquestiFX.bean.DptoUsuarioBean;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DepartamentoController {
	Stage stageDialog;
	Main main;
	
	public DepartamentoController(){
		
	}
	
	@FXML
	private TextField departamentoTextField;
	
	
	@FXML
	public void fechar(){
		stageDialog.close();
	}
	
	@FXML
	public void salvar(){
		DptoUsuarioBean bean = new DptoUsuarioBean();
		bean.salvar(departamentoTextField.getText());
	}


	public void setDialogStage(Stage stageDialog) {
		this.stageDialog = stageDialog;	
	}


}
