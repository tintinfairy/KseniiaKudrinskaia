package hw8.dataproviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hw7hw8.entities.DataForMetalAndColorsForm;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class DataProviderMetalAndColors {
    private static final String JSON_PATH = "src/main/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "DataSetForMetalAndColorsFromJson")
    public Object[][] provideDataFromJson() throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new FileReader(JSON_PATH));
        Map<String, DataForMetalAndColorsForm> jsonData = new Gson().fromJson(element,
                new TypeToken<Map<String, DataForMetalAndColorsForm>>() {
                }.getType());

        Object[][] data = new Object[jsonData.size()][1];
        int index = -1;
        for (String key : jsonData.keySet()) {
            data[++index][0] = jsonData.get(key);
        }

        return data;

    }
}
