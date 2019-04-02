package templates;

import migrator.Input;
import mjson.Json;

public class City {

	static String FILE_PATH = "/city_files/cities";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json activity) {
				
				return "insert $city isa City"
						+ " has city-id " + activity.at(ID_KEY).asInteger()
						+ " has city-name \"" + activity.at(NAME_KEY).asString() + "\";";
			}
		};
	}
}
