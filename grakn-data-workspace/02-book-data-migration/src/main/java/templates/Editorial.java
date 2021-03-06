package templates;

import migrator.Input;
import mjson.Json;

public class Editorial {
	
	static String FILE_PATH = "/book_files/editorials";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json editorial) {
				
				return "insert $editorial isa Editorial"
						+ " has editorial-id " + editorial.at(ID_KEY).asInteger()
						+ " has editorial-name \"" + editorial.at(NAME_KEY).asString() + "\";";
			}
		};
		
	}
}
