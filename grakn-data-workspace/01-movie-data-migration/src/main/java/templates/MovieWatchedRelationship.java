package templates;

import migrator.Input;
import mjson.Json;

public class MovieWatchedRelationship {

	static String FILE_PATH     = "/movie_files/movie-watched";
	static String USER_ID_KEY   = "user";
	static String MOVIE_ID_KEY  = "movie";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$user isa Person has person-id "+ relation.at(USER_ID_KEY).asInteger() +  ";"
						+ "$movie isa Movie has movie-id " + relation.at(MOVIE_ID_KEY).asInteger() + ";" 
						+ "insert (user: $user, movie-watched: $movie) isa watch;";
			}
		};
	}
}
