package estoquestiFX.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import estoquestiFX.dao.PedidoDAO;
import estoquestiFX.dao.ProdutoDAO;
import estoquestiFX.domain.Fornecedor;
import estoquestiFX.domain.Pedido;
import estoquestiFX.domain.PedidosProduto;
import estoquestiFX.domain.Produto;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;

public class PedidoBean {
	public void salvar(Fornecedor fornecedor, DatePicker datePickerData, CheckBox checkBoxAprovado, List<Produto> listaDeProdutos) throws ParseException{
		Pedido p = new Pedido();
		PedidosProduto pp = new PedidosProduto();
		PedidoDAO dao = new PedidoDAO();
		
		if(checkBoxAprovado.isSelected()){
			ProdutoBean pbean = new ProdutoBean();
			for(int i = 0; i< listaDeProdutos.size(); i++){
				Produto produto = pbean.pesquisarProduto(listaDeProdutos.get(i).getIdProduto());
				produto.setQuantidade(produto.getQuantidade()+listaDeProdutos.get(i).getQuantidade());
				produto.setValorVenda(listaDeProdutos.get(i).getValorVenda());
				pbean.editar(produto.getIdProduto(), produto.getNome(), produto.getDescricao(), produto.getQuantidade(), 
						produto.getMedida(), produto.getMarca(), produto.getValorVenda(), produto.getCategoria());
	
			}
			salvarPedido(fornecedor, datePickerData, checkBoxAprovado, listaDeProdutos, p, pp, dao);
		}else{
			salvarPedido(fornecedor, datePickerData, checkBoxAprovado, listaDeProdutos, p, pp, dao);
		}
	}

	private void salvarPedido(Fornecedor fornecedor, DatePicker datePickerData, CheckBox checkBoxAprovado,
							List<Produto> listaDeProdutos, Pedido p, PedidosProduto pp, PedidoDAO dao) {
		List<PedidosProduto> listaDePedidosProduto = new ArrayList<>();
		for(int i =0; i< listaDeProdutos.size(); i++){
			pp.setQuantidade(listaDeProdutos.get(i).getQuantidade());
			pp.setPrecoCompra(listaDeProdutos.get(i).getValorCompra());
			listaDePedidosProduto.add(pp);
		}
				
		p.setFornecedor(fornecedor);
		p.setData(paraDate(datePickerData.getValue()));
		p.setPedidosProduto(listaDePedidosProduto);
		p.setAprovacao(checkBoxAprovado.isSelected());
		
		dao.salvar(p);
	}
	
	private Date paraDate(LocalDate localData){
		Instant instant = localData.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date res = Date.from(instant);
		return res;
	}

}
