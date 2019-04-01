package templates;

import migrator.Input;
import mjson.Json;

public class Topic {

	static String FILE_PATH = "/book_files/topics";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json topic) {
				
				return "insert $topic isa Topic"
						+ " has topic-id " + topic.at(ID_KEY).asInteger()
						+ " has topic-name \"" + topic.at(NAME_KEY).asString() + "\";";
			}
		};
	}
}
