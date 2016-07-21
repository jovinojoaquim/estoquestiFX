package estoquestiFX.viewController;

import estoquestiFX.domain.Endereco;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FornecedorController {
	
	@FXML
	private TextField textFieldEndereco;
	
	@FXML
	private void salvar(){}

	public void recebeEndereco(Endereco endereco) {
		textFieldEndereco.setText(endereco.getLogradouro());
	}
	
}
