package templates;

import migrator.Input;
import mjson.Json;

public class Genre {

	static String FILE_PATH = "/movie_files/genres";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json genre) {
				
				return "insert $genre isa Genre"
						+ " has genre-id " + genre.at(ID_KEY).asInteger()
						+ " has genre-name \"" + genre.at(NAME_KEY).asString() + "\";";
			}
		};
	} 
}
