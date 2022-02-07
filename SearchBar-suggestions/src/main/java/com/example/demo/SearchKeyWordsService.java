package com.example.demo;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface SearchKeyWordsService {

	//public SearchKeyWords findById(long id);
	public SearchKeyWords addSearch(SearchKeyWords searchKeyWords) ;
	public SearchKeyWords updateSearch(SearchKeyWords searchKeyWords) throws Exception;
	SearchKeyWords addSearch(String q);


}
