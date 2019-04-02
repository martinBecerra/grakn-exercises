package templates;

import migrator.Input;
import mjson.Json;

public class Activity {

	static String FILE_PATH = "/city_files/activities";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json activity) {
				
				return "insert $activity isa Activity"
						+ " has activity-id " + activity.at(ID_KEY).asInteger()
						+ " has activity-name \"" + activity.at(NAME_KEY).asString() + "\";";
			}
		};
	}
}
