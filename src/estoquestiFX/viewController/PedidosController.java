package estoquestiFX.viewController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import estoquestiFX.app.Main;
import estoquestiFX.app.PesquisarFornecedorMain;
import estoquestiFX.app.PesquisarProdutoMain;
import estoquestiFX.bean.PedidoBean;
import estoquestiFX.domain.Fornecedor;
import estoquestiFX.domain.Produto;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PedidosController {
	Fornecedor fornecedor;
	List<Produto> listaDeProdutos = new ArrayList<>();
	private ObservableList<Produto> obsevableListProduto = FXCollections.observableArrayList();
	private Stage palco;
	private Double totalCompra = 0.0;
	
	@FXML
	private TextField textFieldFornecedor;
	
	@FXML
	private DatePicker datePickerData;
	
	@FXML
	private CheckBox checkBoxAprovado;
	
	@FXML
	private TableView<Produto> tabelaProduto;
	
	@FXML
	private TableColumn<Produto, String> tableColumnNome;
	
	@FXML
	private TableColumn<Produto, String> tableColumnQuantidade;
	
	@FXML
	private TableColumn<Produto, String> tableColumnPrecoCompra;
	
	@FXML
	private TableColumn<Produto, String> tableColumnTotalCompra;
	
	@FXML
	private TextField textFieldTotal;
	
	
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
	
	@FXML
	private void salvar(){
		PedidoBean pbean = new PedidoBean();
		try {
			pbean.salvar(fornecedor, datePickerData, checkBoxAprovado, listaDeProdutos);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		
		tableColumnNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
		tableColumnQuantidade.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getQuantidade().toString().replace(".0", "")));
		tableColumnPrecoCompra.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValorCompra().toString()));
		
		Double precoTotalProduto = selectedItem.getQuantidade()*selectedItem.getValorCompra();
		tableColumnTotalCompra.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(precoTotalProduto)));
		
		totalCompra+= precoTotalProduto;
		textFieldTotal.setText(String.valueOf(totalCompra));
	}
	

	
	
}
