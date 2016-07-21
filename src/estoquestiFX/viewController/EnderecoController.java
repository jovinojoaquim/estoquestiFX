package estoquestiFX.viewController;

import estoquestiFX.app.PesquisarCidadeMain;
import estoquestiFX.bean.EnderecoBean;
import estoquestiFX.domain.Cidade;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EnderecoController {
	Cidade cidade;
	
	@FXML
	private TextField textFieldLogradouro;
	
	@FXML
	private TextField textFieldNumero;
	
	@FXML
	private TextField textFieldComplemento;
	
	@FXML
	private TextField textFieldBairro;
	
	@FXML
	private TextField textFieldCidade;
	
	@FXML
	private TextField textFieldCep;
	
	@FXML
	private TextField textFieldEstado;

	Stage palco;

	private PesquisarEnderecoController pesquisarEnderecoController;
	
	@FXML
	private void buscarCidade(){
		PesquisarCidadeMain main = new PesquisarCidadeMain();
		
		Stage stage = new Stage();
		stage.setTitle("Buscar Cidade");
		stage.initModality(Modality.WINDOW_MODAL);
		main.setControllerEndereco(this);
		main.start(stage);
	}
	
	@FXML
	private void salvar(){
		EnderecoBean bean = new EnderecoBean();
		bean.salvar(textFieldLogradouro.getText(), textFieldNumero.getText(), textFieldComplemento.getText(),
				textFieldBairro.getText(), textFieldCep.getText(), cidade);
		palco.close();
		pesquisarEnderecoController.listar(pesquisarEnderecoController.listarEnderecos());
	}
	
	public void recebeCidade(Cidade cidade){
		this.cidade = cidade;
		textFieldCidade.setText(cidade.getCidade());
		textFieldEstado.setText(cidade.getEstado().getNomeEstado());
	}

	@FXML
	private void apenasNumero(){
		textFieldCep.setText(textFieldCep.getText().replaceAll("\\D", ""));
		textFieldCep.positionCaret(textFieldCep.getLength());
	}
	
	@FXML
	private void cancelar(){
		palco.close();
	}
	
	public void setPalco(Stage primaryStage) {
		this.palco = primaryStage;
	}

	public void recebePesquisarEnderecoController(PesquisarEnderecoController pesquisarEnderecoController) {
		this.pesquisarEnderecoController = pesquisarEnderecoController;
	}
	
}
