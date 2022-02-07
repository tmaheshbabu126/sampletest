package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;







@Repository
public interface SearchKeyWordsRepository extends JpaRepository<SearchKeyWords,Long> {

	SearchKeyWords findByKeyword(String q);

	
		
		
}
