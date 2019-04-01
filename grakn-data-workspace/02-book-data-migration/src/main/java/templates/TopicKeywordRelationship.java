package templates;

import migrator.Input;
import mjson.Json;

public class TopicKeywordRelationship {

	static String FILE_PATH         = "/book_files/topic-keyword";
	static String KEYWORD_ID_KEY    = "keyword";
	static String TOPIC_ID_KEY      = "topic";
	
	public static Input template() {
			
		return new Input(FILE_PATH) {
			
			@Override
			public String template(Json relation) {
				
				return "match " 
						+ "$keyword isa Keyword has keyword-id "+ relation.at(KEYWORD_ID_KEY).asInteger() +";"
						+ "$topic isa Topic has topic-id " + relation.at(TOPIC_ID_KEY).asInteger() + ";"
						+ "insert (topic-keyword:$keyword,linked-topic:$topic) isa topic-keyword-link;";
			}
		};
		
	}
}
