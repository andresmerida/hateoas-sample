package com.sample.hateoas.rest.controllers.resources;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Created by andresmerida on 4/13/2016.
 */

public abstract class BaseResourceWithEmbeddeds extends ResourceSupport {

    // The @JsonUnwrapped annotation is required as EmbeddedWrappers are by default serialised in a "_embedded" container,
    // that has to be added directly into the top level object
    @JsonUnwrapped
    private Resources<EmbeddedWrapper> embeddeds;

    public Resources<EmbeddedWrapper> getEmbeddeds() {
        return embeddeds;
    }

    public void setEmbeddeds(Resources<EmbeddedWrapper> embeddeds) {
        this.embeddeds = embeddeds;
    }
}
