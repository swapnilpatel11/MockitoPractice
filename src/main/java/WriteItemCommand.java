import java.awt.print.Book;

public interface WriteItemCommand {

	void insertItem(Book book);

	void deleteItem(Book book);

}
