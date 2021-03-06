package migrator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import mjson.Json;

public class CSVParser {

	public ArrayList<Json> parseDataToJson(Input input) 
			throws IOException, URISyntaxException {
		ArrayList<Json> items = new ArrayList<>();

		CsvParserSettings settings = new CsvParserSettings();
		settings.setLineSeparatorDetectionEnabled(true);
		settings.setDelimiterDetectionEnabled(true,';');
		
		CsvParser parser = new CsvParser(settings);
		parser.beginParsing(getReader(input.getDataPath() + ".csv"));
		
		
		String[] columns = parser.parseNext();
		String[] row;
		while ((row = parser.parseNext()) != null) {
			Json item = Json.object();
			for (int i = 0; i < row.length; i++) {
				item.set(columns[i], row[i]);
			}
			items.add(item);
		}
		return items;
	}

	Reader getReader(String relativePath) throws IOException, URISyntaxException {
		
		File file = new File(this.getClass().getResource(relativePath).toURI());
		FileInputStream input = new FileInputStream(file);
		
		return new InputStreamReader(input, "UTF-8");
	}

}
