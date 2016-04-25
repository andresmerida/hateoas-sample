package com.sample.hateoas.rest.controllers;

import com.sample.hateoas.rest.exceptions.ResourceNotFoundException;

/**
 * Created by andresmerida on 4/13/2016.
 */
public abstract class ResourceHandlingUtils {

    public static <T> T entityOrNotFoundEx(T entity) {
        if ( entity == null  ) {
            throw new ResourceNotFoundException();
        }
        return entity;
    }
}
