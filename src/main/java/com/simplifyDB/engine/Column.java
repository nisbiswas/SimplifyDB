package com.simplifyDB.engine;

import io.micronaut.inject.qualifiers.ClosestTypeArgumentQualifier;

public record Column(String name, Type type) {
   
    public enum Type {
    
        INT,
        TEXT
    }
    
    public Column{
        if (name==null ||name.isBlank()){
            throw new IllegalArgumentException("Column name cannot be blank or NULL");
        }
    }

} 