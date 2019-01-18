package dao;

import javax.persistence.EntityManager;

import service.DatabaseHelper;

public interface DAO<T> {
	
	public default void create(T entity) {
		
		EntityManager em = DatabaseHelper.createEntityManager();
		try {
			DatabaseHelper.beginTx(em);
			em.persist(entity);
			DatabaseHelper.commitTxAndClose(em);
		} catch (Exception e) {
			DatabaseHelper.rollbackTxAndClose(em);
			throw new MyOwnRuntimeException(e);
		}
	}

	public default void update(T entity) {

		EntityManager em = DatabaseHelper.createEntityManager();
		try {
			DatabaseHelper.beginTx(em);
			em.merge(entity);
			DatabaseHelper.commitTxAndClose(em);
		} catch (Exception e) {
			DatabaseHelper.rollbackTxAndClose(em);
			throw new RuntimeException(e);
		}
	}

	public abstract void delete(T entity);
}
