package br.inatel.labs.labrest_client.model;

public class Curso {
	private long id;
	private String descricao;
	private Integer cargaHoraria;
	
	public Curso(long id, String descricao, Integer horario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cargaHoraria = horario;
	}
	
	public Curso() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	
}
