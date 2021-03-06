package templates;

import migrator.Input;
import mjson.Json;

public class DiseaseSymptomRelationship {

	static String FILE_PATH  = "/patient_files/disease-symptom";
	static String DISEASE_ID_KEY  = "disease";
	static String SYMPTOM_ID_KEY  = "symptom";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$disease isa Disease has disease-id " + relation.at(DISEASE_ID_KEY).asInteger() + ";" 
						+ "$symptom isa Symptom has symptom-id " + relation.at(SYMPTOM_ID_KEY).asInteger() + ";"
						+ "insert (described-disease:$disease, disease-symptom:$symptom) isa disease-includes;";
				
			}
		};
		
	} 
}
