package estoquestiFX.viewController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import estoquestiFX.app.EstadoMain;
import estoquestiFX.bean.CidadeBean;
import estoquestiFX.bean.EstadoBean;
import estoquestiFX.domain.Estado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CidadeController implements Initializable{

	ObservableList<String> lista = FXCollections.observableArrayList();
	private List<Estado> listaDeEstados;
	
	@FXML
	private TextField textFieldCidade;
	
	@FXML
	private ComboBox<String> comboBoxEstado;
	private Stage stage;

	public void listaDeEstados() {
		EstadoBean bean = new EstadoBean();
		lista.clear();
		if(listaDeEstados==null || listaDeEstados.size() == 0){
			
		}

		listaDeEstados = bean.listar();
		for(int i = 0; i< listaDeEstados.size(); i++){
			System.out.println(listaDeEstados.get(i).getNomeEstado());
			lista.add(listaDeEstados.get(i).getNomeEstado());
		}
		comboBoxEstado.setItems(lista);
	}
	
	@FXML
	private void salvar(){
		try{
			
		CidadeBean bean = new CidadeBean();
		bean.salvar(textFieldCidade.getText(), listaDeEstados.get(comboBoxEstado.getSelectionModel().getSelectedIndex()));
		
		}catch (RuntimeException e) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Erro ao salvar cidade");
			if(e.getMessage().equals("-1")){
				alerta.setHeaderText("Selecione um Estado");
			}else{			
				alerta.setHeaderText(e.getMessage());
			}
			alerta.showAndWait();
		}
	}
	
	@FXML
	private void novoEstado(){
		EstadoMain estadoMain = new EstadoMain();
		estadoMain.setCidadeController(this);
		Stage stage = new Stage();
		stage.setTitle("Novo Estado");
		stage.setResizable(false);		
		
		estadoMain.start(stage);
	}
	
	@FXML
	private void cancelar(){
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listaDeEstados();		
	}

	public void setPalco(Stage primaryStage) {
		this.stage = primaryStage;
	}
	

	
	
	
	
}
