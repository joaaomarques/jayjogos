package br.com.caelum.jogo.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Imagem {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private Jogo imagemJogo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Jogo getImagemJogo() {
		return imagemJogo;
	}

	public void setImagemJogo(Jogo imagemJogo) {
		this.imagemJogo = imagemJogo;
	}
	
	
	
}
