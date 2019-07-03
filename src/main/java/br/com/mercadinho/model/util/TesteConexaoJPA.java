package br.com.mercadinho.model.util;

import javax.persistence.EntityManager;

public class TesteConexaoJPA {

	public static void main(String[] args) {

		try {

			EntityManager em = JPAManager.getInstance().getEntityManager();

			try {

				em.getTransaction().begin();
				String sql = "select version()";
				String result = (String) em.createNativeQuery(sql).getSingleResult();
				System.out.println(result);
				em.getTransaction().commit();

			} finally {
				em.close();
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Atualização feita com sucesso.");
	}

}
