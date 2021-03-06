package migrator;

import mjson.Json;

public abstract class Input {
    String path;

    public Input(String path) {
      this.path = path;
    }

    String getDataPath() {
      return path;
    }

    public abstract String template(Json data);  
}