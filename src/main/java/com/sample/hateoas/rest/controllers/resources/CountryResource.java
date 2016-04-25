package com.sample.hateoas.rest.controllers.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.core.Relation;

/**
 * Created by andresmerida on 4/13/2016.
 */

@Relation(value = "country", collectionRelation = "countries") // Specify the name to be used when _embedded
public class CountryResource extends BaseResourceWithEmbeddeds {

    private final String name;
    private final String initials;
    private final Boolean deleted;

    @JsonCreator
    public CountryResource(@JsonProperty("name") String name, @JsonProperty("initials") String initials,
                           @JsonProperty("deleted") Boolean deleted) {
        super();
        this.name = name;
        this.initials = initials;
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }

    public Boolean getDeleted() {
        return deleted;
    }
}
