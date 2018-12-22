package book.test.controller;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.xmlunit.input.WhitespaceNormalizedSource;

import book.controller.BookAppRestController;
import book.service.BookAppServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookAppRestControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	BookAppRestController bookAppRestController;
	
	@Mock
	BookAppServiceImpl bookAppServiceImpl;
	
	@Before
	public void setUp(){
		mockMvc=MockMvcBuilders.standaloneSetup(bookAppRestController).build();
	}
	
	@Test
	public void testSearchAllBooks() throws Exception{
		Mockito.when(bookAppServiceImpl.searchAllBooks())
		.thenReturn(new ArrayList<book.bean.Book>());
		mockMvc.perform(
				MockMvcRequestBuilders.get("/bookapp/searchAllBooks"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(bookAppServiceImpl).searchAllBooks();
	}
	
	@Test
	public void testSearchBookById() throws Exception{
		Mockito.when(bookAppServiceImpl.searchBookById(101))
		.thenReturn(new book.bean.Book(101,"Test Book",700,1,new Date()));
		mockMvc.perform(
				MockMvcRequestBuilders.get("/bookapp/searchBookById/101"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.*", org.hamcrest.Matchers.hasSize(5)));
		Mockito.verify(bookAppServiceImpl).searchBookById(101);
	}
	
	@Test
	public void testAddBook() throws Exception{
		String json="{\"bookId\":101,\"title\":\"Drama\",\"price\":840,\"volume\":1,\"publishDate\":\"01-04-2018\"}";
		Mockito.when(bookAppServiceImpl.addBook(new book.bean.Book()))
		.thenReturn(1);
		mockMvc.perform(MockMvcRequestBuilders.post("/bookapp/addBook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testUpdateBook() throws Exception{
		String json="{\"bookId\":101,\"title\":\"Drama\",\"price\":840,\"volume\":1,\"publishDate\":\"01-04-2018\"}";
		Mockito.when(bookAppServiceImpl.deleteBook(101))
		.thenReturn(1);
		mockMvc.perform(MockMvcRequestBuilders.put("/bookapp/updateBook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testDeleteBook() throws Exception{
		Mockito.when(bookAppServiceImpl.deleteBook(101))
		.thenReturn(101);
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/bookapp/deleteBook/101"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		Mockito.verify(bookAppServiceImpl).deleteBook(101);
	}
	
}
