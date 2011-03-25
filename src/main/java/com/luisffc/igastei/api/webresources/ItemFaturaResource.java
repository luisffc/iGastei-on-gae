package com.luisffc.igastei.api.webresources;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.luisffc.igastei.model.ItemFatura;
import com.luisffc.igastei.server.ItemFaturaRepository;

@Path("/itensFatura")
@Produces(MediaType.APPLICATION_XML)
public class ItemFaturaResource {
	
	ItemFaturaRepository repository = new ItemFaturaRepository();
	
	@GET
	public Collection<ItemFatura> listAll(){
		return repository.getAll();
	}
	
	@GET
	@Path("/{id}")
	public ItemFatura getById(@PathParam("id") Long id){
		return repository.getById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public ItemFatura save(ItemFatura itemFatura){
		repository.save(itemFatura);
		return itemFatura;
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id){
		repository.deleteById(id);
	}
	
}
