package estoquestiFX.viewController;

import java.util.List;

import estoquestiFX.bean.FornecedorBean;
import estoquestiFX.domain.Fornecedor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PesquisarFornecedorController {
	private Stage palco;
	PedidosController pedidosController;
	List<Fornecedor> listaDeFornecedores;
	Fornecedor f;
	ObservableList<Fornecedor> observableListaDeFornecedores = FXCollections.observableArrayList();
	
	@FXML
	private TextField razaoSocial;
	
	@FXML
	private TableView<Fornecedor> tableViewFornecedor;
	
	@FXML
	private TableColumn<Fornecedor, String> tableColumnRazaoSocial;
	
	@FXML
	private TableColumn<Fornecedor, String> tableColumnNomeFantasia;
	
	@FXML
	private void pesquisarFornecedor(){
		FornecedorBean fbean = new FornecedorBean();
		System.out.println("Pesquisar");
		listaDeFornecedores = fbean.buscar(razaoSocial.getText());
		organizaTabela();
	}

	private void organizaTabela() {
		observableListaDeFornecedores.clear();
		observableListaDeFornecedores.setAll(listaDeFornecedores);
		
		tableViewFornecedor.setItems(observableListaDeFornecedores);
		
		tableColumnNomeFantasia.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomeFantasia()));
		tableColumnRazaoSocial.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRazaoSocial()));
	}
	
	@FXML
	private void selecionarFornecedor(){
		pedidosController.recebeFornecedor(tableViewFornecedor.getSelectionModel().getSelectedItem());
	}
	
	@FXML
	private void cancelar(){
		palco.close();
	}

	public void setMain(Stage primaryStage) {
		palco = primaryStage;		
	}

	public void setPedidosController(PedidosController pedidosController) {
		this.pedidosController = pedidosController;
	}
}
