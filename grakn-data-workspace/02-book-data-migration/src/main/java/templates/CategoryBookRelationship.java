package templates;

import migrator.Input;
import mjson.Json;

public class CategoryBookRelationship {

	static String FILE_PATH         = "/book_files/category-book";
	static String BOOK_ID_KEY       = "book";
	static String CATEGORY_ID_KEY   = "category";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match " 
						+ "$book isa Book has book-id "+ relation.at(BOOK_ID_KEY).asInteger() +";"
						+ "$category isa Category has category-id " + relation.at(CATEGORY_ID_KEY).asInteger() + ";"
						+ "insert (book-category:$category, classified-book:$book) isa is-category-of;";
			}
		};
		
	}
}
