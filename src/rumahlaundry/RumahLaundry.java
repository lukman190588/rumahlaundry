/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahlaundry;

/**
 *
 * @author lukman.arizal
 */
public class RumahLaundry {

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
    }
    
}
