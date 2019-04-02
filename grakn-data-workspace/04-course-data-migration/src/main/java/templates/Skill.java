package templates;

import migrator.Input;
import mjson.Json;

public class Skill {
	
	static String FILE_PATH = "/course_files/skills";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json skill) {
				
				return "insert $skill isa Skill"
						+ " has skill-id " + skill.at(ID_KEY).asInteger()
						+ " has skill-name \"" + skill.at(NAME_KEY).asString() + "\";";
			}
		};
	}

}
