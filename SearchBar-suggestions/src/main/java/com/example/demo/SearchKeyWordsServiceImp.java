package com.example.demo;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;








@Service
public class SearchKeyWordsServiceImp implements SearchKeyWordsService{
	
	
	
	  @Autowired(required=true)
	    private SearchKeyWordsRepository sRepo;

	   

		/*
		 * @Override public SearchKeyWords findById(int id) { // TODO Auto-generated
		 * method stub
		 * 
		 * SearchKeyWords searchKeyWords = sRepo.findById((long) id); if(searchKeyWords
		 * ==null) { throw new Exception("keyword Not Found"); } return new
		 * CustomSearchKeyword(searchKeyWords);
		 * 
		 * Supplier<Exception> s1 = ()->new
		 * Exception("Tenant id is not present in the database"); SearchKeyWords
		 * t1=null; t1 = sRepo.find .orElseThrow(s1);//finding teanant by id if not
		 * found throwing user defined exception
		 * 
		 * 
		 * return t1; return null; }
		 */

		@Override
		public SearchKeyWords addSearch(SearchKeyWords searchKeyWords) {
			String key = searchKeyWords.getKeyword();
			SearchKeyWords t = null;
			
			
			
			
				t = sRepo.findByKeyword(key);
				//t1 = sRepo.findById(id).orElseThrow(s1);
				if(t==null) {
					sRepo.save(searchKeyWords); // saving/adding tenant values in database
					System.out.println("saved in database");}
				else {
					try {
						updateSearch(t);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return t;
				
				
				
			
				
			//finding teanant by id if not found throwing user defined exception
			
			
		}

		@Override
		public SearchKeyWords updateSearch(SearchKeyWords t) throws Exception {
			// TODO Auto-generated method stub
			SearchKeyWords t1 = null;
			long id = t.getId();
			
			Supplier<Exception> s1 = ()->new Exception(" id is not present in the database");
					
			t1 = sRepo.findById(id).orElseThrow(s1); //finding teanant by id if not found throwing user defined exception
			t1.setKeyword(t.getKeyword());
			t1.setCount(t.getCount()+1);
		    System.out.println(t1);
			sRepo.save(t1);//saving it in database
			 System.out.println("updated in database");
			return t1;
		}

		@Override
		public SearchKeyWords addSearch(String q) {
			// TODO Auto-generated method stub
			return null;
		}

		
		

		

		
	
	 
}
