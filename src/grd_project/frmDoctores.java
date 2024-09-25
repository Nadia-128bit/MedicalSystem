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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public final class frmDoctores extends javax.swing.JFrame {
    
    private int indiceTabla;
    
    public int indice = 0;
    Statement ejecutor=null;
    
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
       this.txt_IDDoctor.setText(String.valueOf(this.table_Doctores.getValueAt(indice,0)));
       this.txt_Nombre.setText(String.valueOf(this.table_Doctores.getValueAt(indice,1)));
       this.txt_Especialidad.setText(String.valueOf(this.table_Doctores.getValueAt(indice,2)));
       this.cmb_Area.setSelectedItem(String.valueOf(this.table_Doctores.getValueAt(indice,3)));
       this.txt_Correo.setText(String.valueOf(this.table_Doctores.getValueAt(indice,4)));
       this.txt_Telefono.setText(String.valueOf(this.table_Doctores.getValueAt(indice,5)));
       this.txt_URL.setText(String.valueOf(this.table_Doctores.getValueAt(indice,6)));
       //this.B_editar.setEnabled(true);
       //this.B_eliminar.setEnabled(true);
       this.T_indice.setText(Integer.toString(indice));
    
       //Mostrar la foto el label foto
       String urlImagen = this.txt_URL.getText();
       ImageIcon img = new ImageIcon(urlImagen);
       Icon micono = new ImageIcon(img.getImage().getScaledInstance(this.lbl_fotoDoc.getWidth(),this.lbl_fotoDoc.getHeight(),Image.SCALE_DEFAULT));
       this.lbl_fotoDoc.setIcon(micono);    
    }
    public void desbloquear_textfiles() {
         
        this.txt_IDDoctor.setFocusable(true);
        this.txt_Nombre.setFocusable(true);
        this.txt_Especialidad.setFocusable(true);
        this.cmb_Area.setFocusable(true);
        this.txt_Correo.setFocusable(true);
        this.txt_Telefono.setFocusable(true);
        this.txt_URL.setFocusable(true);
    }
    public void bloquear_textfiles() {
         
        this.txt_IDDoctor.setFocusable(false);
        this.txt_Nombre.setFocusable(false);
        this.txt_Especialidad.setFocusable(false);
        this.cmb_Area.setFocusable(false);
        this.txt_Correo.setFocusable(false);
        this.txt_Telefono.setFocusable(false);
        this.txt_URL.setFocusable(false);  
    }
     public void limpiar_controles() {
         
        this.txt_IDDoctor.setText("");
        this.txt_Nombre.setText("");
        this.txt_Especialidad.setText("");
        this.cmb_Area.setSelectedItem("");
        this.txt_Correo.setText("");
        this.txt_Telefono.setText("");
        this.txt_URL.setText("");
        
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Especialidad = new javax.swing.JTextField();
        txt_IDDoctor = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_URL = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        cmb_Area = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btn_Agregar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_CambiarFoto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Doctores = new javax.swing.JTable();
        lbl_fotoDoc = new javax.swing.JLabel();
        L_conect = new javax.swing.JLabel();
        T_indice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doctores");
        setSize(new java.awt.Dimension(1920, 1080));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ID Doctor:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre(s):");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Correo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Area:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Especialidad:");

        cmb_Area.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Seleccionar area ---", "Anestesiología", "Cardiología", "Cirugía general", "Cuidados intensivos", "Dermatología", "Hematología", "Medicina interna", "Neumología", "Oncología", "Pediatría", "Rehabilitación", "Urgencias" }));

        jPanel1.setBackground(java.awt.Color.lightGray);

        btn_Agregar.setText("Agregar");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        btn_Editar.setText("Editar");
        btn_Editar.setMaximumSize(new java.awt.Dimension(75, 25));
        btn_Editar.setMinimumSize(new java.awt.Dimension(75, 25));
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        btn_CambiarFoto.setText("Cambiar foto");
        btn_CambiarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CambiarFotoActionPerformed(evt);
            }
        });

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

        L_conect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(L_conect, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(T_indice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_IDDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addComponent(lbl_fotoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(74, 74, 74)
                        .addComponent(cmb_Area, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(txt_URL, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(59, 59, 59)
                        .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(btn_CambiarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(47, 47, 47)
                        .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(L_conect, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(T_indice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_IDDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txt_Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_fotoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txt_URL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btn_CambiarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_DoctoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DoctoresMouseClicked
        int indice = this.table_Doctores.rowAtPoint(evt.getPoint());
        this.txt_IDDoctor.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 0)));
        this.txt_Nombre.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 1)));
        this.txt_Especialidad.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 2)));
        this.cmb_Area.setActionCommand(valueOf(this.table_Doctores.getValueAt(indice, 3)));
        this.txt_Correo.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 4)));
        this.txt_Telefono.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 5)));
        this.txt_URL.setText(String.valueOf(this.table_Doctores.getValueAt(indice, 6)));
        
        this.indiceTabla = indice;
         
        String urlImagen = this.txt_URL.getText();
        ImageIcon img = new ImageIcon(urlImagen);
        Icon micono = new ImageIcon(img.getImage().getScaledInstance(this.lbl_fotoDoc.getWidth(),this.lbl_fotoDoc.getHeight(),Image.SCALE_DEFAULT));
        this.lbl_fotoDoc.setIcon(micono);
    }//GEN-LAST:event_table_DoctoresMouseClicked

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
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
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        this.desbloquear_textfiles();
        this.limpiar_controles();
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
//          if(this.btn_Editar.getText()=="Editar")
//             
//       {
//            this.btn_Editar.setText("Guardar");
//            this.desbloquear_textfiles();
//            this.btn_Editar.setEnabled(true);
//            this.btn_Eliminar.setEnabled(false);
//            this.btn_Buscar.setEnabled(false);
//            this.btn_Agregar.setEnabled(false);
//       }
//       else
//       {
//           this.btn_Editar.setText("Editar");
//           this.editar_datos();
//           this.actualizar_tabla();
//           this.bloquear_textfiles();
//          // this.B_editar_gc.setEnabled(true);
//           this.btn_Eliminar.setEnabled(true);
//           this.btn_Buscar.setEnabled(true);
//           this.btn_Agregar.setEnabled(true);
//       }
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
//        this.eliminar_datos();
//        this.actualizar_tabla();
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_CambiarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CambiarFotoActionPerformed
//        String ruta;
//        JFileChooser nfoto = new JFileChooser("\\\\NADIAG//FotosGRD//ciudades");
//        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG,PNG & GIF","jpg,","png","gif");
//        nfoto.setFileFilter(filtrado);
//
//        int respuesta= nfoto.showOpenDialog(this);
//
//        if (respuesta== nfoto.APPROVE_OPTION)
//        {
//            ruta = nfoto.getSelectedFile().getPath();
//            this.txt_URL.setText(ruta);
//            this.doblediagonal();
//            ImageIcon img = new ImageIcon(ruta);
//            Icon micono = new ImageIcon(img.getImage().getScaledInstance(this.lbl_fotoDoc.getWidth(),this.lbl_fotoDoc.getHeight(),Image.SCALE_DEFAULT));
//            this.lbl_fotoDoc.setIcon(micono);
//            //this.T_fogc.setText(ruta);    
//        }
    }//GEN-LAST:event_btn_CambiarFotoActionPerformed

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
    private javax.swing.JLabel L_conect;
    private javax.swing.JTextField T_indice;
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_CambiarFoto;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JComboBox<String> cmb_Area;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField txt_IDDoctor;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_URL;
    // End of variables declaration//GEN-END:variables
}