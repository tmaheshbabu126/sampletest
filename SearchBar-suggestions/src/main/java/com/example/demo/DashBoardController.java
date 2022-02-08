package com.example.demo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller

public class DashBoardController {
	
	@Autowired
	SearchKeyWordsServiceImp si;
	
	@RequestMapping("/dashBoard")
	public  String dashController(Map<String, Object> model) {
		
		List<SearchKeyWords> searchesData = si.getAllSearch();
		
		 model.put("searchesData", searchesData);
		    model.put("count", "Hello from Spring MVC");
	        return "dashBoard";
	    
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public String
	thymeleafView( @RequestParam String q ,Map<String, Object> model,RedirectAttributes redirectAttributes, HttpServletResponse httpResponse) throws IOException {
		/*
		 * model.put("number", 1234); model.put("message", "Hello from Spring MVC");
		 */
	   // return new ModelAndView("thymeleaf/index");
	    System.out.println(q);
	    
	    	
	    	
			SearchKeyWords s = new SearchKeyWords((long) 0,q,0);
	    	
	    	SearchKeyWords te1= si.addSearch(s);//sending the model obtained from client to service to process, for adding tenant
			
			ResponseEntity<SearchKeyWords> rt=new ResponseEntity<SearchKeyWords>(te1,HttpStatus.OK); //response to client
			//return rt;
			
			httpResponse.sendRedirect("/dashBoard");
	    
	   return "redirect:/dashBoard";
	}
	

	
	

}
