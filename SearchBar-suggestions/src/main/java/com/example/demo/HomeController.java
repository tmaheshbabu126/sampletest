package com.example.demo;
import java.io.File;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



//@RestController
@Controller
//@ResponseBody
public class HomeController {
	
	 
	    
	    
	
	 
	  @RequestMapping("/")
	    public String root(Map<String, Object> model,RedirectAttributes redirectAttributes) throws JsonProcessingException{
		  
		 // ModelAndView result = new ModelAndView("editor/display");
		  //ObjectMapper objectMapper = new ObjectMapper();
		  File dir = new File("C:\\Users\\mahes\\Desktop\\Task-CG-Asha\\dummy files");
	      String[] children = dir.list();
	      
	      if (children == null) {
	         System.out.println("does not exist or is not a directory");
	      } else {
	    	  System.out.println("in file parsing");
	         for (int i = 0; i < children.length; i++) {
	            String filename = children[i];
	            System.out.println(filename);
	         }
	      }
	      
	      model.put("number", children);
	      model.put("message", "Hello from Spring MVC");
		 // result.addObject("suggestion", objectMapper.writeValueAsString(children));
		  
	        return "index";
	    }

  
	  
}
