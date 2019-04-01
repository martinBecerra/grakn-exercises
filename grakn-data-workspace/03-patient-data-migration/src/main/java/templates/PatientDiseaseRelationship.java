package templates;

import migrator.Input;
import mjson.Json;

public class PatientDiseaseRelationship {

	static String FILE_PATH  = "/patient_files/patient-disease";
	static String PATIENT_ID_KEY  = "patient";
	static String DISEASE_ID_KEY  = "disease";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$person isa Person has person-id " + relation.at(PATIENT_ID_KEY).asInteger() + ";" 
						+ "$disease isa Disease has disease-id " + relation.at(DISEASE_ID_KEY).asInteger() + ";"
						+ "insert (patient:$person, suffered-disease:$disease) isa patient-diagnosis;";
			}
		};
		
	} 
}


