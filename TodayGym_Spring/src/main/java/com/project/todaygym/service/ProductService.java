package com.project.todaygym.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.todaygym.dao.MemberDao;
import com.project.todaygym.dao.ProductDao;
import com.project.todaygym.dto.CartDto;
import com.project.todaygym.dto.MemberDto;
import com.project.todaygym.dto.MyCartDto;
import com.project.todaygym.dto.OptionDto;
import com.project.todaygym.dto.ProductDto;

@Service
public class ProductService {
	@Autowired
	private ProductDao pDao;
	private ModelAndView mv;
	@Autowired
	private HttpSession session;
	@Autowired
	private MemberDao mDao;
	
	
	
	//1. 구매메인페이지
	public ModelAndView getProductList() {
		mv = new ModelAndView();
		List<ProductDto> pList = pDao.getProductList();
		mv.addObject("pList", pList);
		mv.setViewName("buy/buyHome");
		return mv;
	}
	//2. 구매상세 페이지 넘기기
	public ModelAndView getProductDetail(String p_code) {
		mv = new ModelAndView();
		
		ProductDto detailInfo = pDao.getProductSelect(p_code);

		session.setAttribute("pCode", p_code);
		
		List<OptionDto> oList = pDao.getOptionSelect(p_code);
		mv.addObject("dInfo", detailInfo);
		mv.addObject("oList", oList);
		mv.setViewName("buy/bHealthDetail");
		
		return mv;
	}
	//3. 장바구니 페이지
	public ModelAndView getMyCart() {
		mv = new ModelAndView();
		
		MemberDto member = (MemberDto) session.getAttribute("mb");
		String getId = member.getM_id();
		
		List<MyCartDto> myCart = pDao.getMyCart(getId);
		mv.addObject("mycart", myCart);
		mv.setViewName("cart/cartHome");
		return mv;
	}
	
	//4. 장바구니 저장하기
	public String saveMyCart(CartDto myCart, RedirectAttributes rttr) {
		String view = null;
		String alert = null;
		
		MemberDto member = (MemberDto) session.getAttribute("mb");
		String getCode = (String) session.getAttribute("pCode");
		String getId = member.getM_id();
		
		myCart.setM_id(getId);
		myCart.setP_code(getCode);
		
		try {
			pDao.myCartInsert(myCart);
			view = "redirect:myCart";
			alert = "장바구니에 담았습니다";
		}catch (Exception e) {
			e.printStackTrace();
			view = "redirect:detail";
			alert = "장바구니에 담을 수 없습니다. 관리자에게 문의하세요.";
		}
		rttr.addFlashAttribute("alert", alert);
		
		return view;
	}
}























