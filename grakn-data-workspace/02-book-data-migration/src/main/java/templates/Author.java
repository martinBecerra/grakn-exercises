package templates;

import migrator.Input;
import mjson.Json;

public class Author {

	static String FILE_PATH = "/book_files/authors";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json author) {
				
				return "insert $author isa Author"
						+ " has author-id " + author.at(ID_KEY).asInteger()
						+ " has author-name \"" + author.at(NAME_KEY).asString() + "\";";
			}
		};
		
	}
}
