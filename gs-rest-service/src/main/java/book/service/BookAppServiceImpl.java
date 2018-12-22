package book.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book.bean.Book;
import book.dao.BookAppDao;

@Component
public class BookAppServiceImpl {
	
	@Autowired
	private BookAppDao bookDao;
	
	public int addBook(Book book) throws SQLException{		
		return bookDao.addBook(book);
	}
	
	public int updateBook(Book book) throws SQLException{
		return bookDao.updateBook(book);
	}
	
	public int deleteBook(int bookId) throws SQLException{
		return bookDao.deleteBook(bookId);
	}
	
	public Book searchBookById(int bookId) throws SQLException{
		return bookDao.getBookById(bookId);
	}
	
	public ArrayList<Book> searchAllBooks() throws SQLException{
		return bookDao.getAllBooks();
	}	
}
