package com.ticket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ticket.dao.RemainDAO;
import com.ticket.dao.SeatDAO;
import com.ticket.dto.Remain;
import com.ticket.dto.SelectedTicket;
 
@Controller
public class SeatController {

	@Autowired
	@Qualifier("remainDAO")
	RemainDAO remain;
	
	@Autowired
	@Qualifier("seatDAO")
	SeatDAO seat;
		
	@RequestMapping(value = "/step2", method = RequestMethod.GET)
	public String reservation(HttpServletRequest request) {
		List<Remain> checkSeat = remain.selectListIsEmpty();
		System.out.println(checkSeat.size());
		request.setAttribute("checkSeat", checkSeat);
		return "step2";
	}
	
	@RequestMapping(value = "/right", method = RequestMethod.GET)
	public String right() {
		return "right";
	}
	
	
	/*
	 * SelectedTicket�� ���õ� �¼��� �Է��ϰ�, 
	 * ���õ� �¼��� �����Ͽ� right�������� ��ȯ.
	 * right���������� ���õ� �¼����� ����Ʈ�� ���.
	 */
	@RequestMapping(value = "/get/seatData", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView setTicket(@RequestParam String seatRow, @RequestParam String seatNum, HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		SelectedTicket ticket = new SelectedTicket();
		ticket.setSeatRow(seatRow);
		ticket.setSeatNum(Integer.parseInt(seatNum));
		seat.setSelectedTicket(ticket);
		List<SelectedTicket> list = seat.getSelectedTicket("test");
		m.setViewName("right");
		m.addObject("seatRow", seatRow);
		m.addObject("seatNum", seatNum);
		m.addObject("list", list);
		request.setAttribute("seatRow", seatRow);
		request.setAttribute("seatNum", seatNum);
		request.setAttribute("list", list);
		return m;
	}
	
	/*
	 * ������ �¼��� �ٽ� Ŭ������ �� SelectedTicket���� �����ϰ�
	 * ������ �¼��� ������ ������ �¼����� ������ right�� ��ȯ.
	 */
	@RequestMapping(value = "/delete/seatData", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView removeTicketData(@RequestParam String seatRow, @RequestParam String seatNum, HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		SelectedTicket ticket = new SelectedTicket();
		ticket.setSeatRow(seatRow);
		ticket.setSeatNum(Integer.parseInt(seatNum));
		seat.deleteSelectedTicket(ticket);
		List<SelectedTicket> list = seat.getSelectedTicket("test");
		m.setViewName("right");
		m.addObject("seatRow", "");
		m.addObject("seatNum", "");
		m.addObject("list", list);
		request.setAttribute("seatRow", "");
		request.setAttribute("seatNum", "");
		request.setAttribute("list", list);
		return m;
	}

	/* ������ �� �Ǿ��� �� ó���ؾ��ϴ� �κ�
	 * selectedTicket���� userId��, performCode�� >> �̺κ��� ������.
	 * ������ �������� ������ �¼��� List�� �����´�.
	 * ������ list���� seatrow, seatnum�� �����ͼ� 
	 * dao�� ���� remainData�� �¼��� isEmpty = 0���� �����.
	 */
	@RequestMapping(value = "/set/remainData", method = RequestMethod.GET)
	@ResponseBody
	public String setIsEmpty(/* @RequestParam String userId, @RequestParam String performCode */) {
		System.out.println("controller");
		if(seat.updateSeat())
			 return "success";
		return "fail";
	}
}