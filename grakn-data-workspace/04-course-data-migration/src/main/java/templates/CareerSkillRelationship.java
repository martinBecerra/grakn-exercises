package templates;

import migrator.Input;
import mjson.Json;

public class CareerSkillRelationship {

	static String FILE_PATH = "/course_files/career-skill";
	static String CAREER_ID_KEY = "career";
	static String SKILL_ID_KEY  = "skill";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$career isa Career has career-id "+ relation.at(CAREER_ID_KEY).asInteger() + ";"
						+ "$skill isa Skill has skill-id " + relation.at(SKILL_ID_KEY).asInteger()    + ";"
						+ "insert (career-profile:$career, career-skill:$skill) isa requiere-skill;";
			}
		};
	}
}
