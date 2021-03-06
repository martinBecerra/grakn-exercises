package templates;

import migrator.Input;
import mjson.Json;

public class Category {
	
	static String FILE_PATH = "/book_files/categories";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json category) {
				
				return "insert $category isa Category"
						+ " has category-id " + category.at(ID_KEY).asInteger()
						+ " has category-name \"" + category.at(NAME_KEY).asString() + "\";";
			}
		};
		
	}
}
