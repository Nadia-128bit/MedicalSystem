package grd_project;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public final class frmIngresos extends javax.swing.JFrame {
    
    private Conexion conexion = new Conexion();
    private static Connection con;
    Statement ejecutor = null;
    public int indice = 0;
    private int idPaciente = 0, idDoctor = 0, idIngreso = 0;
    
    private String queryPacientes = "select *from buscar_paciente_medicam();";
    private String queryDoctores = "select *from buscar_doctor_medicam();";
    private String queryIngresos = "select *from buscar_ingreso_medicam();";

    private int indiceTabla;
    
    protected void buscarTabla(String IdIngreso,String NSS,String NumeroCama){
        DefaultTableModel model = (DefaultTableModel)this.table_Ingresos.getModel();
        model.setRowCount(0);
        String datos[]=new String[5];
        String where=" where 1=1 ";


        //Si la edad no esta vacio
        if(this.txt_Cama.getText().isEmpty()==false){
            where=where+" and NumeroCama REGEXP '^"+NumeroCama+"' ";
        }
        String query="select * from doctores "+where+";";
        //this.T_consulta.setText(query);
        ResultSet rs;
        try {
            ejecutor=con.createStatement();
            ejecutor.setQueryTimeout(20);
            rs=ejecutor.executeQuery(query);
             
           
           
            while(rs.next()==true){
                 model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
               }
            this.table_Ingresos.setModel(model);

        } catch (Exception e) {
        }
    }
    
    public frmIngresos() {
        initComponents();
        
        conexion.cargarDatos(table_Pacientes, queryPacientes);
        conexion.cargarDatos(table_Doctores, queryDoctores);
        conexion.cargarDatos(table_Ingresos, queryIngresos);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Diagnostico = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Cama = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Ingresos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_Nuevo = new javax.swing.JButton();
        btn_DarAlta = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        lbl_fotoIngreso = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_Piso = new javax.swing.JTextField();
        txt_medico_Acargo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Pacientes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Doctores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresos");
        setSize(new java.awt.Dimension(1920, 1080));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Paciente:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Médico a cargo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Diagnostico:");

        txt_Nombre.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("REGISTRO DE INGRESO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel8)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        table_Ingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Paciente", "NSS", "Diagnostico", "No. Cama", "Piso", "Medico", "Fecha ingreso"
            }
        ));
        table_Ingresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_IngresosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Ingresos);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btn_Nuevo.setText("Ingresar");
        btn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NuevoActionPerformed(evt);
            }
        });

        btn_DarAlta.setText("Dar alta");
        btn_DarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DarAltaActionPerformed(evt);
            }
        });

        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_DarAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_DarAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("No. Cama:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Piso:");

        txt_medico_Acargo.setText(" ");
        txt_medico_Acargo.setEnabled(false);

        table_Pacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NSS", "Nombre", "Apellido paterno", "Apellido materno", "Genero", "Fecha de nacimiento"
            }
        ));
        table_Pacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_PacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Pacientes);

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
        jScrollPane3.setViewportView(table_Doctores);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Seleccionar Doctor:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Seleccionar Paciente:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Lista de pacientes ingresados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_medico_Acargo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addComponent(txt_Diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel9)
                                .addGap(50, 50, 50)
                                .addComponent(txt_Cama, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(28, 28, 28)
                                .addComponent(txt_Piso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_fotoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2)
                                .addComponent(jScrollPane3)
                                .addComponent(jLabel1))
                            .addComponent(jLabel4))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_fotoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_medico_Acargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txt_Diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Cama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Piso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
        int idPaciente = this.idPaciente;
        int idDoctor = this.idDoctor;
        String diagnostico = txt_Diagnostico.getText();
        int cama = Integer.valueOf(txt_Cama.getText());
        int piso = Integer.valueOf(txt_Piso.getText());
        char estatus = 'A';
        
        String consulta = "call insertar_ingreso_medicam('"+idPaciente+"', '"+idDoctor+"', '"+diagnostico+"', '"+cama+"', '"+piso+"', '"+estatus+"');";
        
        conexion.agregarDatos(consulta);
        conexion.cargarDatos(table_Ingresos, queryIngresos);
        
        limpiarCampos();
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void table_IngresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_IngresosMouseClicked
        int indice = this.table_Ingresos.rowAtPoint(evt.getPoint());
        
        this.idIngreso = Integer.valueOf(String.valueOf(this.table_Ingresos.getValueAt(indice, 0)));
        this.txt_Nombre.setText(String.valueOf(this.table_Ingresos.getValueAt(indice, 1)));
     //   int indiceCMB = buscarIndiceCMB(String.valueOf(this.table_Ingresos.getValueAt(indice, 2)), this.cmb_Medico);
       // this.cmb_Medico.setSelectedIndex(indiceCMB);
        this.txt_Diagnostico.setText(String.valueOf(this.table_Ingresos.getValueAt(indice, 3)));
        this.txt_Cama.setText(String.valueOf(this.table_Ingresos.getValueAt(indice, 4)));
        this.txt_Piso.setText(String.valueOf(this.table_Ingresos.getValueAt(indice, 5)));
        this.txt_medico_Acargo.setText(String.valueOf(this.table_Ingresos.getValueAt(indice, 6)));
    }//GEN-LAST:event_table_IngresosMouseClicked

    private void btn_DarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DarAltaActionPerformed
        int idIngreso = this.idIngreso;
        
        String consulta = "call insertar_egreso_medicam('"+idIngreso+"');";
        
        conexion.agregarDatos(consulta);
        conexion.cargarDatos(table_Ingresos, queryIngresos);
        
        limpiarCampos();
    }//GEN-LAST:event_btn_DarAltaActionPerformed

    private void table_PacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_PacientesMouseClicked
        int indice = this.table_Pacientes.rowAtPoint(evt.getPoint());
        this.idPaciente = Integer.valueOf(String.valueOf(this.table_Pacientes.getValueAt(indice, 0)));
        this.txt_Nombre.setText(String.valueOf(this.table_Pacientes.getValueAt(indice, 2)));

        this.indiceTabla = indice;
    }//GEN-LAST:event_table_PacientesMouseClicked

    private void table_DoctoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DoctoresMouseClicked
        int indice = this.table_Doctores.rowAtPoint(evt.getPoint());
        this.idDoctor = Integer.valueOf(String.valueOf(this.table_Doctores.getValueAt(indice, 0)));
        this.txt_medico_Acargo.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 1)));

        this.indiceTabla = indice;
    }//GEN-LAST:event_table_DoctoresMouseClicked
        
    private String[] capturarDatos(boolean bandera) {
        String[] datos = new String[11];

        if("".equals(txt_Nombre.getText()) ||
            "".equals(txt_Diagnostico.getText()) || "".equals(txt_Cama.getText()) || "".equals(txt_Piso.getText()) ||
               "".equals(txt_medico_Acargo.getText())){

           JOptionPane.showMessageDialog(rootPane, "Hay campos vacios", "Error", 1);
        }
        else {
           datos[0] = this.txt_Nombre.getText();
           datos[2] = this.txt_Diagnostico.getText();
           datos[3] = this.txt_Cama.getText();
           datos[4] = this.txt_Piso.getText();
           datos[5] = this.txt_medico_Acargo.getText();
           
           
           if(bandera == false)
               datos[7] = "1";
           else
               datos[7] = "0";

           return datos;
        }    
        return null;
    }
    
//    public void rellenarTablaIngresos() {
//        DefaultTableModel modelo = (DefaultTableModel) this.table_Ingresos.getModel();
//        modelo.setRowCount(0);
//        
//        ArrayList<String[]> datos = matriz.getDatosIngresos();
//        
//        int numFilas = datos.size();
//        
//        for (int i = 0; i < numFilas; i++) {
//            String[] fila = datos.get(i);
//            
//            if(fila[10].equals("1"))
//                modelo.addRow(fila);
//        }
//        
//        table_Ingresos.setModel(modelo);
//        table_Ingresos.setBackground(new Color(189, 236, 182));
//    }
//    
//    public int buscarIndiceCMB(String nombre, JComboBox combo) {
//        int cantidad = combo.getItemCount();
//        
//        for(int indice = 0; indice < cantidad; indice++) {
//            if(nombre.equals(combo.getItemAt(indice)))
//                return indice;
//        }
//        
//        return -1;
//    }
    
    private String getFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(fecha);
        
        return fechaFormateada;
    }
    
    private Date setFecha(String fecha) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date fechaEstablecer = sdf.parse(fecha);
        
        return fechaEstablecer;
    }
    
    private void limpiarCampos() {
        txt_Nombre.setText("");
        txt_medico_Acargo.setText("");
        txt_Diagnostico.setText("");
        txt_Cama.setText("");
        txt_Piso.setText("");
        idPaciente = 0;
        idDoctor = 0;
        
        txt_Nombre.grabFocus();
    }
    
    
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
            java.util.logging.Logger.getLogger(frmIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmIngresos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DarAlta;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_fotoIngreso;
    private javax.swing.JTable table_Doctores;
    private javax.swing.JTable table_Ingresos;
    private javax.swing.JTable table_Pacientes;
    private javax.swing.JTextField txt_Cama;
    private javax.swing.JTextField txt_Diagnostico;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Piso;
    private javax.swing.JTextField txt_medico_Acargo;
    // End of variables declaration//GEN-END:variables
}