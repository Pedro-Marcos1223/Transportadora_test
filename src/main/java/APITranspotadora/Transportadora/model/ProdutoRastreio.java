package APITranspotadora.Transportadora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProdutoRastreio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 15)
	private String codigoDeRastreio;
	
	@NotNull
	@Size(min = 2, max = 50)
	private String estadoDoProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoDeRastreio() {
		return codigoDeRastreio;
	}

	public void setCodigoDeRastreio(String codigoDeRastreio) {
		this.codigoDeRastreio = codigoDeRastreio;
	}

	public String getEstadoDoProduto() {
		return estadoDoProduto;
	}

	public void setEstadoDoProduto(String estadoDoProduto) {
		this.estadoDoProduto = estadoDoProduto;
	}
	
}
