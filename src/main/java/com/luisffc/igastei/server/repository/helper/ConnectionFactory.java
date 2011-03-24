package com.luisffc.igastei.server.repository.helper;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class ConnectionFactory {

	private static PersistenceManagerFactory pmfInstance;
	
	public ConnectionFactory(){
		if(pmfInstance == null){
			pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional");
		}
	}
	
	public PersistenceManagerFactory getPmfInstance() {
		return pmfInstance;
	}
}
