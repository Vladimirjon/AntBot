package UserInterface.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DataAcess.HormigaBL;
import DataAcess.DTO.ClasificacionHormigaDTO;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;

public class ClasificacionPanel extends JPanel implements ActionListener{
    private Integer idClasificacion, idMaxClasificacion;
    private HormigaBL  hormigaBL  = null;
    private ClasificacionHormigaDTO   clasificacion  = null;

    public ClasificacionPanel() throws Exception{
        setGridBagLayout();
        loadData();
        showData();
        showTable();

        btnIni.addActionListener(this);
        btnAnt.addActionListener(this);
        btnSig.addActionListener(this);
        btnFin.addActionListener(this);
        btnGuardar.addActionListener(this);

        // Otra forma de poner escuchadores
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   btnNuevoClick(e);   }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   try {
                btnEliminarClick(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }   
            }
        });
    }
    
    private void loadData() throws Exception {
        idClasificacion      = 1;
        hormigaBL      = new HormigaBL();
        clasificacion        = hormigaBL.getByIdClasificacion(idClasificacion);
        //idMaxClasificacion   = hormigaBL.getMaxIdSoldado();
    }
    private void showData() {
        boolean clasificacionNULL = (clasificacion == null);
        txtIdSoldado.setText((clasificacionNULL) ? " " : clasificacion.getIdCategoriaHormiga().toString());            
        // txtNombre.setText((clasificacionNULL) ? " " : clasificacion.getNombre());
        //lblTotalReg.setText(idClasificacion.toString() + " de " + idMaxClasificacion.toString());
    }
    private void btnNuevoClick(ActionEvent e) {
        clasificacion = null;
        showData();
    } 
    private void btnEliminarClick(ActionEvent e) throws Exception {
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea Eliminar?", "Eliminar...",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
               
            if(!hormigaBL.delete(clasificacion.getIdCategoriaHormiga()))
                JOptionPane.showMessageDialog(this, "Error al eliminar...!", "ERROR", JOptionPane.OK_OPTION);

            loadData();
            showData();
            showTable();
        }
    }
    private void btnGuardarClick(ActionEvent e) throws  Exception {
        boolean clasificacionNULL = (clasificacion == null);
        if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar?", (clasificacionNULL)?"Agregar...": "Actualizar...", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            // if (clasificacionNULL)
            //     clasificacion = new HormigaBL(txtNombre.getText().toString());
            // else
            //     clasificacion.setNombre(txtNombre.getText().toString());

            // if(!((clasificacionNULL) ? hormigaBL.createSoldado(clasificacion) : hormigaBL.updateSoldado(clasificacion)))
            //     JOptionPane.showMessageDialog(this, "Error al guardar...!", "ERROR", JOptionPane.OK_OPTION);
            
            loadData();
            showData();
            showTable();
        }
    } 
    private void showTable() throws Exception {
        String[] header = {"Id", "Clasificacion", "FechaCrea","Fecha Modifica"};
        Object[][] data = new Object[hormigaBL.getAll().size()][4];  
        int index = 0;
        for(ClasificacionHormigaDTO s : hormigaBL.getAll()) {
            data[index][0] = s.getIdCategoriaHormiga();
            data[index][1] = s.getClasificacionHormiga();
            data[index][2] = s.getFechaCrea();
            data[index][3] = s.getFechaModifica();

            
            index++;
        }
        
        JTable table  = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.black);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        //table.setBorder(border);
        // pnlTabla.setBorder( BorderFactory.createTitledBorder(
        //                     BorderFactory.createEtchedBorder(), " SEXO ", TitledBorder.CENTER, TitledBorder.TOP));
      
        pnlTabla.removeAll();
        pnlTabla.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        pnlTabla.add(scrollPane);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
            @Override
            public void valueChanged(ListSelectionEvent e) {
          
                int col = 0;
                int row = table.getSelectedRow();
                String strIdClasificacion = table.getModel().getValueAt(row, col).toString();

                idClasificacion = Integer.parseInt(strIdClasificacion);
                try {
                    clasificacion    = hormigaBL.getByIdClasificacion(idClasificacion);
                    showData(); 
                } catch (Exception e1) { }  
                System.out.println("Tabla.Selected: " + strIdClasificacion);
            }
        });
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIni)
            idClasificacion  = 1;
        if(e.getSource() == btnAnt  &&  (idClasificacion>1) )
            idClasificacion--;
        if(e.getSource() == btnSig  &&  (idClasificacion<idMaxClasificacion))
            idClasificacion++;
        if(e.getSource() == btnFin)
            idClasificacion = idMaxClasificacion;

        // try {
        //     if(e.getSource() == btnGuardar)
        //         btnGuardarClick(e);
        //     clasificacion    = hormigaBL.getSoldadoById(idClasificacion);  
        //     showData(); 
        // } catch (Exception ex) {}
        // System.out.println(e.getActionCommand());
    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private PatLabel  
            lblTitulo  = new PatLabel(" CLASIFICACION "          ),
            lblIdSoldado  = new PatLabel(" ID :      " ),
            lblNombre  = new PatLabel(" Clasificacion : " ),
            lblTotalReg= new PatLabel("  0 de 0  "    );
    private PatTextBox  
            txtIdSoldado  = new PatTextBox (),
            txtNombre  = new PatTextBox ();
    private PatButton  
            btnIni     = new PatButton(" |< "), 
            btnAnt     = new PatButton(" << "),            
            btnSig     = new PatButton(" >> "),
            btnFin     = new PatButton(" >| ");
    private PatButton
            btnNuevo   = new PatButton("Nuevo"),            
            btnGuardar = new PatButton("Guardar"),
            btnCancelar= new PatButton("Cancelar"),
            btnEliminar= new PatButton("Eliminar");
    private JPanel 
            pnlTabla   = new JPanel(),
            pnlBtnCRUD = new JPanel(new FlowLayout()),
            pnlBtnPage = new JPanel(new FlowLayout());
    private Border  
            line       = new LineBorder(Color.black),
            margin     = new EmptyBorder(5, 5, 5, 5),
            border     = new CompoundBorder(line, margin);
    
/************************
 * Customize : Form
 ************************/ 
    public void setGridBagLayout(){
        //setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        txtIdSoldado.setEnabled(false);
        
        // Panel.Paginacion.Tabla
        pnlBtnPage.add(btnIni);       
        pnlBtnPage.add(btnAnt);  
        pnlBtnPage.add(new PatLabel(" Page: [ "));      
        pnlBtnPage.add(lblTotalReg);        
        pnlBtnPage.add(new PatLabel(" ] "));      
        pnlBtnPage.add(btnSig);
        pnlBtnPage.add(btnFin);

        // Panel.CRUD
        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(border);

        // GridBagConstraints.Separación entre componentes
        gbc.insets=new Insets(5,5,5,5);    
        
        // GridBagConstraints.ponerComponentes
        gbc.gridy = 0;       gbc.gridx=0;  //| fila,  columna
        gbc.gridwidth=3;                   //| celdas a unir
        add(lblTitulo, gbc);               //| agrega el control

        gbc.gridy = 1;       gbc.gridx=0;   
        gbc.gridwidth=1;                     
        add(new JLabel("■ Sección de datos: "), gbc);                 

        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=3;                   //| celdas a unir
        gbc.ipady = 150;                   //| tamaño alto
        gbc.ipadx = 450;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
        pnlTabla.add(new Label("Loading data..."));
        //pnlTabla.setBorder(border);
        add(pnlTabla, gbc);
        
        gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
        gbc.ipadx = 1;
        
        gbc.gridy = 3;       gbc.gridx=0;   
        gbc.gridwidth=3;  
        add(pnlBtnPage, gbc);  

        gbc.gridy = 4;       gbc.gridx=0; 
        gbc.gridwidth=1;    
        add(new JLabel("■ Sección de registro: "), gbc);  

        gbc.gridy = 5;       gbc.gridx=0;     add(lblIdSoldado,  gbc);   
        gbc.gridy = 5;       gbc.gridx=1;     add(txtIdSoldado,  gbc);   

        gbc.gridy = 6;       gbc.gridx=0;     add(lblNombre, gbc);        
        gbc.gridy = 6;       gbc.gridx=1;     add(txtNombre, gbc);
        gbc.gridy = 6;       gbc.gridx=2;     add(new JLabel("*"), gbc);  

        gbc.gridy = 7;       gbc.gridx=0;
        gbc.gridwidth=3;
        gbc.insets    = new Insets(30,0,0,0); 
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
        
        //  gbc.gridy=8;     gbc.gridx=2;
        //  add(b5,gbc);
        
        //  gbc.gridy=9;     gbc.gridx=2;
        //  add(b6,gbc);

        //  gbc.gridy=7;        gbc.gridx=0;
        //  gbc.gridwidth=2;
        //  gbc.gridheight=2;
        //  gbc.fill=GridBagConstraints.BOTH;
        //  add(b4,gbc);
    }

}
