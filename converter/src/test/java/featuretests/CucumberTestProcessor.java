package featuretests;

import static utils.JsonUtils.readValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fs.personroller.PersonRole;
import fs.personroller.UndervisningReference;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import utils.JsonUtils;

public abstract class CucumberTestProcessor {

  protected final World world;

  public CucumberTestProcessor(World world) {
    this.world = world;
  }

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
      JsonUtils
        .putKeyInNode(arrayElement, keyValuePairs.cell(row, keyIndex), keyValuePairs.cell(row, valueIndex));
    }
  }

  protected Map<UndervisningReference, List<PersonRole>> createPersonRolesMap() throws JsonProcessingException {
    List<ObjectNode> personRolesJson = arrayNodeToObjectNodeList(world.getPersonRolleEntries());
    List<PersonRole> personRoles = objectNodesToPersonRoles(personRolesJson);

    return listToMap(personRoles);
  }

  private Map<UndervisningReference, List<PersonRole>> listToMap(List<PersonRole> personRoles) {
    Map<UndervisningReference, List<PersonRole>> personRolesMap = new HashMap<>();
    for (PersonRole personRole : personRoles) {
      if (!personRolesMap.containsKey(personRole.getUndervisning())) {
        personRolesMap.put(personRole.getUndervisning(), new ArrayList<>());
      }
      personRolesMap.get(personRole.getUndervisning())
        .add(personRole);
    }
    return personRolesMap;
  }

  private List<PersonRole> objectNodesToPersonRoles(List<ObjectNode> personRolesJson)
    throws JsonProcessingException {
    List<PersonRole> personRoles = new ArrayList<>();
    for (ObjectNode json : personRolesJson) {
      PersonRole personRole = readValue(json, PersonRole.class);
      personRoles.add(personRole);
    }
    return personRoles;
  }

  private List<ObjectNode> arrayNodeToObjectNodeList(ArrayNode arrayNode) {
    Iterator<JsonNode> iterator = arrayNode.elements();
    Iterable<JsonNode> iterable = () -> iterator;
    return StreamSupport.stream(iterable.spliterator(), false)
      .map(jsonNode -> (ObjectNode) jsonNode)
      .collect(Collectors.toList());
  }
}
