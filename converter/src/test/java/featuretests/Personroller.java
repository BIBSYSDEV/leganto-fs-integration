package featuretests;

import cucumber.api.java.en.Given;

public class Personroller {

    private final World world;

    public Personroller(World world) {
        this.world = world;
    }

    @Given("there is a personrolle entry with id PR_ID connected to the undervisingsaktivitet with id {string}")
    public void there_is_a_personrolle_entry_with_id_PR_ID_connected_to_the_undervisingsaktivitet_with_id(
        String string) {
        Personrolle
    }
}
