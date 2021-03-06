package templates;

import migrator.Input;
import mjson.Json;

public class Actor {

	static String FILE_PATH = "/movie_files/actors";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json actor) {
				
				return "insert $actor isa Actor"
						+ " has actor-id " + actor.at(ID_KEY).asInteger()
						+ " has actor-name \"" + actor.at(NAME_KEY).asString() + "\";";
			}
		};
		
	}
}
