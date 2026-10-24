package com.simplifyDB.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class DatabaseTest {
    
    @Test 
    void createTableInsertsAndReadsRow()
    {
        Database db= new Database();

        Table users=db.createTable("users",List.of(new Column("id",Column.Type.INT),new Column("name",Column.Type.TEXT)));

        users.insert(List.of(1,"Ada"));
        assertEquals(1, users.rows().size());
        assertEquals(1, users.rows().get(0).get(0));
        assertEquals("Ada", users.rows().get(0).get(1));
    }

    @Test
    void rejectWrongNumberofValues()
    {
        Database db=new Database();

        Table users=db.createTable("users", List.of(new Column("id",Column.Type.INT)));
        
        assertThrows(IllegalArgumentException.class, ()->users.insert(List.of(1,"extra")));
    }

}
