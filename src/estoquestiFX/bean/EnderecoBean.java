package estoquestiFX.bean;

import estoquestiFX.domain.Cidade;
import estoquestiFX.domain.Endereco;

public class EnderecoBean {

	public void salvar(String logradouro, String numero, String complemento, String bairro, String cep, 
			Cidade cidade) {
		Endereco e = new Endereco();
		e.setLogradouro(logradouro);		
	}

}
