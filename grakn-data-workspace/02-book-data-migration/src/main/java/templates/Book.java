package templates;

import migrator.Input;
import mjson.Json;

public class Book {

	static String FILE_PATH   = "/book_files/books";
	static String ID_KEY      = "id";
	static String NAME_KEY    = "name";
	static String RELEASE_KEY = "release";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json book) {
				
				return "insert $book isa Book"
						+ " has book-id " + book.at(ID_KEY).asInteger()
						+ " has book-name \""  + book.at(NAME_KEY).asString() + "\""
						+ " has release-year " + book.at(RELEASE_KEY).asInteger() + ";";
			}
		};
		
	}
}
