package jdbc;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws Exception {
        System.out.println("loading h2 driver...");
        Class.forName("org.h2.Driver");
        System.out.println("h2 driver loaded!");

        System.out.println("establishing connection...");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test")) {
            System.out.println("connection established!");

            try (Statement statement = connection.createStatement()) {
                // TODO Erzeuge Tabelle(n)
                statement.execute("" +
                    "create table Kleidung(id IDENTITY, " +
                    "name varchar(100), " +
                    "preis DOUBLE)");
                statement.execute("" +
                    "create table Kunde(id IDENTITY, " +
                    "vorname varchar(50), " +
                    "nachname varchar(50), " +
                    "email varchar(100), " +
                    "zipCode INT)");
                statement.execute("create table Warenkorb(" +
                    "id IDENTITY, " +
                    "kunde_id BIGINT, " +
                    "kleidungs_id BIGINT, " +
                    "foreign key (kleidungs_id) references Kleidung(id), " +
                    "foreign key (kunde_id) references Kunde(id))");

                // TODO Befülle Tabelle(n)
                statement.execute("insert into Kleidung (name, preis) values('Hose', 20)");
                statement.execute("insert into Kleidung (name, preis) values('Mütze', 15)");
                statement.execute(
                    "insert into Kunde (vorname, nachname, email, zipCode) values('Hans', 'Peter','a@b.de', 12451)");
                statement.execute("insert into Warenkorb (kunde_id, kleidungs_id) values (1, 1)");

                // TODO Stelle eine Anfrage an die Datenbank
                try (ResultSet resultSet = statement.executeQuery("select * from Warenkorb w JOIN Kleidung k ON k.id = w.kleidungs_id")) {
                    // TODO Zeige Ergebnisse an
                    System.out.println("----------------------------------------");
                    while (resultSet.next()) {
                        int someInt = resultSet.getInt("kunde_id");
                        int someString = resultSet.getInt("kleidungs_id");
                        String str = resultSet.getString("name");
                        System.out.println(someInt + " " + someString);
                        System.out.println(str);
                    }
                    System.out.println("----------------------------------------");
                }
            }
        }
    }
}
