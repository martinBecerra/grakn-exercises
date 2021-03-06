package templates;

import migrator.Input;
import mjson.Json;

public class BookAuthorRelationship {

	static String FILE_PATH = "/book_files/book-author";
	static String BOOK_ID_KEY    = "book";
	static String AUTHOR_ID_KEY  = "author";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match " 
						+ "$book isa Book has book-id "+ relation.at(BOOK_ID_KEY).asInteger() +";"
						+ "$author isa Author has author-id " + relation.at(AUTHOR_ID_KEY).asInteger() + ";"
						+ "insert (book-author:$author,authored-book:$book) isa is-author;";
			}
		};
		
	}
}
