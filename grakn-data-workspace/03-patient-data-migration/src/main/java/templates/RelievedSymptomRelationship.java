package templates;

import migrator.Input;
import mjson.Json;

public class RelievedSymptomRelationship {

	static String FILE_PATH  = "/patient_files/relieved-symptom";
	static String MEDICINE_ID_KEY  = "medicine";
	static String SYMPTOM_ID_KEY  = "symptom";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relationship) {
				
				return "match "
						+ "$medicine isa Medicine has medicine-id " + relationship.at(MEDICINE_ID_KEY).asInteger() + ";" 
						+ "$symptom isa Symptom has symptom-id " + relationship.at(SYMPTOM_ID_KEY).asInteger() + ";"
						+ "insert (prescribed-medicine:$medicine,relieved-symptom:$symptom) isa relieve-symptom;";
				
			}
		};
		
	} 
}
