package grd_project;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class GRD_Project {
    
    public static void main(String[] args) {
        
        /*Creación del objeto para llamar al Jframe principal*/ 
        frmMenuPrincipal menuPrincipal = new frmMenuPrincipal();
        
        menuPrincipal.setVisible(true);
        menuPrincipal.setResizable(true);
        menuPrincipal.setExtendedState(MAXIMIZED_BOTH);
    }
}