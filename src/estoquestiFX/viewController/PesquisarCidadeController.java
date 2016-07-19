package estoquestiFX.viewController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import estoquestiFX.app.CidadeMain;
import estoquestiFX.bean.CidadeBean;
import estoquestiFX.bean.EstadoBean;
import estoquestiFX.domain.Cidade;
import estoquestiFX.domain.Estado;
import estoquestiFX.domain.Produto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PesquisarCidadeController implements Initializable{

	private List<Estado> listaDeEstado;
	List<Cidade> listaDeCidade;
	ObservableList<String> listaObservable = FXCollections.observableArrayList();
	ObservableList<Cidade> listaObservableCidade = FXCollections.observableArrayList();
	private Stage palco;
	EnderecoController enderecoController = null;
	
	@FXML
	private TextField textFieldCidade;
	
	@FXML
	private ComboBox<String> comboBoxEstado;
	
	@FXML
	private TableView<Cidade> tableCidade;
	
	@FXML
	private TableColumn<Cidade, String> tableColumnNomeCidade;
	
	@FXML
	private TableColumn<Cidade, String> tableColumnEstado;
	
	
	@FXML
	private void novaCidade(){
		System.out.println("oi");
		CidadeMain cidade = new CidadeMain();
		Stage stage = new Stage();
		cidade.start(stage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listaDeEstados();	
		CidadeBean bean = new CidadeBean();
		listaDeCidade = bean.listar();
		listar();
	}

	private void listaDeEstados() {
		EstadoBean estadoBean = new EstadoBean();
		
		listaDeEstado = estadoBean.listar();
		listaObservable.clear();
		
		for(int i =0; i < listaDeEstado.size(); i++){
			listaObservable.add(listaDeEstado.get(i).getNomeEstado());
		}
		comboBoxEstado.setItems(listaObservable);
	}
	
	private void listar(){
		listaObservableCidade.setAll(listaDeCidade);

		tableCidade.setItems(listaObservableCidade);

		tableColumnNomeCidade.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCidade()));
		tableColumnEstado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEstado().getNomeEstado()));
	}
	
	@FXML
	private void buscarCidade(){
		CidadeBean bean = new CidadeBean();
		
		if(comboBoxEstado.getSelectionModel().getSelectedIndex() != -1){
			System.out.println(listaDeEstado.get(comboBoxEstado.getSelectionModel().getSelectedIndex()).getId());
			listaDeCidade = bean.buscarCidade(textFieldCidade.getText(), listaDeEstado.get(comboBoxEstado.getSelectionModel().getSelectedIndex()));
			for (Cidade cidade : listaDeCidade) {
				System.out.println(cidade.getCidade());
				System.out.println();
			}
		}else if(textFieldCidade.getText().length() == 0 && comboBoxEstado.getSelectionModel().getSelectedIndex() != -1){
			listaDeCidade = bean.buscarCidade(listaDeEstado.get(comboBoxEstado.getSelectionModel().getSelectedIndex()).getId());
		}else{
			listaDeCidade = bean.buscarCidade(textFieldCidade.getText());
			for (Cidade cidade : listaDeCidade) {
				System.out.println(cidade.getCidade());
				System.out.println();
			}
		}
		listar();
	}
	
	@FXML
	private void selecionarCidade(){
		enderecoController.recebeCidade(tableCidade.getSelectionModel().getSelectedItem());
		palco.close();
	}

	public void setStage(Stage primaryStage) {
		palco = primaryStage;
	}
	
	public void setEnderecoController(EnderecoController enderecoController) {
		this.enderecoController = enderecoController;
	}
}
