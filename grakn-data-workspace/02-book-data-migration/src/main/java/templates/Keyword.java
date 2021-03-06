package templates;

import migrator.Input;
import mjson.Json;

public class Keyword {
	
	static String FILE_PATH = "/book_files/keywords";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json keyword) {
				
				return "insert $keyword isa Keyword"
						+ " has keyword-id " + keyword.at(ID_KEY).asInteger()
						+ " has keyword-name \"" + keyword.at(NAME_KEY).asString() + "\";";
			}
		};
	}
}
