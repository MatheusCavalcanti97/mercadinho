package br.com.mercadinho.model.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.mercadinho.model.entidades.Usuario;
import br.com.mercadinho.model.util.JPAManager;

public class UsuarioDaoImpl extends DAOImpl<Usuario> implements UsuarioDao {

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}

	@PersistenceContext(unitName = "Mercadinho")
	private EntityManager manager = JPAManager.getInstance().getEntityManager();

	
	public Usuario buscarPorId(Integer id) {
		return manager.createQuery("SELECT DISTINCT (u) from Usuario u where u.id = :id", Usuario.class)
				.setParameter("id", id).getSingleResult();
	}

	public Usuario consultarPorLogin(String cpf) {
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u" + "WHERE u.cpf=:cpf", Usuario.class);
		query.setParameter("cpf", cpf);
		Optional<Usuario> usuario = query.getResultList().stream().findFirst();
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			return null;
		}
	}

	public Usuario autenticarUsuario(String cpf, String senha) {
		TypedQuery<Usuario> query = manager
				.createQuery("SELECT u FROM Usuario u WHERE u.cpf=:cpf " + "AND u.senha=:senha", Usuario.class);
		query.setParameter("cpf", cpf);
		query.setParameter("senha", senha);
		Optional<Usuario> usuario = query.getResultList().stream().findFirst();
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			return null;
		}
	}

}
