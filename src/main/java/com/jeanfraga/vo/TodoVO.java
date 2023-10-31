package com.jeanfraga.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

public class TodoVO extends RepresentationModel<TodoVO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long key;
	private String nome;
	private String descricao;
	private boolean realizado;
	private Integer prioridade;
	
	public TodoVO() {}

	public TodoVO(Long key, String nome, String descricao, boolean realizado, Integer prioridade) {
		this.key = key;
		this.nome = nome;
		this.descricao = descricao;
		this.realizado = realizado;
		this.prioridade = prioridade;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(key, descricao, nome, prioridade, realizado);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoVO other = (TodoVO) obj;
		return Objects.equals(key, other.key) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(nome, other.nome) && Objects.equals(prioridade, other.prioridade)
				&& realizado == other.realizado;
	};
	
	
}
