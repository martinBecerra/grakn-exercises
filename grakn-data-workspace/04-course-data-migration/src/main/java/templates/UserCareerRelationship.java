package templates;

import migrator.Input;
import mjson.Json;

public class UserCareerRelationship {

	static String FILE_PATH 	 = "/course_files/user-career";
	static String USER_ID_KEY    = "user";
	static String CAREER_ID_KEY  = "career";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$user   isa Person has person-id " + relation.at(USER_ID_KEY).asInteger()   + ";"
						+ "$career isa Career has career-id " + relation.at(CAREER_ID_KEY).asInteger() + ";"
						+ "insert (user:$user, chosen-career:$career) isa choose-career;";
			}
		};
	}
}
