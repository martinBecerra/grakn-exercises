package templates;

import migrator.Input;
import mjson.Json;

public class ActivityLogRelationship {

	static String FILE_PATH = "/city_files/activity-logs";
	
	static String USER_ID      = "user";
	static String ACTIVITY_ID  = "activity";
	static String PLACE_ID_KEY = "place";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
						
				return "match "
						+ "$place isa Place  has place-id "  + relation.at(PLACE_ID_KEY).asInteger() + ";"
						+ "$user  isa Person has person-id " + relation.at(USER_ID).asInteger() + ";"
						+ "$activity isa Activity has activity-id " + relation.at(ACTIVITY_ID).asInteger() + ";"
						+ "insert (logged-user:$user,logged-activity:$activity,logged-place:$place) isa activity-log;";
			}
		};
	}
	
}
