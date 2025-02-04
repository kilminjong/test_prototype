package spring.pj.nardrak_spring_mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.pj.nardrak_spring_mvc.service.CustomerServiceImpl;

@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired // 객채생성의 의미
	private CustomerServiceImpl service;

	// 첫페이지
	@RequestMapping("/main.do")
	public String main() {
		logger.info("<<< url => /main.do >>>");

		return "common/main";
	}

	// [개인정보 처리동의]
	@RequestMapping("/joinAgreement.do")
	public String joinAgreement() {
		logger.info("<<< url => /joinAgreement.do >>>");

		return "customer/join/joinAgreement";
	}
	
	// [회원가입]
	@RequestMapping("/join.do")
	public String join() {
		logger.info("<<< url => /join.do >>>");

		return "customer/join/join";
	}
	
	// [id 중복확인]
	@RequestMapping("/idConfirmAction.do")
	public String idConfirmAction(HttpServletRequest request,HttpServletResponse response ,Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /idConfirmAction.do >>>");

		service.inConfirmAction(request,response, model);

		return "customer/join/idConfirmAction";
	}

	// [회원가입 처리]
	// 서비스 호출, joinAction.jsp
	@RequestMapping("/joinAction.do")
	public String joinAction(HttpServletRequest request,HttpServletResponse response , Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /joinAction.do >>>");

		service.signUpAction(request, response ,model);

		return "customer/join/joinAction";
	}

	// [로그인]
	// 로그인 화면
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /login.do >>>");

		return "customer/login/login";
	}

}
