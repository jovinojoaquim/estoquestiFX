package estoquestiFX.viewController;

import java.util.ArrayList;
import java.util.List;

import estoquestiFX.app.PesquisarEnderecoMain;
import estoquestiFX.bean.FornecedorBean;
import estoquestiFX.domain.Endereco;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FornecedorController {
	
	private Stage palco;
	private List<Endereco> endereco = new ArrayList<>();
	
	@FXML
	private TextField textFieldRazaoSocial;
	
	@FXML
	private TextField textFieldNomeFantasia;
	
	@FXML
	private TextField textFieldCNPJ;
	
	@FXML
	private TextField textFieldInscricaoEstadual; 
	
	@FXML
	private TextField textFieldSite;
	
	@FXML
	private TextField textFieldEndereco;
	
	@FXML
	private TextField textFieldTelefoneComercial;
	
	@FXML
	private TextField textFieldCelular;
	
	@FXML
	private TextField textFieldEmail;
	
	
	@FXML
	private void salvar(){
		System.out.println("ss");
		FornecedorBean fbean = new FornecedorBean();
		
		try{
			fbean.salvar(textFieldRazaoSocial.getText(), 
					textFieldNomeFantasia.getText(), 
					textFieldCNPJ.getText(), 
					textFieldInscricaoEstadual.getText(),
					textFieldSite.getText(), 
					endereco, 
					textFieldTelefoneComercial.getText(), 
					textFieldCelular.getText(), 
					textFieldEmail.getText());
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setContentText("Salvo com sucesso");
		}catch (RuntimeException e) {
			e.printStackTrace();
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setContentText(e.getMessage());
			alerta.showAndWait();
		}
	}

	public void recebeEndereco(Endereco endereco) {
		this.endereco.add(endereco);
		textFieldEndereco.setText(endereco.getLogradouro()+ ", "+ endereco.getNumero()+" - "+ endereco.getBairro()+ " - "+endereco.getCidade().getCidade() +" - "+endereco.getCidade().getEstado().getNomeEstado());
	}
	
	@FXML
	private void buscarEndereco(){
		PesquisarEnderecoMain main = new PesquisarEnderecoMain();
		Stage palco = new Stage();
		palco.setResizable(false);
		palco.setTitle("Pesquisar Endereço");
		
		main.setFornecedorController(this);
		main.start(palco);
	}

	public void setStage(Stage primaryStage) {
		this.palco = primaryStage;		
	}
	
}
