package migrator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import ai.grakn.GraknTxType;
import ai.grakn.Keyspace;
import ai.grakn.client.Grakn;
import ai.grakn.util.SimpleURI;
import mjson.Json;
import templates.ApprovedCourseRelationship;
import templates.Career;
import templates.CareerSkillRelationship;
import templates.Course;
import templates.Person;
import templates.Skill;
import templates.SkillCourseRelationship;
import templates.UserCareerRelationship;


public class Migrator {
	
	static String KEYSPACE = "courses";
	static int GRAKN_SERVER_PORT = 48555;
	
	public static void main(String[] args) {
	    Collection<Input> inputs = initialiseInputs();
	    connectAndMigrate(inputs);
	}

	static void connectAndMigrate(Collection<Input> inputs) {
		
		SimpleURI localGrakn = new SimpleURI("localhost", GRAKN_SERVER_PORT);
		Keyspace keyspace = Keyspace.of(KEYSPACE);
		Grakn grakn = new Grakn(localGrakn);
		Grakn.Session session = grakn.session(keyspace);

		inputs.forEach(input -> {
			System.out.println("Loading from [" + input.getDataPath() + "] into Grakn ...");
			try {
				loadDataIntoGrakn(input, session);
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		});

		session.close();
	}

	
	static void loadDataIntoGrakn(Input input, Grakn.Session session) throws IOException, URISyntaxException {
		
		CSVParser parser = new CSVParser();
		
		ArrayList<Json> items = parser.parseDataToJson(input);
		
		items.forEach(item -> {
			Grakn.Transaction tx = session.transaction(GraknTxType.WRITE);
			String graqlInsertQuery = input.template(item);
			System.out.println("Executing Graql Query: " + graqlInsertQuery);
			tx.graql().parse(graqlInsertQuery).execute();
			tx.commit();
			tx.close();
		});
		
		System.out.println("\nInserted " + items.size() + " items from [ " + input.getDataPath() + "] into Grakn.\n");

	}
		
	  static Collection<Input> initialiseInputs() {
	    
		  Collection<Input> inputs = new ArrayList<>();
	      
		  inputs.add(Person.template());
		  inputs.add(Course.template());
		  inputs.add(Career.template());
		  inputs.add(Skill.template()); 
		  
		  inputs.add(ApprovedCourseRelationship.template());
		  inputs.add(CareerSkillRelationship.template());
		  inputs.add(SkillCourseRelationship.template());
		  inputs.add(UserCareerRelationship.template());
	    
		  return inputs;
	  }
	  
}
