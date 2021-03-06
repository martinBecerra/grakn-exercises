package templates;

import migrator.Input;
import mjson.Json;

public class Disease {

	static String FILE_PATH = "/patient_files/diseases";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json disease) {
				
				return "insert $disease isa Disease"
						+ " has disease-id " + disease.at(ID_KEY).asInteger()
						+ " has disease-name \"" + disease.at(NAME_KEY).asString() + "\";";
			}
		};
		
	} 
}
