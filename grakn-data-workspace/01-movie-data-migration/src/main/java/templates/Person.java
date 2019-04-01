package templates;

import migrator.Input;
import mjson.Json;

public class Person {

	static String FILE_PATH = "/movie_files/people";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json person) {
				
				return "insert $person isa Person"
						+ " has person-id " + person.at(ID_KEY).asInteger()
						+ " has person-name \"" + person.at(NAME_KEY).asString() + "\";";
			}
		};
	} 
	

	
}
