package templates;

import migrator.Input;
import mjson.Json;

public class BookEditorialRelationship {

	static String FILE_PATH         = "/book_files/book-editorial";
	static String BOOK_ID_KEY       = "book";
	static String EDITORIAL_ID_KEY  = "editorial";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match " 
						+ "$book isa Book has book-id "+ relation.at(BOOK_ID_KEY).asInteger() +";"
						+ "$editorial isa Editorial has editorial-id " + relation.at(EDITORIAL_ID_KEY).asInteger() + ";"
						+ "insert (released-book:$book,book-publisher:$editorial) isa published-by;";
			}
		};
		
	}
}
