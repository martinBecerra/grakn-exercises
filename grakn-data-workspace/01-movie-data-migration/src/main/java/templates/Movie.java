package templates;

import migrator.Input;
import mjson.Json;

public class Movie {

	static String FILE_PATH = "/movie_files/movies";
	static String ID_KEY    = "id";
	static String NAME_KEY  = "name";

	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json movie) {
				
				return "insert $movie isa Movie"
						+ " has movie-id " + movie.at(ID_KEY).asInteger()
						+ " has movie-name \"" + movie.at(NAME_KEY).asString() + "\";";
			}
		};
		
	}
}
