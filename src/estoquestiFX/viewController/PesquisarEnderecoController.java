package estoquestiFX.viewController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import estoquestiFX.app.EnderecoMain;
import estoquestiFX.bean.EnderecoBean;
import estoquestiFX.domain.Endereco;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PesquisarEnderecoController implements Initializable{
	
	private Stage palco;
	List<Endereco> listaEnderecos;
	ObservableList<Endereco> observableEnderecos = FXCollections.observableArrayList();
	EnderecoController enderecoController;
	private FornecedorController fornecedorController;
	
	@FXML
	private TableView<Endereco> tableEnderecos;
	
	@FXML
	private TableColumn<Endereco, String> tableColumnLogradouro;
	
	@FXML
	private TableColumn<Endereco, String> tableColumnNumero;
	
	@FXML
	private TableColumn<Endereco, String> tableColumnBairro;
	
	@FXML
	private TableColumn<Endereco, String> tableColumnCidade;
	
	@FXML
	private TextField textFieldLogradouro;

	
	public List<Endereco> listarEnderecos(){
		EnderecoBean ebean = new EnderecoBean();
		return ebean.listar();
	}
	
	public void listar(List<Endereco> lista){
		observableEnderecos.clear();
		
		listaEnderecos = lista;
		observableEnderecos.setAll(listaEnderecos);
		
		tableEnderecos.setItems(observableEnderecos);
		
		tableColumnLogradouro.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLogradouro()));
		tableColumnNumero.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getNumero())));
		tableColumnBairro.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBairro()));
		tableColumnCidade.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCidade().getCidade()));
	}
	
	@FXML
	public void selecionar(){
		fornecedorController.recebeEndereco(tableEnderecos.getSelectionModel().getSelectedItem());
		palco.close();
	}
	
	@FXML
	public void cancelar(){
		palco.close();
	}
	
	@FXML
	public void pesquisar(){
		EnderecoBean bean = new EnderecoBean();
		listaEnderecos = bean.buscar(textFieldLogradouro.getText());
		listar(listaEnderecos);
	}
	
	public void novoEndereco(){
		EnderecoMain main = new EnderecoMain();
		main.recebePesquisarEnderecoController(this);
		
		Stage palco = new Stage();
		palco.setTitle("Novo Endereco");
		
		main.start(palco);		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listar(listarEnderecos());
	}

	public void recebeStage(Stage primaryStage) {
		this.palco = primaryStage;
	}


	public void recebeFornecedorController(FornecedorController fornecedorController) {
		this.fornecedorController = fornecedorController;
	}
}
