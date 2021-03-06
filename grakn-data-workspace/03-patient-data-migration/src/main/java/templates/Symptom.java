package templates;

import migrator.Input;
import mjson.Json;

public class Symptom {
	
	static String FILE_PATH = "/patient_files/symptoms";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";

	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json sympton) {
				
				return "insert $symptom isa Symptom"
						+ " has symptom-id " + sympton.at(ID_KEY).asInteger()
						+ " has symptom-name \"" + sympton.at(NAME_KEY).asString() + "\";";
			}
		};
	} 
}
