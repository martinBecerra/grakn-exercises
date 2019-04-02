package templates;

import migrator.Input;
import mjson.Json;

public class Place {

	static String FILE_PATH     = "/city_files/places";
	static String ID_KEY        = "id";
	static String NAME_KEY      = "name";
	static String LATITUDE_KEY  = "latitude";
	static String LONGITUDE_KEY = "longitude";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json place) {
				
				return "insert $place isa Place"
						+ " has place-id " + place.at(ID_KEY).asInteger()
						+ " has place-name \"" + place.at(NAME_KEY).asString() + "\"" 
						+ " has place-latitude "  + place.at(LATITUDE_KEY).asDouble()
						+ " has place-longitude " + place.at(LONGITUDE_KEY).asDouble() + ";";
			}
		};
	}
}
