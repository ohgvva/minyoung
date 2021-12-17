package com.project.todaygym;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.todaygym.service.OrderService;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private OrderService oServ;

	private ModelAndView mv;

	//__________ 결제 페이지
	@GetMapping("orderHome")
	public String cOrderMove() {
		logger.info("cOrderMove()");

		return "order/orderHome";
	} // cOrderMove end

	//__________ 결제하기 실행
	@PostMapping("oPayAct")
	public ModelAndView oPayAct() {
		logger.info("oPayAct()");

		mv = oServ.payAct();

		return mv;
	} // oPayAct end

	//__________ 결제완료 페이지
	@GetMapping("orderComplete")
	public String oOrderCompMove() {
		logger.info("oOrderCompMove()");

		return "order/orderComplte";
	} // cOrderMove end

} // class end