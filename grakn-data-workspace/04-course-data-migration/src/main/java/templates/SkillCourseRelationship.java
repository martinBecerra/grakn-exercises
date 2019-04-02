package templates;

import migrator.Input;
import mjson.Json;

public class SkillCourseRelationship {

	static String FILE_PATH = "/course_files/skill-course";
	static String COURSE_ID_KEY = "course";
	static String SKILL_ID_KEY  = "skill";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$course isa Course has course-id "+ relation.at(COURSE_ID_KEY).asInteger() + ";"
						+ "$skill isa Skill has skill-id " + relation.at(SKILL_ID_KEY).asInteger() +";"
						+ "insert (developed-skill:$skill, skill-course:$course) isa develop-skill;";
			}
		};
	}
}
