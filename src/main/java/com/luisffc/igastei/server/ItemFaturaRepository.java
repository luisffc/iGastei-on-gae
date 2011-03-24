package com.luisffc.igastei.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.luisffc.igastei.model.ItemFatura;
import com.luisffc.igastei.server.repository.helper.ConnectionFactory;

public class ItemFaturaRepository {

	PersistenceManagerFactory pmfInstance = new ConnectionFactory().getPmfInstance();

	public Collection<ItemFatura> getAll() {
		PersistenceManager pm = pmfInstance.getPersistenceManager();
		try {
			List<ItemFatura> itemFaturaList = new ArrayList<ItemFatura>();
		    Extent<ItemFatura> extent = pm.getExtent(ItemFatura.class, false);
		    for (ItemFatura itemFatura : extent) {
		        itemFaturaList.add(itemFatura);
		    }
		    extent.closeAll();
			
		    return itemFaturaList;
		} finally {
			pm.close();
		}
	}
	
	public void create(ItemFatura itemFatura) {
		PersistenceManager pm = pmfInstance.getPersistenceManager();
		try {
		    pm.makePersistent(itemFatura);
		} finally {
			pm.close();
		}
	}

	public void deleteById(Long id) {
		PersistenceManager pm = pmfInstance.getPersistenceManager();
		try {
			pm.deletePersistent(pm.getObjectById(ItemFatura.class, id));
		} finally {
			pm.close();
		}
	}
}
