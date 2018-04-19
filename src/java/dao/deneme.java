package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;


public class deneme  extends HttpServlet {
    
 
/*
    private Connection conn;
    private String dburl = "jdbc:derby://localhost:1527/SportCentre";
    private String root = "root";
    private String password = "dortartibir";*/
    
    
  public void yazdir() 
  throws IOException {
    String str = "Hello";
    BufferedWriter writer = new BufferedWriter(new FileWriter("sa.txt"));
    writer.write(str);
     
    writer.close();
}
    
    public void firttry() throws IOException{
     //   connectToDB();
        System.out.println("asdad");
        yazdir();
        

// Just pass the connection and the table name to printTable()
        
    }
/*
    public Connection connectToDB() {
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

    public void getUser(User temp) {

        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
                temp.setId(rs.getInt(1));
                temp.setPassword(rs.getString(3));
                System.out.println(temp.getPassword());
                temp.setNameSurname(rs.getString(4));
                System.out.println(temp.getNameSurname());
                temp.setEmail(rs.getString(7));
                System.out.println(temp.getEmail());
                temp.setPhoneNumber(rs.getLong(8));
                System.out.println(temp.getPhoneNumber());
                temp.setStartDate(rs.getString(9));
                System.out.println(temp.getStartDate());
                temp.setEndDate(rs.getString(10));
                System.out.println(temp.getEndDate());
            } else {
                System.out.println("Hata var");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user, String type) {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (user.getUsername() != null) {
                Statement stmt = conn.createStatement();
                user.calculateStartEndDate();
                System.out.println("INSERT INTO ROOT.USERS(USERNAME,PASSWORD,NAMESURNAME,TYPE,STATUS,EMAIL,PHONE,STARTDATE,ENDDATE) VALUES('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getNameSurname() + "','" + type + "','" + "true" + "','" + user.getEmail() + "'," + user.getPhoneNumber()
                        + ",'" + user.getStartDate() + "','" + user.getEndDate() + "')");
                stmt.executeUpdate("INSERT INTO ROOT.USERS(USERNAME,PASSWORD,NAMESURNAME,TYPE,STATUS,EMAIL,PHONE,STARTDATE,ENDDATE) VALUES('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getNameSurname() + "','" + type + "','" + "true" + "','" + user.getEmail() + "'," + user.getPhoneNumber()
                        + ",'" + user.getStartDate() + "','" + user.getEndDate() + "')");
            } else {
                System.out.println("Hata var");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (user.getUsername() != null) {
                Statement stmt = conn.createStatement();
                System.out.println("UPDATE ROOT.USERS SET NAMESURNAME = '" + user.getNameSurname() + "', EMAIL = '" + user.getEmail() + "', PHONE = " + user.getPhoneNumber() + " WHERE USERNAME = '" + user.getUsername() + "'");
                stmt.executeUpdate("UPDATE ROOT.USERS SET NAMESURNAME = '" + user.getNameSurname() + "', EMAIL = '" + user.getEmail() + "', PHONE = " + user.getPhoneNumber() + " WHERE USERNAME = '" + user.getUsername() + "'");
            } else {
                System.out.println("Hata var");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (user.getUsername() != null) {
                Statement stmt = conn.createStatement();
                System.out.println("DELETE FROM ROOT.USERS WHERE USERNAME = '" + user.getUsername() + "'");
                stmt.executeUpdate("DELETE FROM ROOT.USERS WHERE USERNAME = '" + user.getUsername() + "'");
            } else {
                System.out.println("Hata var");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void freezeUser(User user) {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (user.getUsername() != null) {
                Statement stmt = conn.createStatement();
                System.out.println("UPDATE ROOT.USERS SET STATUS = 'false' WHERE USERNAME = '" + user.getUsername() + "'");
                stmt.executeUpdate("UPDATE ROOT.USERS SET STATUS = 'false' WHERE USERNAME = '" + user.getUsername() + "'");
            } else {
                System.out.println("Hata var");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLoginExistance(Guest guest) {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + guest.getUsername() + "'");

            if (!rs.next()) {
                return false;
            }
            if (guest.getPassword().equals(rs.getString(3)) && rs.getBoolean(6)) {
                guest.setType(rs.getString(5));
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkSignUpExistance(User user) {
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + user.getUsername() + "'");

            if (!rs.next()) {
                return false;
            }
            if (user.getUsername().equals(rs.getString(2))) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isConflict(User temp, ScheduledService lesson){
        
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
 
                temp.setGlID(rs.getString(11));
                System.out.println(temp.getGlID());
                
                
            if(temp.getGlID()==null){
                    
                    System.out.println("No reservation yet");

                    return false;
                
                
            }
            else if(temp.getGlID().contains(Integer.toString(lesson.getId()))){
                    
                System.out.println("Already reserved");
                return true;  
            } 
            rs = stmt.executeQuery("SELECT * FROM ROOT.GROUPLESSON WHERE TIMESLICE =" + lesson.getTimeSlice()+ " AND NOT NAME ='" +lesson.getName()+ "'");
            if(rs.next()){
                System.out.println("Reservation to another class on the same time slice");
                return true;
            }


                
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
    public void reserveLesson(User temp, ScheduledService lesson){
        
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
 
                temp.setGlID(rs.getString(11));
                System.out.println(temp.getGlID());
                
                
                if(temp.getGlID()==null){
                System.out.println("No reservation yet");
                temp.setGlID(Integer.toString(lesson.getId()));
                temp.setGlID(temp.getGlID().concat(","));
                
            }
            else{
                if(!isConflict(temp, lesson)){
                System.out.println("Addition to reservation");
                System.out.println(lesson.getId());

                temp.setGlID(temp.getGlID().concat(Integer.toString(lesson.getId())));
                temp.setGlID(temp.getGlID().concat(","));  }
            }

            stmt.executeUpdate("UPDATE ROOT.USERS SET GL_ID = '" + temp.getGlID() + "' WHERE USERNAME = '" + temp.getUsername() + "'");


                
            } else {
                System.out.println("Hata var");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public void cancelReservation(User temp, ScheduledService lesson) {
        
        
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
 
                temp.setGlID(rs.getString(11));
                System.out.println(temp.getGlID());
                
                
                if(temp.getGlID()==null || temp.getGlID().equals("")){
                    System.out.println("No reservation yet to cancel");
                
                
                }
                else{
                    System.out.println("Cancelling");
                    String last=temp.getGlID().replace(Integer.toString(lesson.getId())+",", "");
                    stmt.executeUpdate("UPDATE ROOT.USERS SET GL_ID = '" + last + "' WHERE USERNAME = '" + temp.getUsername() + "'");


                   
                }



                
            } else {
                System.out.println("Hata var");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        


            
    }
    public boolean haveScheduleConflict(User temp,String day,int timeslice){
        
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
 
                temp.setGlID(rs.getString(11));
                temp.setPtID(rs.getString(12));
                
                
                
            if((temp.getGlID()==null && temp.getPtID()==null) ){
                    
                    System.out.println("No reservation yet");

                    return false;
            }
            
 
            rs = stmt.executeQuery("SELECT * FROM ROOT.GROUPLESSON WHERE TIMESLICE =" + timeslice+ " AND DAY ='" +day+ "'");
            if(rs.next()){
                int glId=rs.getInt(1);
                if(temp.getGlID().contains(Integer.toString(glId))){
                    System.out.println("Group Lesson Reservation On The Same Time");
                    
                    return true;   
                }
            }
            if(temp.getPtID()!=null){
                
                           rs = stmt.executeQuery("SELECT * FROM ROOT.PT WHERE TIMESLICE =" + timeslice+ " AND DAY ='" +day+ "'");
            if(rs.next()){
                int ptId=rs.getInt(1);
                if(temp.getPtID().contains(Integer.toString(ptId))){
                    System.out.println("PT Reservation On The Same Time");
                    
                    return true;   
                }
            }
                
            }

            if(temp.getSpaID()!=null){
                
                rs = stmt.executeQuery("SELECT * FROM ROOT.SPA WHERE TIMESLICE =" + timeslice+ " AND DAY ='" +day+ "'");
                if(rs.next()){
                    int spaId=rs.getInt(1);
                    if(temp.getSpaID().contains(Integer.toString(spaId))){
                        System.out.println("Spa Reservation On The Same Time");
                    
                        return true;   
                    }
                }
                
            }    
        } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
    
    public void ptReservation(User temp, ScheduledService pt){
        
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
 
                temp.setPtID(rs.getString(12));
                
                
                if(temp.getPtID()==null || temp.getPtID().equals("")){
                System.out.println("No pt currently");
                temp.setPtID(Integer.toString(pt.getId()));
                temp.setPtID(temp.getPtID().concat(","));
                
                }
                else{
                    if(!haveScheduleConflict(temp,pt.getDay(), pt.getTimeSlice())){
                    System.out.println("Addition to pt reservation");
                    System.out.println(pt.getId());

                    temp.setPtID(temp.getPtID().concat(Integer.toString(pt.getId())));
                    temp.setPtID(temp.getPtID().concat(","));  
                    }
                    else{
                        System.out.println("Schedule conflict!!");
                        return;
                    }
                }

                stmt.executeUpdate("UPDATE ROOT.USERS SET PT_ID = '" + temp.getPtID() + "' WHERE USERNAME = '" + temp.getUsername() + "'");


                
            } 
            else {
                System.out.println("Hata var");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void cancelPTReservation(User temp, ScheduledService pt){
        
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
 
                temp.setPtID(rs.getString(12));
                System.out.println(temp.getPtID());
                
                
                if(temp.getPtID()==null || temp.getPtID().equals("")){
                    System.out.println("No reservation yet to cancel");
                
                
                }
                else{
                    System.out.println("Cancelling");
                    String last=temp.getPtID().replace(Integer.toString(pt.getId())+",", "");
                    stmt.executeUpdate("UPDATE ROOT.USERS SET PT_ID = '" + last + "' WHERE USERNAME = '" + temp.getUsername() + "'");


                   
                }



                
            } else {
                System.out.println("Hata var");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void spaReservation(User temp, ScheduledService spa){
        
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
 
                temp.setSpaID(rs.getString(13));
                
                
                if(temp.getSpaID()==null || temp.getSpaID().equals("")){
                System.out.println("No spa reservation currently");
                temp.setSpaID(Integer.toString(spa.getId()));
                temp.setSpaID(temp.getSpaID().concat(","));
                
                }
                else{
                    if(!haveScheduleConflict(temp,spa.getDay(), spa.getTimeSlice())){
                    System.out.println("Addition to spa reservation");
                    System.out.println(spa.getId());

                    temp.setSpaID(temp.getSpaID().concat(Integer.toString(spa.getId())));
                    temp.setSpaID(temp.getSpaID().concat(","));  
                    }
                    else{
                        System.out.println("Schedule conflict!!");
                        return;
                    }
                }

                stmt.executeUpdate("UPDATE ROOT.USERS SET SPA_ID = '" + temp.getSpaID() + "' WHERE USERNAME = '" + temp.getUsername() + "'");


                
            } 
            else {
                System.out.println("Hata var");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void cancelSpaReservation(User temp, ScheduledService spa){
        
        if (conn == null) {
            System.out.println("veritabani bagli degil");
            connectToDB();
        }
        try {
            if (temp.getUsername() != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME ='" + temp.getUsername() + "'");
                rs.next();
 
                temp.setSpaID(rs.getString(13));
                System.out.println(temp.getSpaID());
                
                
                if(temp.getSpaID()==null || temp.getSpaID().equals("")){
                    System.out.println("No reservation yet to cancel");
                
                
                }
                else{
                    System.out.println("Cancelling");
                    String last=temp.getSpaID().replace(Integer.toString(spa.getId())+",", "");
                    stmt.executeUpdate("UPDATE ROOT.USERS SET SPA_ID = '" + last + "' WHERE USERNAME = '" + temp.getUsername() + "'");


                   
                }



                
            } else {
                System.out.println("Hata var");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
*/

}
