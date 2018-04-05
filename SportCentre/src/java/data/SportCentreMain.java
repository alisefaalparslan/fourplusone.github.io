package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Onur
 */
public class SportCentreMain {
    public static void main(String[] args) {
        /*User user = new User();
        user.username = "Onur";
        user.password = "123";*/
        DBLayer db = new DBLayer();
        //db.addUser(user);
        db.listUsers();
    }
    
}
