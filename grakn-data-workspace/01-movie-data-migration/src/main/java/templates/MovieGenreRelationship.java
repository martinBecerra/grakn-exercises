package templates;

import migrator.Input;
import mjson.Json;

public class MovieGenreRelationship {

	static String FILE_PATH = "/movie_files/movie-genre";
	static String MOVIE_ID_KEY  = "movie";
	static String GENRE_ID_KEY  = "genre";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$movie isa Movie has movie-id " + relation.at(MOVIE_ID_KEY).asInteger() + ";"
						+ "$genre isa Genre has genre-id " + relation.at(GENRE_ID_KEY).asInteger() + ";"
						+ "insert (film: $movie, movie-genre: $genre) isa belongs-to-genre;";
			}
		};
	}
}
