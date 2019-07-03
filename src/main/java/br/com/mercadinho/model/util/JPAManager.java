package br.com.mercadinho.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;

public class JPAManager {

	private static JPAManager manager;
	private EntityManagerFactory sessionFactory;

	private JPAManager() {
		sessionFactory = Persistence.createEntityManagerFactory("mercadinho");

		sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("mercadinho");
	}

	public static JPAManager getInstance() {
		if (manager == null) {
			manager = new JPAManager();
		}

		return manager;
	}

	public EntityManager getEntityManager() {
		return sessionFactory.createEntityManager();
	}

	public Object autenticar(String cpf, String senha) {

		EntityManager session = getEntityManager();
		Object obj = null;
		try {
			Query consulta = session.createQuery("SELECT u FROM Usuario u WHERE u.cpf =: usuario AND u.senha = :senha");
			consulta.setParameter("cpf", cpf);
			consulta.setParameter("senha", senha);
			obj = consulta.getSingleResult();
		} finally {
			session.close();
		}
		return obj;
	}

}
