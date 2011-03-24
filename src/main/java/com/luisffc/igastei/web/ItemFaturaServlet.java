package com.luisffc.igastei.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luisffc.igastei.model.ItemFatura;
import com.luisffc.igastei.server.ItemFaturaRepository;

public class ItemFaturaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(IndexServlet.class);

	private ItemFaturaRepository itemFaturaRepository = new ItemFaturaRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String action = req.getParameter("action");

		if("create".equals(action)){
			create(req);
			resp.sendRedirect("compras-cartao");
			return;
		}else if("update".equals(action)){
			update(req);
			resp.sendRedirect("compras-cartao");
			return;
		}else if("get".equals(action)){
			get(req);
		}else if("delete".equals(action)){
			delete(req);
			resp.sendRedirect("compras-cartao");
			return;
		}else{
			list(req);
		}

		forward(req, resp, "compras-cartao.jsp");
	}

	private void create(HttpServletRequest req){
		ItemFatura item = new ItemFatura();
		item.setCartao(req.getParameter("cartao"));
		item.setDescOperadora(req.getParameter("descOperadora"));
		item.setValorOperadora(Double.parseDouble(req.getParameter("valorOperadora")));
		itemFaturaRepository.create(item);
	}

	private void update(HttpServletRequest req){

	}

	private void delete(HttpServletRequest req){
		itemFaturaRepository.deleteById(Long.parseLong(req.getParameter("id")));
	}

	private void get(HttpServletRequest req){

	}

	private void list(HttpServletRequest req){
		Collection<ItemFatura> lista = itemFaturaRepository.getAll();
		req.setAttribute("lista", lista);
	}

	/**
	 * Forwards request and response to given path. Handles any exceptions
	 * caused by forward target by printing them to logger.
	 * 
	 * @param request 
	 * @param response
	 * @param path 
	 */
	protected void forward(HttpServletRequest request,
			HttpServletResponse response, String path) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} catch (Throwable tr) {
			if (log.isErrorEnabled()) {
				log.error("Cought Exception: " + tr.getMessage());
				log.debug("StackTrace:", tr);
			}
		}
	}

}
