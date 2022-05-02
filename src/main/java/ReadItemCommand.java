import java.awt.print.Book;
import java.util.List;

public interface ReadItemCommand {

	List<Book> readAll();

	Book getItem(String iSBN);

	

	
	
}
