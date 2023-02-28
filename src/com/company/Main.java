package com.company;

import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    public static void main(String[] args) {
        try
        {
            new Main().run();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    Connection conn;
    PrintStream out = new PrintStream(System.out, true, UTF_8);
    Scanner in = new Scanner( System.in );

    void run() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://192.168.2.18/animals"
                        // "?useUnicode=false&characterEncoding=u",
                , "root", "12345678");

        Animal a;
        PreparedStatement q;
        ResultSet r;

        List<Integer> home, pack;

        home = new ArrayList<>();
        pack = new ArrayList<>();

        q = conn.prepareStatement("select * from home;");
        r = q.executeQuery();

        while (r.next())
            home.add( r.getInt("id") );

        q = conn.prepareStatement("select * from pack;");
        r = q.executeQuery();

        while (r.next())
            pack.add( r.getInt("id") );

        while (true)
        {

            q = conn.prepareStatement( "select * from animal;" );
            r = q.executeQuery();

            out.println("Текущий список");
            while (r.next())
            {
                a = new Animal();
                a.read(r);

                out.print( "  " + a.id + ": " + a.typ + " " + a.name + " " + a.work );

                if (home.indexOf(a.id) >= 0)
                    out.print( " домашний");
                if (pack.indexOf(a.id) >= 0)
                    out.print( " вьючный");

                out.println("");
            }

            out.println( "1. Добавить");
            out.println( "2. Сделать домашним");
            out.println( "3. Сделать вьючным");
            out.println( "4. Обучить");
            out.println( "0. Exit" );

            int n = Integer.parseInt(in.nextLine());
            if (n == 0) break;
            if (n == 1) {
                // Добавить

                // Создаем без try
                // Cnt cnt = new Cnt();

                try(Cnt cnt = new Cnt())
                {
                    // Вот тут ошибка, если вызвать без try
                    cnt.add();

                    a = new Animal();

                    out.print("Введите тип: ");
                    a.typ = in.nextLine();
                    out.print("Введите имя: ");
                    a.name = in.nextLine();

                    q = conn.prepareStatement("insert into animal (typ, name) values (?, ?);");
                    q.setString(1, a.typ);
                    q.setString(2, a.name);

                    int res = q.executeUpdate();
                    out.println("  Добавлено " + res + " строк");
                }
                catch (Exception ex)
                {
                    ;
                } // */
            }
            if ((n == 2) | (n == 3)) {
                ; // Сделать домашним или cделать вьючным

                out.print( "Введите ид: ");
                int id = Integer.parseInt(in.nextLine());

                if ((n == 2) & (home.indexOf(id) >= 0)) {
                    out.println("  Такой ИД уже есть в таблице");
                    continue;
                }

                if ((n == 3) & (pack.indexOf(id) >= 0)) {
                    out.println("  Такой ИД уже есть в таблице");
                    continue;
                }

                if (n == 2) {
                    q = conn.prepareStatement("insert into home (id) values (?);");
                    home.add(id);
                }
                else {
                    q = conn.prepareStatement("insert into pack (id) values (?);");
                    pack.add(id);
                }

                q.setInt(1, id);

                int res = q.executeUpdate();
                out.println( "  Добавлено " + res + " строк");
            }
            if (n == 4) {
                // Обучить
                out.print( "Введите ид: ");
                int id = Integer.parseInt(in.nextLine());

                out.print( "Введите новое умение: ");
                String u = in.nextLine();

                q = conn.prepareStatement( "update animal " +
                        "set work=CONCAT( IFNULL( work, '' ), ? ) " +
                        "where id=?;" );
                q.setString(1, u);
                q.setInt(2, id);

                int res = q.executeUpdate();
                out.println( "  обновлено " + res + " строк");
            }
        }
    }
}
