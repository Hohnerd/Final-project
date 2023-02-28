package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Role {
    public int id;

    // Чтение из базы данных
    public void read( ResultSet r ) throws SQLException {
        id = Integer.parseInt(r.getString("id"));
    }
}
