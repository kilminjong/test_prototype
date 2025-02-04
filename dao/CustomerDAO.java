package spring.pj.nardrak_spring_mvc.dao;

import java.util.Map;

import spring.pj.nardrak_spring_mvc.dto.CustomerDTO;

public interface CustomerDAO {

	// ID 중복확인 처리
	public int useridCheck(String cs_id);
	
	// 회원가입 처리
	public int insertCustomer(CustomerDTO dto); 
	
}