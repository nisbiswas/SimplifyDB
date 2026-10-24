package com.simplifyDB.engine;

import java.util.List;

public record Row(List<Object> values) {
    public Row{
        values=List.copyOf(values);
    }

    public Object get(int columnIndex){
        return values.get(columnIndex);
    }
}
