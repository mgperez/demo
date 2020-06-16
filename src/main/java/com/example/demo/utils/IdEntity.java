package com.example.demo.utils;

import org.springframework.util.StringUtils;

/**
 * Entity-based object
 *
 * https://github.com/seangogo/CSIC/blob/master/serviceapi/src/main/java/com/dh/entity/IdEntity.java
 */
public class IdEntity extends BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected String id;

    public IdEntity() {
        if (StringUtils.isEmpty(id)) {
            id = IdGen.uuid();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
