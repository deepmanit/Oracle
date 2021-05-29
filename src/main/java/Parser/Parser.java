package Parser;

import java.io.IOException;
import java.util.List;

public interface Parser {
    List<String[]> parseData(String file) throws IOException;
}
