package templates;

import migrator.Input;
import mjson.Json;

public class Course {

	static String FILE_PATH = "/course_files/courses";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json course) {
				
				return "insert $career isa Course"
						+ " has course-id " + course.at(ID_KEY).asInteger()
						+ " has course-name \"" + course.at(NAME_KEY).asString() + "\";";
			}
		};
	}
}
