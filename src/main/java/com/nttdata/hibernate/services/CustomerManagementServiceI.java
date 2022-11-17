package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistance.Customer;

public interface CustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(Customer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(Customer updateCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(Customer deleteCustomer);

	/**
	 * Obtiene un cliente mediante su nombre completo
	 * 
	 * @param customerName
	 * @param customerLastname
	 * @param customerLastName
	 * @return
	 */
	public List<Customer> searchByFullName(String customerName, String customerLastname, String customerLastName);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<Customer>
	 */

	public List<Customer> searchAll();

	/**
	 * 
	 * @param customerID
	 * @return
	 */
	public Customer searchById(Long customerID);

}
