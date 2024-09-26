package grd_project;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class GRD_Project {
    
    public static void main(String[] args) {
        
        /*Creación del objeto para llamar al Jframe principal*/ 
        Login login = new Login();
        login.setVisible(true);
        login.setResizable(true);
        login.setExtendedState(MAXIMIZED_BOTH);
        

    }
}