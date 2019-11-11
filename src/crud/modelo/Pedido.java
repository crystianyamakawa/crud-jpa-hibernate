package crud.modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String dtPedido;
	private Float valor;
	@OneToMany(mappedBy = "pedido", targetEntity = PedidoItem.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private List<PedidoItem> items;
	public List<PedidoItem> getItems() {
		return items;
	}
	public void setItems(List<PedidoItem> items) {
		this.items = items;
	}
	@ManyToOne
	 @JoinColumn(name="cliente")
	 private Pessoa cliente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDtPedido() {
		return dtPedido;
	}
	public void setDtPedido(String dtPedido) {
		this.dtPedido = dtPedido;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

}
