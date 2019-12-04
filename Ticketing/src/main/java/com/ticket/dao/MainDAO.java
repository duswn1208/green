package com.ticket.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.ticket.dto.CompanyMainDTO;
import com.ticket.dto.MainListDTO;
import com.ticket.dto.UserMainDTO;

public class MainDAO {

	private SqlSessionTemplate sessionTemplate;

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) throws Exception {
		this.sessionTemplate = sessionTemplate;

	}

	public int getMaxNum() {

		int maxNum = 0;
		maxNum = sessionTemplate.selectOne("mainMapper.maxNum");
		return maxNum;

	}

	public int getMaxCompanyNum() {

		int maxNum = 0;
		maxNum = sessionTemplate.selectOne("mainMapper.maxCompanyNum");
		return maxNum;

	}

	public void insertUserSignUpData(UserMainDTO userMainDTO) { // �Ϲ� ����� ȸ������

		sessionTemplate.insert("mainMapper.insertUserSignUpData", userMainDTO);

	}

	public void insertCompanySignUpData(CompanyMainDTO companyMainDTO) { // ��� ȸ�� ȸ������

		sessionTemplate.insert("mainMapper.insertCompanySignUpData", companyMainDTO);

	}

	public UserMainDTO myPageReadData(String userId) { // �Ϲ�ȸ�� ������ �о����

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		UserMainDTO userMainDTO = sessionTemplate.selectOne("mainMapper.myPageReadData", map);

		return userMainDTO;

	}

	public CompanyMainDTO myPageCompanyReadData(String companyId) { // ���ȸ�� ������ �о����

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		CompanyMainDTO companyMainDTO = sessionTemplate.selectOne("mainMapper.myPageCompanyReadData", map);

		return companyMainDTO;

	}

	public String idCheck(String userId) { // �Ϲ�ȸ�� ���̵� üũ(�ߺ�)

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		String idCheck = sessionTemplate.selectOne("mainMapper.idCheck", map);

		return idCheck;

	}

	public String companyIdCheck(String companyId) { // ���ȸ�� ���̵� üũ(�ߺ�)

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		String companyIdCheck = sessionTemplate.selectOne("mainMapper.companyIdCheck", map);

		return companyIdCheck;

	}

	
	  public List<MainListDTO> getList() {
	  
		  Map<String, Object> params = new HashMap<String, Object>();
	  
	  
		/*
		 * params.put("start", start); params.put("end", end); params.put("searchKey",
		 * searchKey); params.put("searchValue", searchValue);
		 */
	  
	  
		  List<MainListDTO> lists = sessionTemplate.selectList("mainMapper.getLists");
	  
		  return lists;
	  
	  }
	 

	// ��ü �����ͼ� ���ϱ�
	public int getDataCount(String searchKey, String searchValue) {

		HashMap<String, Object> params = new HashMap<String, Object>();

		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);

		int result = sessionTemplate.selectOne("mainMapper.getDataCount", params);

		return result;

	}

	public UserMainDTO updateUserData(UserMainDTO userMainDTO) {
		
		sessionTemplate.update("mainMapper.updateUserData",userMainDTO);
		return userMainDTO;
		
	}

}


























































































































































































