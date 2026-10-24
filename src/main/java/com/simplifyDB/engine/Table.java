package com.simplifyDB.engine;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private final String name;
    private final List<Column> columns;
    private final List<Row> rows=new ArrayList<>();

    public Table(String name,List<Column> columns){
        if (name==null||name.isBlank())
        {
            throw new IllegalArgumentException("Table name cannnot be blank");

        }

        if(columns==null||columns.isEmpty())
        {
            throw new IllegalArgumentException("A table must have atleast one columns");
        }

        this.name=name;
        this.columns=List.copyOf(columns);

    }

    public void insert(List<Object> values)
    {
        if(values.size()!=columns.size())
        {
            throw new IllegalArgumentException(
                "Expected "+ columns.size() + " values, got "+ values.size()   
            );
        }
        
        for(int i=0;i<values.size();i++)
        {
            Object value=values.get(i);
            Column column=columns.get(i);

            if(column.type()==Column.Type.INT && !(value instanceof Integer))
            {
                throw new IllegalArgumentException(
                    "Column "+column.name()+" expects INT"
                );
            }

            if(column.type()==Column.Type.TEXT && !(value instanceof String))
            {
                throw new IllegalArgumentException(
                    "Column "+column.name()+" expects TEXT"
                );
            }

        }

        rows.add(new Row(values));

    }

    public String name(){
        return name;
    }

    public List<Column> columns(){
        return columns;
    }

    public List<Row> rows()
    {
        return List.copyOf(rows);
    }

}
