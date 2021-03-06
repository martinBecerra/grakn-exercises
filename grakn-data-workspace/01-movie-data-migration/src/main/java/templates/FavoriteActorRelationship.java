package templates;

import migrator.Input;
import mjson.Json;

public class FavoriteActorRelationship {

	static String FILE_PATH       = "/movie_files/favorite-actor";
	static String ACTOR_ID_KEY    = "actor";
	static String USER_ID_KEY     = "user";
	
	public static Input template() {
		
		return new Input(FILE_PATH) {
			
			// 
			@Override
			public String template(Json relation) {
				
				return "match "
						+ "$actor isa Actor  has actor-id " + relation.at(ACTOR_ID_KEY).asInteger() + ";"
						+ "$user  isa Person has person-id " + relation.at(USER_ID_KEY).asInteger()  + ";"
						+ "insert (favorite-actor: $actor, user: $user) isa is-favorite-actor;";
			}
		};
	}
	
}
