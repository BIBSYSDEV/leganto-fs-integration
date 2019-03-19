package featuretests;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import utils.JsonUtils;

public abstract class CucumberTestProcessor {


    protected List<ObjectNode> createElementList(DataTable keyValuePairs) {
        List<ObjectNode> arrayElements = new ArrayList<>();
        for (int row = 0; row < keyValuePairs.height(); row++) {

            ObjectNode arrayElement = JsonUtils.newObjectNode();
            createSingleArrayElement(keyValuePairs, row, arrayElement);
            arrayElements.add(arrayElement);
        }
        return arrayElements;
    }

    private void createSingleArrayElement(DataTable keyValuePairs, int row, ObjectNode arrayElement) {
        for (int valueIndex = 1; valueIndex < keyValuePairs.width(); valueIndex = valueIndex + 2) {
            int keyIndex = valueIndex - 1;
            arrayElement.put(keyValuePairs.cell(row, keyIndex), keyValuePairs.cell(row, valueIndex));
        }
    }
}
