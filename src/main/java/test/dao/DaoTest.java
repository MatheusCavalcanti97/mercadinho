package test.dao;

import java.util.List;

public interface DaoTest <T> {
	
	void inserir(T obj);

	void atualizar(T obj);

	void excluir(T obj);

	T buscarPorId(Integer id);

	List<T> buscarTodos();


}
