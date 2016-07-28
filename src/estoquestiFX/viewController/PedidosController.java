package estoquestiFX.viewController;

import estoquestiFX.app.PesquisarFornecedorMain;
import estoquestiFX.domain.Fornecedor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PedidosController {
	Fornecedor fornecedor;
	
	@FXML
	private TextField textFieldFornecedor;
	
	@FXML
	private void buscarFornecedor(){
		PesquisarFornecedorMain main = new PesquisarFornecedorMain();
		main.setPedidosController(this);
	}

	public void recebeFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		textFieldFornecedor.setText(fornecedor.getRazaoSocial()+" - "+fornecedor.getNomeFantasia());		
	}
}
