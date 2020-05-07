package com.care.service;

import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.care.transaction_dao.TicketDAO;
import com.care.transaction_dto.TicketDTO;

public class TicketServiceimpl implements TicketService{
	private TicketDAO dao;
	public TicketServiceimpl() {
		String config="classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx=
				new GenericXmlApplicationContext(config);
		dao=ctx.getBean("dao",TicketDAO.class);
	
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map= model.asMap();
		TicketDTO dto=(TicketDTO)map.get("dto");
		int arr[]= new int[2];
		arr=dao.buyTicket(dto);
		model.addAttribute("arr",arr);
		
		
	}
}
