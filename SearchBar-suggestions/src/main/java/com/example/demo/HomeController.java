package com.example.demo;
import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



//@RestController
@Controller
//@ResponseBody
public class HomeController {
	
	 
	    
	    
	
	 
	  @RequestMapping("/")
	    public String root() throws JsonProcessingException{
		  
		  ModelAndView result = new ModelAndView("editor/display");
		  ObjectMapper objectMapper = new ObjectMapper();
		  File dir = new File("directoryName");
	      String[] children = dir.list();
	      
	      if (children == null) {
	         System.out.println("does not exist or is not a directory");
	      } else {
	         for (int i = 0; i < children.length; i++) {
	            String filename = children[i];
	            System.out.println(filename);
	         }
	      }
		  result.addObject("suggestion", objectMapper.writeValueAsString(children));
	        return "index";
	    }

  
	  
}
