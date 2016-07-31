package estoquestiFX.viewController;

import java.util.ArrayList;
import java.util.List;

import estoquestiFX.app.Main;
import estoquestiFX.app.PesquisarFornecedorMain;
import estoquestiFX.app.PesquisarProdutoMain;
import estoquestiFX.domain.Fornecedor;
import estoquestiFX.domain.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PedidosController {
	Fornecedor fornecedor;
	List<Produto> listaDeProdutos = new ArrayList<>();
	ObservableList<Produto> obsevableListProduto = FXCollections.observableArrayList();
	private Stage palco;
	
	@FXML
	private TextField textFieldFornecedor;
	
	@FXML
	private DatePicker datePickerData;
	
	@FXML
	private CheckBox checkBoxAprovado;
	
	@FXML
	private TableView<Produto> tabelaProduto;
	
	
	@FXML
	private void buscarFornecedor(){
		PesquisarFornecedorMain main = new PesquisarFornecedorMain();
		Stage primaryStage = new Stage();
		main.start(primaryStage);
		main.setPedidosController(this);
	}

	@FXML
	private void buscarProduto(){
		PesquisarProdutoMain main = new PesquisarProdutoMain();
		Stage palco = new Stage();
		palco.setTitle("Buscar Produto");
		System.out.println("buscar");		
		main.start(palco);
		main.setPedidosController(this);
		
	}
	
	public void recebeFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		textFieldFornecedor.setText(fornecedor.getRazaoSocial()+" - "+fornecedor.getNomeFantasia());		
	}

	public void setStage(Stage primaryStage) {
		this.palco = primaryStage;		
	}

	public void recebeProduto(Produto selectedItem) {
		this.listaDeProdutos.add(selectedItem);
		obsevableListProduto.clear();
		
		obsevableListProduto.setAll(listaDeProdutos);
		
		tabelaProduto.setItems(obsevableListProduto);
	}
	
	
}
