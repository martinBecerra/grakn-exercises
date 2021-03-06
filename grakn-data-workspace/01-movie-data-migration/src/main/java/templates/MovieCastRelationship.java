package templates;

import migrator.Input;
import mjson.Json;

public class MovieCastRelationship {

	static String FILE_PATH    = "/movie_files/movie-cast";
	static String MOVIE_ID_KEY = "movie";
	static String CAST_ID_KEY  = "actor";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$movie isa Movie has movie-id " + relation.at(MOVIE_ID_KEY).asInteger() + ";"
						+ "$actor isa Actor has actor-id " + relation.at(CAST_ID_KEY).asInteger()  + ";"
						+ "insert (cast: $actor, film: $movie) isa is-cast-of-movie;";
			}
		};
	}
	
}
