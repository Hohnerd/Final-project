package com.company;

import java.sql.*;

public class Animal {
    public int id;
    public String typ;
    public String name;
    public String work;
    public Date birthday;

    // Чтение из базы данных
    public void read( ResultSet r ) throws SQLException {
        id = Integer.parseInt(r.getString("id"));
        typ = r.getString("typ");
        name = r.getString("name");
        work = r.getString("work");
        birthday = r.getDate("birthday");
    }
}
