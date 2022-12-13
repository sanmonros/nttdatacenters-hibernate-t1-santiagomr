package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistance.Contract;
import com.nttdata.hibernate.persistance.Customer;
import com.nttdata.hibernate.services.ManagementServiceI;
import com.nttdata.hibernate.services.ManagementServiceImpl;

/**
 * Segundo - Taller - Hibernate
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
		ManagementServiceI contractService = new ManagementServiceImpl(session);

		// Auditoria.
		String updatedUser = "santiagomr";
		Date updatedDate = new Date();

		// Generación de clientes.
		Customer c1 = new Customer();
		c1.setCustomerName("Paco");
		c1.setCustomerLastName("Sánchez");
		c1.setCustomerSecondLastName("Perez");
		c1.setCustomerDni("765434513");
		c1.setUpdatedUser(updatedUser);
		c1.setUpdatedDate(updatedDate);

		Customer c2 = new Customer();
		c2.setCustomerName("Laura");
		c2.setCustomerLastName("Rosario");
		c2.setCustomerSecondLastName("Salguero");
		c2.setCustomerDni("834545151");
		c2.setUpdatedUser(updatedUser);
		c2.setUpdatedDate(updatedDate);

		// Insertar clientes
		contractService.insertNewCustomer(c1);
		contractService.insertNewCustomer(c2);

		// Generación de contrato
		Contract co1 = new Contract();
		co1.setEffectiveDate("2018-01-12");
		co1.setExpiryDate("2022-12-12");
		co1.setContractPrice(2500.00);
		co1.setUpdatedUser(updatedUser);
		co1.setUpdatedDate(updatedDate);

		// Asignación contrato a cliente
		c1.setContract(co1);
		c2.setContract(co1);

		// Insertar nuevos contratos
		contractService.insertNewContract(co1);

		// Búsqueda de cliente por nombre completo
		List<Customer> customerFullName = contractService.searchByNameAndLastNames("Paco", "Sánchez", "Perez");

		// Búsqueda de todos los clientres con su correspondiente información
		List<Customer> customerNames = contractService.searchAll();

		// Búsqueda de todos los clientes por su ID
		long customerID = 1L;
		Customer searchID = contractService.searchById(customerID);
		if (searchID != null) {
			System.out.println("Encontrado cliente con ID = " + customerID);
			System.out.println(searchID.toString());
		}

		// Busqueda de clientes por nombre e Id de contrato.
		// Criteria.
		List<Customer> customerNameContract = contractService.searchByNameAndContractId("L%", 3L);

		// Generacion de resultados:
		// Consulta HQL.
		for (Customer customer : customerFullName) {

			System.out.println(customer.getCustomerName() + " " + customer.getCustomerLastName() + " "
					+ customer.getCustomerSecondLastName());

		}

		for (Customer customer : customerNames) {

			System.out.println(customer.toString());

		}

		// Consulta Criteria.

		String ContractPrice;

		for (final Customer customer : customerNameContract) {

			ContractPrice = String.format("%.0f", customer.getContract().getContractPrice());

			System.out.println(
					"Nombre: " + customer.getCustomerName() + ", " + " Apellido: " + customer.getCustomerLastName()
							+ ", " + "Segundo Apellido : " + customer.getCustomerSecondLastName() + ", "
							+ "ID Contrato : " + customer.getContract().getContractID() + ", " + "Fecha de expiración :"
							+ customer.getContract().getExpiryDate() + ", " + "Precio de contrato: " + ContractPrice);

		}

		// Cierre de sesión.
		session.close();

	}
}
