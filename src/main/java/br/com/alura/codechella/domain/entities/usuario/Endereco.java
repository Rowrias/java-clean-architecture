package br.com.alura.codechella.domain.entities.usuario;

public class Endereco {
	private String cep;
	private Integer numero;
	private String complemento;
	
	private Endereco endereco;
	
	// Constructor
	public Endereco(String cep, Integer numero, String complemento) {
		this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
	}
	
	//Getters Setters
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
