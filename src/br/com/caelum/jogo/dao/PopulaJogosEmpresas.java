package br.com.caelum.jogo.dao;

import javax.persistence.EntityManager;

import br.com.caelum.jogo.modelo.Empresa;
import br.com.caelum.jogo.modelo.Jogo;


public class PopulaJogosEmpresas {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Empresa empresa1 = geraEmpresa("Blizzard");
		em.persist(empresa1);
		Empresa empresa2 = geraEmpresa("Valve");
		em.persist(empresa2);
		Empresa empresa3 = geraEmpresa("Rockstar");
		em.persist(empresa3);
		
		Jogo jogo1 = geraJogo("World of Warcraft", 120.90, "MMORPG", empresa1.getId());
		em.persist(jogo1);
		Jogo jogo2 = geraJogo("Counter Strike", 20.50, "FPS", empresa2.getId());
		em.persist(jogo2);
		Jogo jogo3 = geraJogo("GTA", 70.0, "Mundo Aberto", empresa3.getId());
		em.persist(jogo3);
		Jogo jogo4 = geraJogo("Half-Life", 20.0, "FPS", empresa2.getId());
		em.persist(jogo4);
		
	
		
		em.getTransaction().commit();
		em.close();
		
	}

	private static Empresa geraEmpresa(String nomeEmpresa) {
		Empresa empresa = new Empresa();
		empresa.setNomeEmpresa(nomeEmpresa);
		return empresa;
	}

	private static Jogo geraJogo(String nome, double preco, String estilo, Integer empresaId) {
		Jogo jogo = new Jogo();
		
//		Empresa abc = new Empresa();
//		abc.setId(empresaId);
		
		jogo.setEmpresa(new Empresa(empresaId));
		jogo.setNome(nome);
		jogo.setPreco(preco);
		jogo.setEstilo(estilo);
		return jogo;
	}
	
//	private static Jogo geraJogo(String nome, double preco, String estilo, Empresa empresa ) {
//		Jogo jogo = new Jogo();
//		
////		Empresa abc = new Empresa();
////		abc.setId(empresaId);
//		
//		jogo.setEmpresa(empresa);
//		jogo.setNome(nome);
//		jogo.setPreco(preco);
//		jogo.setEstilo(estilo);
//		return jogo;
//	}
}
