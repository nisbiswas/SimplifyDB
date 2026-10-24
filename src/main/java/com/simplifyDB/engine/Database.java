package com.simplifyDB.engine;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private final Map<String,Table> tables=new LinkedHashMap<>();

    public Table createTable(String name,List<Column> columns)
    {
        if (tables.containsKey(name))
        {
            throw new IllegalArgumentException("Table already exists: "+ name);
        }

        Table table =new Table(name, columns);
        tables.put(name,table);
        return table;
    }

    public Table getTable(String name)
    {
       Table table=tables.get(name);
       
       if(table==null)
       {
         throw new IllegalArgumentException("Table Not Found : "+ name);

       }
       
       return table;

    }
}
