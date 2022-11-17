package com.nttdata.hibernate.persistance;

import java.util.List;

import org.hibernate.Session;

/**
 * Primer Taller - Hibernate
 * 
 * DAO de tabla NTTDATA_CUSTOMER
 * 
 * @author santiagomr
 *
 */
public class CustomerDaoImpl implements CustomerDaoI<Object> {

	/** Sesión conexión a BBDD */
	private Session session;

	/**
	 * Método constructor
	 */
	public CustomerDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void insert(Object paramC) {
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
	public void update(Object paramC) {
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
	public void delete(Object paramC) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(paramC);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public Object searchById(Long customerID) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		return session.createQuery("FROM Customer WHERE customerID='" + customerID + "'").getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByNameAndLastNames(String customerName, String customerLastName,
			String customerSecondLastName) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Filtra clientes en función del nombre.
		return session
				.createQuery("FROM Customer WHERE customerName='" + customerName + "'" + "AND customerLastName='"
						+ customerLastName + "'" + "AND customerSecondLastName='" + customerSecondLastName + "'")
				.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> searchAll() {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		return session.createQuery("FROM Customer").list();
	}

}
