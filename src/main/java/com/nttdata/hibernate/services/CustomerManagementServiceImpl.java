package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistance.Customer;
import com.nttdata.hibernate.persistance.CustomerDaoI;
import com.nttdata.hibernate.persistance.CustomerDaoImpl;

public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	/** DAO: NTTDATA_CUSTOMER */

	@SuppressWarnings("rawtypes")
	private CustomerDaoI customerDao;

	/**
	 * Método Constructor
	 * 
	 * @param customerDao
	 */
	public CustomerManagementServiceImpl(Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insertNewCustomer(Customer newCustomer) {
		// Comprobar nulidad e inexistencia
		if (newCustomer != null && newCustomer.getCustomerID() == null) {

			// Insertar un nuevo cliente
			customerDao.insert(newCustomer);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateCustomer(Customer updateCustomer) {
		// Comprobar nulidad e inexistencia
		if (updateCustomer != null && updateCustomer.getCustomerID() == null) {
			// Actualizar cliente
			customerDao.update(updateCustomer);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteCustomer(Customer deleteCustomer) {

		if (deleteCustomer != null && deleteCustomer.getCustomerID() == null) {
			// Borrar cliente
			customerDao.delete(deleteCustomer);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByFullName(String customerName, String customerLastName,
			String customerSecondLastName) {
		// Lista resultado
		List<Customer> customerList = new ArrayList<>();

		// Comprobación nulidad
		if (StringUtils.isNotBlank(customerName)) {
			customerList = customerDao.searchByNameAndLastNames(customerName, customerLastName, customerSecondLastName);
		}

		return customerList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchAll() {

		List<Customer> customerList;

		customerList = customerDao.searchAll();

		return customerList;
	}

	public Customer searchById(Long customerID) {

		// Resultado.
		Customer customer = null;

		// Verificación de nulidad.
		if (customerID != null) {

			// Obtención del jugador por ID.
			customer = (Customer) customerDao.searchById(customerID);
		}

		return customer;
	}

}
