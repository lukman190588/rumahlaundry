/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahlaundry.util;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author lukman.arizal
 */
public class MyHelper {
    
    public static boolean validateTextRequired(JTextField fldScreen) {
        if (fldScreen.getText().equals("")) {
            fldScreen.requestFocus();
            JOptionPane.showMessageDialog(null, "Data Harus diisi");
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean validatePasswordRequired(JPasswordField fldScreen) {
        if (fldScreen.getPassword().equals("")) {
            fldScreen.requestFocus();
            JOptionPane.showMessageDialog(null, "Password Harus diisi");
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean validateTextAreaRequired(JTextArea fldScreen) {
        if (fldScreen.getText().equals("")) {
            fldScreen.requestFocus();
            JOptionPane.showMessageDialog(null, "Data Harus diisi");
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean validateComboboxRequired(JComboBox fldScreen) {
        if (fldScreen.getSelectedIndex() == '0') {
            fldScreen.requestFocus();
            JOptionPane.showMessageDialog(null, "Data Harus diisi");
            return false;
        } else {
            return true;
        }
    }

}
