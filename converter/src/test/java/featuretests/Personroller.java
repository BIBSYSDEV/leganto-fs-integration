package featuretests;

import static utils.JsonUtils.putKeyInNode;

import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import fs.personroller.PersonRole;
import fs.personroller.PersonRole.Person;
import fs.personroller.Role;
import utils.JsonUtils;

public class Personroller {

    private final World world;
    private String EMPTY_STRING = "";



    public Personroller(World world) {
        this.world = world;
    }

    @Given("there is a valid response from \\/personroller\\/PR_ID")
    public void there_is_valid_response_from_personroller_PR_ID() {
        PersonRole.Person person = new Person()
            .setPersonLopeNummer(EMPTY_STRING)
            .setHref(EMPTY_STRING);

        ObjectNode personRoleJson = JsonUtils.mapper.convertValue(person, ObjectNode.class);
        world.setPersonRoleEntry(personRoleJson);
    }

    @Given("the response from \\/personroller\\/PR_ID has a field {string} with value {string}")
    public void the_response_from_personroller_PR_ID_has_a_field_with_value(String key, String value) {
        putKeyInNode(world.getPersonRolleEntries(), key, value);
    }

    @Given("there is a valid response from \\/rolle\\/ROLLE_ID")
    public void there_is_a_valid_response_from_rolle_ROLLE_ID() {
        Role role = new Role().setCode(EMPTY_STRING);
        ObjectNode roleJson = JsonUtils.mapper.convertValue(role, ObjectNode.class);
        world.setRole(roleJson);
    }

    @Given("the response from \\/rolle\\/ROLLE_ID has a field with name {string} and value {string}")
    public void the_response_from_rolle_ROLLE_ID_has_a_field_with_name_and_value(String key, String value) {
        putKeyInNode(world.getRole(), key, value);
    }






}
