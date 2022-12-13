package com.nttdata.hibernate.persistance;

import org.hibernate.Session;

/**
 * Segundo - Taller - Hibernate
 * 
 * DAO Tabla NTTDATA_CONTRACT implementación
 * 
 * @author santiagomr
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/**
	 * Método constructor
	 * 
	 * @param session
	 */
	public ContractDaoImpl(Session session) {
		super(session);
	}

}
