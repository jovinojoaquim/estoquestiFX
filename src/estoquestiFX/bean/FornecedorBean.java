package estoquestiFX.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import Validator.Validar;
import estoquestiFX.dao.FornecedorDAO;
import estoquestiFX.domain.Contato;
import estoquestiFX.domain.Endereco;
import estoquestiFX.domain.Fornecedor;

public class FornecedorBean {


	public void salvar(String razaoSocial, String nomeFantasia, String cnpj, String inscricaoEstadual, String site, List<Endereco> endereco,
			String telefoneComercial, String telefoneCelular, String email) {
			Fornecedor f = new Fornecedor();
			FornecedorDAO dao = new FornecedorDAO();
			Contato c = new Contato();
			List<Contato> listaContato = new ArrayList<>();
			System.out.println("salvar");
			c.setTelefoneCelular(telefoneCelular);
			c.setEmail(email);
			c.setTelefoneComercial(telefoneComercial);
			listaContato.add(c);
			
			f.setRazaoSocial(razaoSocial);
			f.setNomeFantasia(nomeFantasia);
			f.setCnpj(cnpj);
			f.setInscricaoEstadual(inscricaoEstadual);
			f.setSite(site);
			f.setEndereco(endereco);
			f.setContato(listaContato);
			System.out.println("salvar");
			Set<ConstraintViolation<Contato>> validacaoContato = Validar.getFabricaValidacao().validate(c);
			Set<ConstraintViolation<Fornecedor>> validacaoFornecedor = Validar.getFabricaValidacao().validate(f);
			
			try{
				dao.salvar(f);
			}catch (RuntimeException e) {
				e.printStackTrace();
				if(validacaoContato.iterator().next().getMessage()!= null){
					throw new RuntimeException(validacaoContato.iterator().next().getMessage());
				}else{
					throw new RuntimeException(validacaoFornecedor.iterator().next().getMessage());
				}
			}
	}

	public List<Fornecedor> buscar(String razaoSocial) {
		FornecedorDAO dao = new FornecedorDAO();
		return dao.buscar(razaoSocial);
	}
	
}
