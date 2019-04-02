package templates;

import migrator.Input;
import mjson.Json;

public class PlaceCityRelationship {
	
	static String FILE_PATH = "/city_files/place-city";
	static String PLACE_ID_KEY = "place";
	static String CITY_ID_KEY  = "city";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
					
				return "match "
						+ "$place isa Place has place-id " + relation.at(PLACE_ID_KEY) + ";"
						+ "$city  isa City  has city-id "  + relation.at(CITY_ID_KEY)  + ";"
						+ "insert (city-place:$place, place-city:$city) isa place-is-in-city;";
			}
		};
	}
}
