package com.nttdata.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistance.Customer;
import com.nttdata.hibernate.services.CustomerManagementServiceI;
import com.nttdata.hibernate.services.CustomerManagementServiceImpl;

/**
 * Primer Taller - Hibernate
 * 
 * Clase Principal
 * 
 * @author santiagomr
 *
 */
public class NTTDataMain {
	public static void main(String[] args) {

		// Apertura de sesión.
		Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);

		// Generación de clientes.
		Customer c1 = new Customer();
		c1.setCustomerName("Paco");
		c1.setCustomerLastName("Sánchez");
		c1.setCustomerSecondLastName("Perez");
		c1.setCustomerDni("765434515");

		Customer c2 = new Customer();
		c2.setCustomerName("Laura");
		c2.setCustomerLastName("Rosario");
		c2.setCustomerSecondLastName("Salguero");
		c2.setCustomerDni("83454515");

		Customer c3 = new Customer();
		c3.setCustomerName("Claudia");
		c3.setCustomerLastName("Serrano");
		c3.setCustomerSecondLastName("López");
		c3.setCustomerDni("32134515");

		Customer c4 = new Customer();
		c4.setCustomerName("Julia");
		c4.setCustomerLastName("Montaño");
		c4.setCustomerSecondLastName("Rodriguez");
		c4.setCustomerDni("623456515");

		Customer c5 = new Customer();
		c5.setCustomerDni(null);
		c5.setCustomerName("Manolo");
		c5.setCustomerLastName("García");
		c5.setCustomerSecondLastName("Maestre");
		c5.setCustomerDni("123544515");

		// Insertar nuevos clientes

		customerService.insertNewCustomer(c1);
		customerService.insertNewCustomer(c2);
		customerService.insertNewCustomer(c3);
		customerService.insertNewCustomer(c4);
		customerService.insertNewCustomer(c5);

		// Borrar clientes

		c5.setCustomerID(null);
		customerService.deleteCustomer(c5);

		// Consulta de nombres y apellidos

		List<Customer> customers = customerService.searchByFullName("Laura", "Rosario", "Salguero");

		for (Customer customer : customers) {
			System.out.println(customer.getCustomerName() + " | " + customer.getCustomerLastName() + " | "
					+ customer.getCustomerSecondLastName());
		}

		// Consulta de todos los clientes

		List<Customer> customerList = customerService.searchAll();
		for (Customer customer : customerList) {
			System.out.println(customer.toString());
		}

		// Consulta de los clientes por ID

		long customerID = 3L;
		Customer searchID = customerService.searchById(customerID);
		if (searchID != null) {
			System.out.println("Encontrado cliente con ID = " + customerID);
			System.out.println(searchID.toString());
		}

		// Cierre de sesión.
		session.close();

	}
}
