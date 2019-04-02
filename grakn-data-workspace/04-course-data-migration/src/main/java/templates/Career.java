package templates;

import migrator.Input;
import mjson.Json;

public class Career {

	static String FILE_PATH = "/course_files/careers";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json career) {
				
				return "insert $career isa Career"
						+ " has career-id " + career.at(ID_KEY).asInteger()
						+ " has career-name \"" + career.at(NAME_KEY).asString() + "\";";
			}
		};
	}
}
