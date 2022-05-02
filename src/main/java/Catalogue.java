import java.awt.print.Book;
import java.util.List;

public class Catalogue {
	
	private ReadItemCommand ric;
	private WriteItemCommand wic;
	
	
	public Catalogue(ReadItemCommand ric, WriteItemCommand wic) {
		this.ric = ric;
		this.wic = wic;
	}
		
	public List<Book> getAllBooks() {
		return ric.readAll();
		}
	public void addBook(Book book) {
		wic.insertItem(book);
	}

	public void addBook(List<Book> books) {
		for(Book book : books) {
			addBook(book);
		}
	}

	public Book getBook(String iSBN) {
		return ric.getItem(iSBN);
	}

	public void deleteBook(Book book) {
		wic.deleteItem(book);
	}

	public void deleteAllBooks() {
		for(Book book : ric.readAll()) {
			wic.deleteItem(book);	
		}
		
		
	}
	
	
	
	
	
	

}
