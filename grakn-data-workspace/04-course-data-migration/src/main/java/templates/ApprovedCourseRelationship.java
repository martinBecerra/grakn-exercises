package templates;

import migrator.Input;
import mjson.Json;

public class ApprovedCourseRelationship {
	
	static String FILE_PATH     = "/course_files/approved-course";
	static String USER_ID_KEY   = "user";
	static String COURSE_ID_KEY = "course";
	static String MARK_KEY		= "mark";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
					
				return "match "
						+ "$user isa Person has person-id "+ relation.at(USER_ID_KEY).asInteger() + ";"
						+ "$course isa Course has course-id " + relation.at(COURSE_ID_KEY).asInteger() +";"
						+ "insert $relation(user:$user, approved-course:$course) isa approves-courses;"
						+ "$relation has final-mark "+ relation.at(MARK_KEY).asInteger() +";";
			}
		};
	}
}
