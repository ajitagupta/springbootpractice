package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
	
	
	List<Book> findByName(String bookName); // in-built method in JpaRepository	

	List<Book> findByPublishYear(Integer year);  // in-built method in JpaRepository
		
	Book findByAuthorAndName(String author, String name); // in-built method in JpaRepository
	

	@Query("select b from Book b where b.publishYear = :year") // JPQL
	List<Book> getByPublishYear(@Param("year") Integer year);
	
	@Query(value =  "select * from Book where publishYear = :year", nativeQuery = true) // normal native query of H2 database
	List<Book> getByPublishYear2(@Param("year") Integer year);
	
	// for complex queries we use getX()
	// for Spring format queries we use findX()

}
