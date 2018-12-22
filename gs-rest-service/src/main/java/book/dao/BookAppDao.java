package book.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book.bean.Book;
import book.dbconfig.DatabaseConfiguration;

@Component
public class BookAppDao {
	private static Connection connection;
	private static String addBookSql="Insert into book values(?,?,?,?,?)";
	private static String updateBookSql="Update book set title=?,price=?,volume=?,publish_date=? where BookbookId=?";
	private static String deleteBookSql="delete from book where BookbookId=?";
	private static String searchBookId="select * from book where BookbookId=?";
	private static String searchAllBooks="select * from book";
	
	@Autowired
	DatabaseConfiguration dbc;			

	public int addBook(Book book) throws SQLException{
		int recCnt=0;
		Connection connection=dbc.dataSource();
		PreparedStatement psmt=connection.prepareStatement(addBookSql);
		psmt.setObject(1, book.getBookId());
		psmt.setObject(2, book.getTitle());
		psmt.setObject(3, book.getPrice());
		psmt.setObject(4, book.getVolume());
		psmt.setObject(5, new java.sql.Date(book.getPublishDate().getTime()));
		recCnt=psmt.executeUpdate();
		return recCnt;
	}
	
	public int updateBook(Book book) throws SQLException{
		int recCnt=0;
		Connection connection=dbc.dataSource();
		PreparedStatement psmt=connection.prepareStatement(updateBookSql);		
		psmt.setObject(1, book.getTitle());
		psmt.setObject(2, book.getPrice());
		psmt.setObject(3, book.getVolume());
		psmt.setObject(4, new java.sql.Date(book.getPublishDate().getTime()));
		psmt.setObject(5, book.getBookId());
		recCnt=psmt.executeUpdate();
		return recCnt;
	}
	
	public int deleteBook(int bookId) throws SQLException{
		int recCnt=0;
		Connection connection=dbc.dataSource();
		PreparedStatement psmt=connection.prepareStatement(deleteBookSql);		
		psmt.setObject(1, bookId);
		recCnt=psmt.executeUpdate();
		return recCnt;
	}
	
	public Book getBookById(int bookId) throws SQLException{
		ResultSet rs;
		Book book = null;
		Connection connection=dbc.dataSource();
		PreparedStatement psmt=connection.prepareStatement(searchBookId);		
		psmt.setObject(1, bookId);
		rs=psmt.executeQuery();
		while(rs.next()){
			book=new Book();
			book.setBookId((long) rs.getLong(1));
			book.setTitle((String) rs.getObject(2));
			book.setPrice((double) rs.getDouble(3));
			book.setVolume((int) rs.getInt(4));
			book.setPublishDate((Date) rs.getDate(5));
		}
		return book;
	}
	
	public ArrayList<Book>getAllBooks() throws SQLException{
		ArrayList<Book> books=new ArrayList<Book>();
		ResultSet rs;	
		Book book = null;
		Connection connection=dbc.dataSource();
		PreparedStatement psmt=connection.prepareStatement(searchAllBooks);				
		rs=psmt.executeQuery();
		while(rs.next()){
			book=new Book();
			book.setBookId((long) rs.getLong(1));
			book.setTitle((String) rs.getObject(2));
			book.setPrice((double) rs.getDouble(3));
			book.setVolume((int) rs.getInt(4));
			book.setPublishDate((Date) rs.getDate(5));
			books.add(book);
		}
		
		return books;
	}	
}
