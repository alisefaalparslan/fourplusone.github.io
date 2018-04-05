package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBLayer {

    private Connection conn;
    private String dburl = "jdbc:derby://localhost:1527/SportCentre";
    private String root = "root";
    private String password = "dortartibir";

    private Connection connectToDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            System.out.println("baglantı basarili");
            conn = DriverManager.getConnection(dburl, root, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("baglanti basarisiz");
        }
        return conn;
    }

    public void listUsers() {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            System.out.println("username: \t password: \t type");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (user.username != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from users");
                System.out.println("INSERT INTO ROOT.USERS VALUES('" + user.username + "','" + user.nameSurname + "','" + user.password + "','" + "member" + "','" + "true" + "','" + user.Email + "','" + user.phoneNumber
                        + "')");
                stmt.executeUpdate("INSERT INTO ROOT.USERS VALUES('" + user.username + "','" + user.nameSurname + "','" + user.password + "','" + "member" + "','" + "true" + "','" + user.Email + "','" + user.phoneNumber
                        + "')");
            } else {
                System.out.println("Hata var");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkUserExistance(String username, String pass, boolean isItForLogin) {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where username ='" + username + "'");
            if (isItForLogin) {
                rs.next();
                return pass.equals(rs.getString(3));
            } else {
                rs.next();
                return username.equals(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
