package book.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import book.bean.Book;
import book.service.BookAppServiceImpl;

@RestController
public class BookAppRestController {
	
	@Autowired
	private BookAppServiceImpl bookAppServiceImpl;

	@RequestMapping(value="/bookapp/addBook",method=RequestMethod.POST)	
	public int addBook(@RequestBody Book book) throws SQLException{		
		return bookAppServiceImpl.addBook(book);				
	}
	
	@RequestMapping(value="/bookapp/searchBookById/{bookId}",method=RequestMethod.GET)	
	public Book searchBookById(@PathVariable(name="bookId") int bookId) throws SQLException{		
		return bookAppServiceImpl.searchBookById(bookId);				
	}
	
	@RequestMapping(value="/bookapp/updateBook",method=RequestMethod.PUT)	
	public int updateBook(@RequestBody Book book) throws SQLException{		
		return bookAppServiceImpl.updateBook(book);				
	}
	
	@RequestMapping(value="/bookapp/deleteBook/{bookId}",method=RequestMethod.DELETE)	
	public int deleteBook(@PathVariable(name="bookId") int bookId) throws SQLException{		
		return bookAppServiceImpl.deleteBook(bookId);				
	}
	
	@RequestMapping(value="/bookapp/searchAllBooks",method=RequestMethod.GET)	
	public ArrayList<Book> searchAllBooks() throws SQLException{		
		return bookAppServiceImpl.searchAllBooks();				
	}
}
