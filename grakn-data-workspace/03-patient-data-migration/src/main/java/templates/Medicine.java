package templates;

import migrator.Input;
import mjson.Json;

public class Medicine {

	static String FILE_PATH = "/patient_files/medicines";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json medicine) {
				
				return "insert $medicine isa Medicine"
						+ " has medicine-id " + medicine.at(ID_KEY).asInteger() + 
						  " has medicine-name \"" + medicine.at(NAME_KEY).asString() + "\";";
			}
		};
		
	} 
}
