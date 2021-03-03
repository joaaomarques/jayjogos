package br.com.caelum.jogo.bean;

import javax.faces.bean.ManagedBean;

import br.com.caelum.jogo.dao.DAO;
import br.com.caelum.jogo.modelo.Empresa;

@ManagedBean
public class EmpresaBean {
	
	private Empresa empresa = new Empresa();
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public String gravar() {
		System.out.println("Gravando Empresa: " + this.empresa.getNomeEmpresa());
		
		new DAO<Empresa>(Empresa.class).adiciona(this.empresa);
		
		return "jogo?faces-redirect=true";
	}
	
}
