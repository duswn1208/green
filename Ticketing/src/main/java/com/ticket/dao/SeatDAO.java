package com.ticket.dao;

import java.util.*;
import org.mybatis.spring.SqlSessionTemplate;

import com.ticket.dto.Remain;
import com.ticket.dto.SelectedTicket;


public class SeatDAO {

	private SqlSessionTemplate sessionTemplate;

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	//�¼��� �������� �� �¼��� ���õǾ��ٰ� insert�ϴ� �ڵ�
	public void setSelectedTicket(SelectedTicket ticket) {
		sessionTemplate.selectOne("ticketMapper.insertSelectedTicket", ticket);
	}
	
	//���õ� �¼��� �ٽ� �������� �� delete�ϴ� �ڵ�
	public void deleteSelectedTicket(SelectedTicket ticket) {
		sessionTemplate.selectOne("ticketMapper.deleteSelectedTicket", ticket);
	}
	
	//���õ� �¼��� ����Ʈ�� ��ȯ�ϴ� �ڵ�
	public List<SelectedTicket> getSelectedTicket(String userId) {
		return sessionTemplate.selectList("ticketMapper.selectSelectedTicket", userId);
	}
	
	/*
	 * remainDAO�� ��������. seat���� �������ε� ��ġ�� ��𿡼� ���� �����.
	 * �������� �����Ϸ����� �� remainData���� �� �¼��� isEmpty�� 0���� �����.
	 * isEmpty = 1 >> ����ִ� �¼�
	 * isEmpty = 0 >> ������� ���� �¼�
	 */
	public boolean updateSeat() {
		try {
			//�¼������� �����ͼ� ������� ������ update�� �� �ְ� �ٲ�ߵ�.
			System.out.println("update start");
			sessionTemplate.selectOne("mapper.updateSeat");
			System.out.println("update end");
		} catch(Exception e) {
			System.out.println("update fail");
			return false;
		}
		return true;
	}
	
	public boolean checkIsEmpty(Remain remain) throws InterruptedException {
		System.out.print("result: "+remain.getSeatRow()+", "+remain.getSeatNum()+"\t");
		int check = sessionTemplate.selectOne("mapper.selectIsEmpty", remain);
		if(check == 1)
			return true;
		return false;
	}
}
