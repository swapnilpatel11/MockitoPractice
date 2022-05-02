import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CatalogueTest {
	Catalogue cat;
	
	@Mock
	ReadItemCommand mockRic;
	
	@Mock
	WriteItemCommand mockWic;
	
	@Mock
	List<Book> mockList;
	
	@Mock
	Book mockBook;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
		cat = new Catalogue(mockRic,mockWic);
	}
	
	@Test
	public void getAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue(){
		//Arrange
		
		//Act
		List<Book> books = cat.getAllBooks();
		//Assert
		assertEquals(0,books.size());
	}
	
	@Test
	public void getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled(){
		//Arrange
		
		//Act
		cat.getAllBooks();
		//Assert
		verify(mockRic, times(1)).readAll();
	}
	
	@Test
	public void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled(){
		//Arrange
		//when(mockRic.readAll()).thenReturn(mockList);
		when(mockRic.readAll()).thenReturn(mockList);
		//Act
		cat.getAllBooks();
		//Assert
		assertEquals(mockList,cat.getAllBooks());
		
	}
	
	@Test
	void test4() {
		//Arrange
		
		//Act
		cat.addBook(mockBook);
		//Assert
		verify(mockWic, times(1)).insertItem(mockBook);
	}
	
	@Test
	void test5() {
		//Arrange
		List<Book> books = new ArrayList<>();
		books.add(mockBook);
		books.add(mockBook);
		books.add(mockBook);
		//Act
		cat.addBook(books);
		//Assert
		verify(mockWic, times(3)).insertItem(mockBook);
	}
	
	@Test
	void test6() {
		//Arrange
		String ISBN = "1525";
		when(mockRic.getItem(ISBN)).thenReturn(mockBook);
		//Act
		Book actual = cat.getBook(ISBN);
		//Assert
		assertEquals(mockBook,actual);
	}
	
	@Test
	void test7() {
		//Arrange
		
		//Act
		cat.deleteBook(mockBook);
		//Assert
		verify(mockWic,times(1)).deleteItem(mockBook);
	}
	
	@Test
	void test8() {
		//Arrange
		List<Book> books = new ArrayList<>();
		books.add(mockBook);
		books.add(mockBook);
		when(mockRic.readAll()).thenReturn(books);
		//Act
		cat.deleteAllBooks();
		//Assert
		verify(mockWic,times(2)).deleteItem(mockBook);
		
	}
	




}
