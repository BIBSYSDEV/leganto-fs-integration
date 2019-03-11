package fs.organizations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationEntity {

    @JsonProperty("institusjon")
    private Integer institution;

    @JsonProperty("fakultet")
    private Integer faculty;

    @JsonProperty("institutt")
    private Integer institute;

    public Integer getInstitution() {
        return institution;
    }

    public OrganizationEntity setInstitution(Integer institution) {
        this.institution = institution;
        return this;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public OrganizationEntity setFaculty(Integer faculty) {
        this.faculty = faculty;
        return this;
    }

    public Integer getInstitute() {
        return institute;
    }

    public OrganizationEntity setInstitute(Integer institute) {
        this.institute = institute;
        return this;
    }
}
