package com.luisffc.igastei.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ItemFatura implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent
	private String cartao;

	@Persistent
	private Date data;

	@Persistent
	private String descOperadora;
	
	@Persistent
	private double valorOperadora;
	
	@Persistent
	private String descricao;
	
	@Persistent
	private String emprestado;
	
	@Persistent
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescOperadora() {
		return descOperadora;
	}

	public void setDescOperadora(String descOperadora) {
		this.descOperadora = descOperadora;
	}

	public double getValorOperadora() {
		return valorOperadora;
	}

	public void setValorOperadora(double valorOperadora) {
		this.valorOperadora = valorOperadora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(String emprestado) {
		this.emprestado = emprestado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemFatura other = (ItemFatura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
