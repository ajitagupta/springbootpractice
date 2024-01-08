package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.LibraryException;
import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.repositories.LibraryRepository;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository; // null (see Reflection API's in Java)

    
	public void save(Library library) {
		libraryRepository.save(library);
		
	}


	public Library findLibraryById(String id) {
		Optional<Library> optLibrary =  libraryRepository.findById(id);
		if(optLibrary.isPresent()) {
		return optLibrary.get();	
		} else {
			throw new LibraryException("Library with id: " + id + " is not present");
		}
	}


	public void remove(Library library) {
		libraryRepository.delete(library);
		
	}


	public Book findBookByName(String id, String bookname) {
		Library library = findLibraryById(id);
		List<Book> books = library.getBooks();
		Book found = null;
		for (Book b : books)
		{
			if (b.getName().equals(bookname))	found = b;
		}
		return found;
	}

}
