package estoquestiFX.viewController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import estoquestiFX.app.Main;
import estoquestiFX.bean.ProdutoBean;
import estoquestiFX.domain.Produto;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PesquisarProdutoController implements Initializable{
	
	Stage palco;
	ProdutoController pController;
	List<Produto> listaDeProdutos = null;
	private ObservableList<Produto> observableList = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Produto> produtoTabela;
	
	@FXML
	private TableColumn<Produto, String> colunaNome;
	
	@FXML
	private TableColumn<Produto, String> colunaQuantidade;
	
	@FXML
	private TableColumn<Produto, String> colunaDescricao;
	
	@FXML
	private TableColumn<Produto, String> colunaValorVenda;
	
	@FXML
	private TableColumn<Produto, String> colunaMarca;
	
	@FXML
	private TextField textFieldPesquisaProduto;
	
	public void setDialogStage(Stage palco) {
		this.palco = palco;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ProdutoBean bean = new ProdutoBean();
		listaDeProdutos = bean.listarProdutos();
		
		alterarTabela();
	}

	private void alterarTabela() {
		observableList.setAll(listaDeProdutos);
		
		produtoTabela.setItems(observableList);
		
		colunaNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		colunaQuantidade.setCellValueFactory(new PropertyValueFactory<Produto, String>("quantidade"));
		colunaDescricao.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
		colunaMarca.setCellValueFactory(new PropertyValueFactory<Produto, String>("marca"));
		colunaValorVenda.setCellValueFactory(new PropertyValueFactory<Produto, String>("valorVenda"));
	}
	
	@FXML
	private void editar(){
		Produto p = produtoTabela.getSelectionModel().getSelectedItem();
		pController.recebeProduto(p);
		palco.close();
	}
	
	@FXML
	private void cancelar(){
		palco.close();
	}
	
	@FXML
	private void pesquisarProduto(){
		ProdutoBean pbean = new ProdutoBean();
		listaDeProdutos = pbean.pesquisarProduto(textFieldPesquisaProduto.getText());
		alterarTabela();
	}
	

	public void recebeTela(ProdutoController pController) {
		this.pController = pController;	
	}
	
	

}
