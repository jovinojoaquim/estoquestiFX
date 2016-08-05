package estoquestiFX.viewController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import estoquestiFX.domain.Categoria;
import estoquestiFX.domain.Produto;
import estoquestiFX.app.Main;
import estoquestiFX.bean.CategoriaBean;
import estoquestiFX.bean.ProdutoBean;
import estoquestiFX.domain.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProdutoController implements Initializable{
	ObservableList<String> listaObservable = FXCollections.observableArrayList();
	private List<Categoria> listaDeCategorias;
	private Main main;
	private Categoria categoriaSelecionada;
	private Long id = null;
	private Stage palco;
	private PedidosController pedidosController;
	private Produto produto;
	
	@FXML
	private ComboBox<String> categoriaComboBox;
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField descricaoTextField;
	@FXML
	private TextField medidaTextField;
	@FXML
	private TextField quantidadeTextField;
	@FXML
	private TextField marcaTextField;
	@FXML
	private TextField valorVendaTextField;
	@FXML
	private Button botaoSalvar;
	@FXML
	private Button botaoPesquisar;
	@FXML
	private Button botaoNovo;
	@FXML
	private Button botaoCancelar;
	@FXML
	private TextField valorCompraTextField;


	@FXML
	private void novaCategoria(){
		this.main.iniciaTelaCategoria(this);
	}
	
	public ProdutoController(){	
	}

	public void setMainApp(Stage main) {
		this.palco = main;	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregaCategorias();	
	}

	/**
	 * Carrega a lista de Categorias
	 */
	public void carregaCategorias() {
		if(listaObservable.size()!=0){
			listaObservable.clear();
		}
		CategoriaBean bean = new CategoriaBean();
		listaDeCategorias = bean.listarCategorias();
		for(int i = 0; i <listaDeCategorias.size(); i++){
			listaObservable.add(listaDeCategorias.get(i).getCategoria());
		}
		categoriaComboBox.setItems(listaObservable);
	}
	
	/**
	 * Captura o Index selecionado da lista;
	 */
	@FXML
	private void categoriaSelecionada(){
		int selecionado = categoriaComboBox.getSelectionModel().getSelectedIndex();
		categoriaSelecionada = listaDeCategorias.get(selecionado);
	}
	
	/**
	 * Salva Novos Produtos e produtos Editados
	 */
	@FXML
	private void salvar(){
		Double quantidade = converteParaDouble(quantidadeTextField.getText(), "Quantidade");
		Double valorVenda = converteParaDouble(valorVendaTextField.getText(), "Valor Venda");
		Double valorCompra = converteParaDouble(valorVendaTextField.getText(), "Valor Compra");
		ProdutoBean pbean = new ProdutoBean();
		
		if(validaCampos() && id == null){
			
			try{
				pbean.salvar(nomeTextField.getText(), descricaoTextField.getText(),
							 quantidade, medidaTextField.getText(), 
							 marcaTextField.getText(), valorVenda,
							 categoriaSelecionada, valorCompra);
				Alert alerta = new Alert(AlertType.INFORMATION);
				alerta.setHeaderText("Salvar Produto");
				alerta.setContentText("PRODUTO SALVO COM SUCESSO");
				alerta.showAndWait();

			}catch (NumberFormatException e) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Houve algum erro");
				alerta.setContentText("Contate o administrador. Codigo do erro "+e.getMessage());
				alerta.showAndWait();
			}
		}else{
			try{
				pbean.editar(id, nomeTextField.getText(), descricaoTextField.getText(),
						 quantidade, medidaTextField.getText(), 
						 marcaTextField.getText(), valorVenda,
						 categoriaSelecionada);
				Alert alerta = new Alert(AlertType.INFORMATION);
				alerta.setHeaderText("Editar Produto");
				alerta.setContentText("PRODUTO EDITADO COM SUCESSO");
				alerta.showAndWait();

			}catch (NumberFormatException e) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Houve algum erro");
				alerta.setContentText("Contate o administrador: Código do erro "+e.getMessage());
				alerta.showAndWait();
			}
		}
	}
	
	@FXML
	private void novoProduto(){
		nomeTextField.setText("");
		descricaoTextField.setText("");
		quantidadeTextField.setText("");
		medidaTextField.setText("");
		marcaTextField.setText("");
		valorVendaTextField.setText("");
		categoriaComboBox.getSelectionModel().clearSelection();
	}
	
	@FXML
	private void iniciarPesquisa(){
		if(!botaoPesquisar.getText().equals("Selecionar")){
			main.iniciaTelaPesquisaProduto(this);
		}else{
			produtoSelecionadoParaPedido();
		}
	}

	private void produtoSelecionadoParaPedido() {
		Double quantidade = converteParaDouble(quantidadeTextField.getText(), "Quantidade");
		Double valorVenda = converteParaDouble(valorVendaTextField.getText(), "Valor Venda");
		Double valorCompra = converteParaDouble(valorCompraTextField.getText(), "Valor Compra");
		produto.setMarca(marcaTextField.getText());
		produto.setCategoria(categoriaSelecionada);
		produto.setMedida(medidaTextField.getText());
		produto.setValorVenda(valorVenda);
		produto.setQuantidade(quantidade);
		produto.setValorCompra(valorCompra);
		pedidosController.recebeProduto(produto);
		palco.close();
	}
	
	@FXML
	private void fechar(){
		try {
			main.stop();
			palco.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Double converteParaDouble(String valor, String campo){
		if(valor.contains(",")){
			String[] separadoPorVirgula = valor.split(",");
			valor=separadoPorVirgula[0]+"."+separadoPorVirgula[1];
		}
		
		try {
			Double valorConvertido = Double.parseDouble(valor);
			return valorConvertido;
		} catch (NumberFormatException e) {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Há campos Inválidos");
			alerta.setContentText("Digite Apenas números no campo "+campo);
			alerta.showAndWait();
			return null;
		}
		
	}

	private boolean validaCampos(){
		if(nomeTextField.getText() == null || nomeTextField.getText().length() == 0){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Há campos Inválidos");
			alerta.setContentText("O campo Nome está Vazio");
			alerta.showAndWait();
			return false;
		}else if(descricaoTextField.getText() == null || descricaoTextField.getText().length() == 0){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Há campos Inválidos");
			alerta.setContentText("O campo Descrição está Vazio");
			alerta.showAndWait();
			return false;
		}else if(quantidadeTextField.getText() == null || quantidadeTextField.getText().length() == 0){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Há campos Inválidos");
			alerta.setContentText("O campo Quantidade está Vazio");
			alerta.showAndWait();
			return false;
		}else if(medidaTextField.getText() == null || medidaTextField.getText().length() == 0){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Há campos Inválidos");
			alerta.setContentText("O campo Medida está Vazio");
			alerta.showAndWait();
			return false;
		}else if(valorVendaTextField.getText() == null || valorVendaTextField.getText().length() == 0){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Há campos Inválidos");
			alerta.setContentText("O campo Valor Venda está Vazio");
			alerta.showAndWait();
			return false;
		}else if(marcaTextField.getText() == null || marcaTextField.getText().length()==0){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Há campos Inválidos");
			alerta.setContentText("O campo Marca está Vazio");
			alerta.showAndWait();
			return false;
		}else if(categoriaSelecionada == null){
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Há campos Inválidos");
			alerta.setContentText("Selecione uma categoria");
			alerta.showAndWait();
			return false;
		}else{
			return true;
		}
	}
	
	public void recebeProduto(Produto p){
		id = p.getIdProduto();
		nomeTextField.setText(p.getNome());
		descricaoTextField.setText(p.getDescricao());
		quantidadeTextField.setText(String.valueOf(p.getQuantidade()));
		medidaTextField.setText(p.getMedida());
		valorVendaTextField.setText(String.valueOf(p.getValorVenda()));
		marcaTextField.setText(p.getMarca());
		categoriaComboBox.getSelectionModel().select(p.getCategoria().getCategoria());
	}

	public void recebePedidosController(PedidosController pedidosController) {
		this.pedidosController = pedidosController;	
	}

	public void recebeProdutoCompra(Produto p) {
		this.produto = p;
		nomeTextField.setEditable(false);
		descricaoTextField.setEditable(false);
		botaoSalvar.setVisible(false);
		botaoCancelar.setVisible(false);
		botaoNovo.setVisible(false);
		botaoPesquisar.setText("Selecionar");
	}
}
