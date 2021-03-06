package templates;

import migrator.Input;
import mjson.Json;

public class BookReferenceRelationship {
	
	static String FILE_PATH         = "/book_files/book-reference";
	static String BOOK_ID_KEY       = "book";
	static String REFERENCE_ID_KEY  = "reference";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match " 
						+ "$book isa Book has book-id "+ relation.at(BOOK_ID_KEY).asInteger() +";"
						+ "$referencedBook isa Book has book-id " + relation.at(REFERENCE_ID_KEY).asInteger() + ";"
						+ "insert (book-publication:$book, referenced-book:$referencedBook) isa reference-link;";
			}
		};
		
	}
}
