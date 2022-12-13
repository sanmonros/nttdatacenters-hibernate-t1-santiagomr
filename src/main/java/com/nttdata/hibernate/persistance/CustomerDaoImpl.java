package com.nttdata.hibernate.persistance;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Segundo - Taller - Hibernate
 * 
 * DAO de tabla NTTDATA_CUSTOMER implementación
 * 
 * @author santiagomr
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	/** Sesión conexión a BBDD */
	private Session session;

	/**
	 * Método constructor
	 */
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByNameAndLastNames(String customerName, String customerLastName,
			String customerSecondLastName) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Filtra clientes en función del nombre completo.
		return session.createQuery("FROM Customer WHERE customerName='" + customerName + "' AND customerLastName='"
				+ customerLastName + "' AND customerSecondLastName='" + customerSecondLastName + "'").list();

	}

	@Override
	public List<Customer> searchByNameAndContractId(String name, Long contractID) {

		// Consultas criteria.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Customer> cquery = cb.createQuery(Customer.class);
		final Root<Customer> root = cquery.from(Customer.class);
		final Join<Customer, Contract> pJoinT = root.join("contract");

		// Where.

		Predicate pre1 = cb.equal(pJoinT.<Long>get("contractID"), contractID);

		Predicate pre2 = cb.like(root.<String>get("customerName"), name);

		// Consulta.
		cquery.select(root).where(cb.and(pre1, pre2));

		// Ejecución de consulta.
		return session.createQuery(cquery).getResultList();
	}

}
