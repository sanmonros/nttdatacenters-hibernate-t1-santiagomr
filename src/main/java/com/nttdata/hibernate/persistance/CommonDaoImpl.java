package com.nttdata.hibernate.persistance;

import java.lang.reflect.ParameterizedType;

import java.util.List;

import org.hibernate.Session;

/**
 * Segundo - Taller - Hibernate
 * 
 * Implementación DAO genérico
 * 
 * @author santiagomr
 */
public abstract class CommonDaoImpl<C extends AbstractEntity> implements CommonDaoI<C> {

	/** Tipo de clase */
	private Class<C> entityClass;

	/** Sesion conexión a BBDD */
	private Session session;

	/**
	 * Método constructor
	 * 
	 * @param session
	 */

	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<C>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(C paramC) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(paramC);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void update(C paramC) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramC);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void delete(C paramC) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción.
		session.delete(paramC);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public C searchById(Long id) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		return session.get(this.entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<C> searchAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		return session.createQuery("FROM " + this.entityClass.getName()).list();
	}

	/**
	 * @return the entityClass
	 */
	public Class<C> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 * 
	 */
	public void setEntityClass(Class<C> entityClass) {
		this.entityClass = entityClass;
	}

}
