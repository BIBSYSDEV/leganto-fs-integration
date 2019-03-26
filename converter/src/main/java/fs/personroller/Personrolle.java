package fs.personroller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.Validable;

@JsonIgnoreProperties(ignoreUnknown = true)

/*
* {
    "href": "https://api.fellesstudentsystem.no/personroller/185498,11",
    "person": {
        "href": "https://api.fellesstudentsystem.no/personer/185498",
        "personlopenummer": 185498
    },
    "rollenummer": 11,
    "rolle": {
        "href": "https://api.fellesstudentsystem.no/roller/L%C3%86RER"
    },
    "periode": {
        "fraDato": "2018-09-02"
    },
    "undervisning": {
        "href": "https://api.fellesstudentsystem.no/undervisning/215,ABIO6000,1,2018,H%C3%98ST,1"
    }
}*/
public class Personrolle extends Validable {

    @JsonProperty("person")
    private Person person;

    @JsonProperty
    private String
}
