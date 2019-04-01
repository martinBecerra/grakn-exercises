package templates;

import migrator.Input;
import mjson.Json;

public class BookKeywordRelationship {
	
	static String FILE_PATH         = "/book_files/book-keyword";
	static String BOOK_ID_KEY       = "book";
	static String KEYWORD_ID_KEY    = "keyword";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match " 
						+ "$book isa Book has book-id "+ relation.at(BOOK_ID_KEY).asInteger() +";"
						+ "$keyword isa Keyword has keyword-id " + relation.at(KEYWORD_ID_KEY).asInteger() + ";"
						+ "insert (book-keyword:$keyword, linked-book:$book) isa book-keyword-link;";
			}
		};
		
	}
}
