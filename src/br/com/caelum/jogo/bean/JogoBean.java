package br.com.caelum.jogo.bean;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.caelum.jogo.dao.DAO;
import br.com.caelum.jogo.modelo.Empresa;
import br.com.caelum.jogo.modelo.Jogo;


@ManagedBean
@ViewScoped
public class JogoBean {

	private List<Jogo> jogos = new ArrayList<Jogo>();
		

	private Jogo jogo = new Jogo();
	private Integer jogoId;
	private String imagem = "wowlogo.jpg";
	private Integer empresaId;
	@PostConstruct
	public void iniciar() {
		buscarJogos();
		
	}

	public void buscarJogos() {
		this.jogos = new DAO<Jogo>(Jogo.class).listaTodos();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}
	
	public void buscarJogoPelaId() {
		System.out.println("buscando jogo pela id");
		this.jogo = new DAO<Jogo>(Jogo.class).buscaPorId(jogoId);
		buscarJogos();
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public List<Empresa> getEmpresas() {
		List<Empresa> listaTodos = new DAO<Empresa>(Empresa.class).listaTodos();
		return listaTodos;
	}
	
	public String formEmpresa() {
		return "empresa?faces-redirect=true";
	}

	public void gravar() {

		System.out.println("Gravando Jogo: " + this.jogo.getNome());

		if (empresaId == null) {
			// throw new RuntimeException("Escolha uma empresa");
			FacesContext.getCurrentInstance().addMessage("empresa",
					new FacesMessage("Obrigatório escolher uma empresa para o jogo"));
		}

		this.jogo.setEmpresa(new Empresa(empresaId));
		
		if(this.jogo.getId() == null) {
			new DAO<Jogo>(Jogo.class).adiciona(this.jogo);
		}else {
			new DAO<Jogo>(Jogo.class).atualiza(this.jogo);
		}
		
		this.jogo = new Jogo();
		buscarJogos();
		
	}
	
	public void remover(Jogo jogo) {
		System.out.println("Removendo Jogo");
		new DAO<Jogo>(Jogo.class).remove(jogo);
		buscarJogos();
		
			
	}
	
	public void alterar(Jogo jogo) {
		this.jogo = jogo;
	}
	

}
