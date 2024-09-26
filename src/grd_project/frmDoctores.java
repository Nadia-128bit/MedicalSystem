package grd_project;

import java.awt.Image;
import static java.lang.String.valueOf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public final class frmDoctores extends javax.swing.JFrame {
    
    private int indiceTabla;
    private int idDoctor = 0;    
    public int indice = 0;
    Statement ejecutor = null;
    
    private Conexion conexion = new Conexion();
    
    public void cargarDatos() {
        
        String sql = "select *from buscar_doctor_medicam();";
        try{

            PreparedStatement pst = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel)this.table_Doctores.getModel();
            model.setRowCount(0);
            while(rs.next()){
                model.addRow(new String[]{
                                            rs.getString(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getString(5),
                                            rs.getString(6),
                                            rs.getString(7)});
            }
        }catch(Exception ex){
            System.out.println("Error"+ ex.getMessage());
        }
    }
    
//    public void actualizar_tabla (){
//            String sql="select * from doctores";
//       try{
//           
//           PreparedStatement pst = con.prepareStatement(sql);
//           ResultSet rs = pst.executeQuery();
//           DefaultTableModel model = (DefaultTableModel)this.table_Doctores.getModel();
//           model.setRowCount(0);
//           while(rs.next()){
//               model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
//           }
//       }catch(Exception ex){
//           System.out.println("Error"+ ex.getMessage());
//       }
//    }
    
//    protected void buscarTabla(String IdDoctor,String Nombres,String Especialidad){
//        DefaultTableModel model = (DefaultTableModel)this.table_Doctores.getModel();
//        model.setRowCount(0);
//        String datos[]=new String[6];
//        String where=" where 1=1 ";
//        //Si el nombre no esta vacio
//        if(this.txt_IDDoctor.getText().isEmpty()==false){
//            where=where+" and IdDoctor='"+IdDoctor +"' ";
//        }
//        //Si el puesto no esta vacio
//        if(this.txt_Nombre.getText().isEmpty()==false){
//            where=where+" and Nombres REGEXP '^"+Nombres+"' ";
//        }
//        //Si la edad no esta vacio
//        if(this.txt_Especialidad.getText().isEmpty()==false){
//            where=where+" and Especialidad REGEXP '^"+Especialidad+"' ";
//        }
//        String query="select * from doctores "+where+";";
//        //this.T_consulta.setText(query);
//        ResultSet rs;
//        try {
//            ejecutor=con.createStatement();
//            ejecutor.setQueryTimeout(20);
//            rs=ejecutor.executeQuery(query);
//             
//           
//           
//            while(rs.next()==true){
//                 model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
//               }
//            this.table_Doctores.setModel(model);
//
//        } catch (Exception e) {
//        }
//    }
    
    public void llenar_controles(){
        
       //this.T_id_gc.setText(this.tabla_gc.rowAtPoint(point));
       //int indice = this.table_Doctores.rowAtPoint(evt.getPoint());
       this.txt_Nombre.setText(String.valueOf(this.table_Doctores.getValueAt(indice,1)));
       this.txt_Especialidad.setText(String.valueOf(this.table_Doctores.getValueAt(indice,2)));
       this.txt_Correo.setText(String.valueOf(this.table_Doctores.getValueAt(indice,4)));
       this.txt_Telefono.setText(String.valueOf(this.table_Doctores.getValueAt(indice,5)));
       //this.B_editar.setEnabled(true);
       //this.B_eliminar.setEnabled(true);
       this.T_indice.setText(Integer.toString(indice));
    
    }
    public void desbloquear_textfiles() {
         
        this.txt_Nombre.setFocusable(true);
        this.txt_Especialidad.setFocusable(true);
        this.txt_Correo.setFocusable(true);
        this.txt_Telefono.setFocusable(true);
    }
    public void bloquear_textfiles() {
         
        this.txt_Nombre.setFocusable(false);
        this.txt_Especialidad.setFocusable(false);
        this.txt_Correo.setFocusable(false);
        this.txt_Telefono.setFocusable(false);
    }
     public void limpiar_controles() {
         
        this.txt_Nombre.setText("");
        this.txt_Especialidad.setText("");
        this.txt_Correo.setText("");
        this.txt_Telefono.setText("");
        
    }
     
//    public void insertar_datos() {
//        
//        if(this.txt_IDDoctor.getText().isEmpty()==false || this.txt_Nombre.getText().isEmpty()==false 
//            || this.txt_Especialidad.getText().isEmpty()==false || this.cmb_Area.getSelectedItem().equals(true)==false 
//            || this.txt_Correo.getText().isEmpty()==false || this.txt_Telefono.getText().isEmpty()==false || this.txt_URL.getText().isEmpty()==false){
//        String sql="insert into doctores(IdDoctor,Nombres,Especialidad,Area,Correo,Telefono,Foto)values('"+this.txt_IDDoctor.getText()+"','"
//            +this.txt_Nombre.getText()+"','"+this.txt_Especialidad.getText()+"','"+this.cmb_Area.getSelectedItem()+"','"+this.txt_Correo.getText()+"','"
//            +this.txt_Telefono.getText()+"','"+this.txt_URL.getText()+"')";
//       try{
//           PreparedStatement pst = con.prepareStatement(sql);//ejecuta consulta
//         
//           pst.executeUpdate();
//          
//           
//       }catch(SQLException ex){
//           System.out.println("Error"+ ex.getMessage());
//       }
//       }
//    }
    
//    public void editar_datos() {
//        String sql="update doctores set IdDoctor='"+ this.txt_IDDoctor.getText()+"',Nombres='" 
//            +this.txt_Nombre.getText()+"',Especialidad='" +this.txt_Especialidad.getText()+"', Area='" 
//            +this.cmb_Area.getSelectedItem()+"', Correo='" +this.txt_Correo.getText()+"', Telefono='" 
//            +this.txt_Telefono.getText()+"', Foto='" +this.txt_URL.getText()+"' where IdDoctor='"+this.txt_IDDoctor.getText()+"';";
//        try{
//           PreparedStatement pst = con.prepareStatement(sql);//ejecuta consulta
//         
//           pst.executeUpdate();
//       }catch(SQLException ex){
//           System.out.println("Error"+ ex.getMessage());
//       }
//    }
    
//    public void eliminar_datos() {
//          
//      //  String sql="insert into grannciudad(id,nombre_ciudad,nombre_original,fecha,foto)values('"+this.T_idgc.getText()+"','"+this.T_nomgc.getText()+"','"+this.T_origc.getText()+"','"+this.T_fegc.getText()+"','"+this.T_fogc.getText()+"')";
//        String sql="delete from doctores where IdDoctor='"+Integer.parseInt(this.txt_IDDoctor.getText())+"'";
//        System.out.println(sql);
//        try{
//           PreparedStatement pst = con.prepareStatement(sql);//ejecuta consulta
//         
//           pst.executeUpdate();
//       }catch(SQLException ex){
//           System.out.println("Error"+ ex.getMessage());
//       }
//    }
//    public void doblediagonal() {
//        String cad = this.txt_URL.getText().replace("\\", "\\\\");
//        this.txt_URL.setText(cad);
//    }
     
    public frmDoctores() {
        initComponents();
        
        cargarDatos();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Especialidad = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Doctores = new javax.swing.JTable();
        lbl_fotoDoc = new javax.swing.JLabel();
        T_indice = new javax.swing.JTextField();
        txt_apellido_Paterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_apellido_Materno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doctores");
        setSize(new java.awt.Dimension(1920, 1080));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre(s):");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Correo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Especialidad:");

        jPanel1.setBackground(java.awt.Color.lightGray);

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("REGISTRO DE DOCTORES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel8)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        table_Doctores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Especialidad", "Telefono", "Correo"
            }
        ));
        table_Doctores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_DoctoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Doctores);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Apellido Paterno:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Apellido Materno:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(T_indice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(34, 34, 34)
                                    .addComponent(txt_apellido_Paterno, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(txt_apellido_Materno, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(140, 140, 140)
                        .addComponent(lbl_fotoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addComponent(txt_Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(59, 59, 59)
                        .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(47, 47, 47)
                        .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(T_indice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_fotoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_apellido_Paterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_apellido_Materno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_DoctoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DoctoresMouseClicked
        int indice = this.table_Doctores.rowAtPoint(evt.getPoint());
        this.idDoctor = Integer.valueOf(String.valueOf(this.table_Doctores.getValueAt(indice, 0)));
        this.txt_Nombre.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 1)));
        this.txt_apellido_Paterno.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 2)));
        this.txt_apellido_Materno.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 3)));
        this.txt_Especialidad.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 4)));
        this.txt_Correo.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 5)));
        this.txt_Telefono.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 6)));
        
        this.indiceTabla = indice;
    }//GEN-LAST:event_table_DoctoresMouseClicked

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String nombre = txt_Nombre.getText();
        String apellidoPaterno = txt_apellido_Paterno.getText();
        String apellidoMaterno = txt_apellido_Materno.getText();
        String especialidad = txt_Especialidad.getText();
        String correo = txt_Correo.getText();
        String telefono = txt_Telefono.getText();
        
        String consulta = "call insertar_doctor_medicam('"+nombre+"', '"+apellidoPaterno+"', '"+apellidoMaterno+"', '"+especialidad+"', '"+telefono+"', '"+correo+"');";
        
        conexion.agregarDatos(consulta);
//          if(this.btn_Agregar.getText()=="Agregar")
//       {
//             this.btn_Agregar.setText("Guardar");
//             this.desbloquear_textfiles();
//             this.limpiar_controles();
//             this.btn_Editar.setEnabled(false);
//             this.btn_Eliminar.setEnabled(false);
//             this.btn_Buscar.setEnabled(false);     
//       }
//       else
//       {
//           this.btn_Agregar.setText("Agregar");
//           this.insertar_datos();
//           this.actualizar_tabla();
//           this.bloquear_textfiles();
//           this.btn_Editar.setEnabled(true);
//           this.btn_Eliminar.setEnabled(true);
//           this.btn_Buscar.setEnabled(true);
//           
//       }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
//        this.eliminar_datos();
//        this.actualizar_tabla();

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al doctor?");

        if(opcion == JOptionPane.YES_OPTION) {
            String consulta = "call eliminar_doctor_medicam('"+idDoctor+"');";

            conexion.eliminar(consulta);
            cargarDatos();   
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        this.actualizar_tabla();
//        this.llenar_controles();
//        this.bloquear_textfiles();
         
    }//GEN-LAST:event_formWindowOpened
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDoctores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDoctores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDoctores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDoctores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDoctores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField T_indice;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_fotoDoc;
    private javax.swing.JTable table_Doctores;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Especialidad;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_apellido_Materno;
    private javax.swing.JTextField txt_apellido_Paterno;
    // End of variables declaration//GEN-END:variables
}