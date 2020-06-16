package com.example.demo.utils;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Suggest all PO,VO and DTO both inherit this class Overriding the default toString，equals and hashCode And by default all subclasses support serialization
 */
public class BaseObject implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /*
     * Reloaded via apache commons lang3
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /*
     * Reloaded via apache commons lang3
     */
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /*
     * Reloaded via apache commons lang3
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}