package UserInterface.Form;

import javax.swing.*;

import DataAcess.HormigaBL;
import DataAcess.DTO.ClasificacionHormigaDTO;
import UserInterface.IAStyle;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelClasificacion  extends JPanel implements ActionListener {
    private Integer id = 0, idMax=0;
    private HormigaBL hormigaBL = null;
    private ClasificacionHormigaDTO hormiga = null;

    public PanelClasificacion() {
        try {
            
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(     e -> btnNuevoClick());
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

    private void loadRow() throws Exception {
        id      = 2;
        hormigaBL      = new HormigaBL();
        hormiga        = hormigaBL.getByIdClasificacion(id);
        
    }

    private void showRow() {
        boolean clasificacionNULL = (hormiga == null);
        txtIdClasificacion.setText((clasificacionNULL) ? " " : hormiga.getIdCategoriaHormiga().toString());
        txtClasificacion.setText((clasificacionNULL) ? " " : hormiga.getClasificacionHormiga());
        txtCrea.setText((clasificacionNULL) ? " " : hormiga.getFechaCrea());
        txtModifica.setText((clasificacionNULL) ? " " : hormiga.getFechaModifica());
        lblTotal.setText(id.toString() + " de " + idMax.toString());
    }

    private void btnNuevoClick() {
        hormiga = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean clasificacionNULL = (hormiga == null);
        // String buttonText = ((JButton) e.getSource()).getText();
        // try {
        //     if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((clasificacionNULL) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
        //         if (clasificacionNULL)
        //             hormiga = new ClasificacionHormigaDTO(0,txtClasificacion.getText());
        //         else
        //             hormiga.setNombre(txtClasificacion.getText());
    
        //         if(!((clasificacionNULL) ? hormigaBL.create(hormiga) : hormigaBL.update(hormiga)))
        //             IAStyle.showMsgError("Error al guardar...!");
    
        //         loadRow();
        //         showRow();
        //         showTable();
        //     }
        // } catch (Exception e) {
        //     IAStyle.showMsgError(e.getMessage());
        // }
    }

    private void btnEliminarClick() {
        try {
            if (IAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!hormigaBL.delete(hormiga.getIdCategoriaHormiga()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if(hormiga == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            id = 1;
        if (e.getSource() == btnRowAnt && (id > 1))
            id--;
        if (e.getSource() == btnRowSig && (id < idMax))
            id++;
        if (e.getSource() == btnRowFin)
            id = idMax;
        try {
            hormiga    = hormigaBL.getByIdClasificacion(id);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Clasificacion", "FechaCrea","Fecha Modifica"};
        Object[][] data = new Object[hormigaBL.getAll().size()][4];
        int index = 0;
        for (ClasificacionHormigaDTO s : hormigaBL.getAll()) {
            data[index][0] = s.getIdCategoriaHormiga();
            data[index][1] = s.getClasificacionHormiga();
            data[index][2] = s.getFechaCrea();
            data[index][3] = s.getFechaModifica();
            
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.BLACK);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strIdClasificacion = table.getModel().getValueAt(row, 0).toString();
                    id = Integer.parseInt(strIdClasificacion);
                    try {
                        hormiga = hormigaBL.getByIdClasificacion(id);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdClasificacion);
                }
            }
        });
    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private PatLabel 
            lblTitulo   = new PatLabel(" CLASIFICACION "),
            lblIdClasificacion   = new PatLabel(" Id Hormiga :      "),
            lblTipo   = new PatLabel(" Tipo : "),
            lblTotal = new PatLabel(" 0 de 0 ");
    private PatTextBox 
            txtIdClasificacion   = new PatTextBox(),
            txtClasificacion   = new PatTextBox(),
            txtCrea = new PatTextBox(),
            txtModifica = new PatTextBox();
    private PatButton 
            btnPageIni  = new PatButton(" |< "),
            btnPageAnt  = new PatButton(" << "),
            btnPageSig  = new PatButton(" >> "),
            btnPageFin  = new PatButton(" >| "),

            btnRowIni   = new PatButton(" |< "),
            btnRowAnt   = new PatButton(" << "),
            btnRowSig   = new PatButton(" >> "),
            btnRowFin   = new PatButton(" >| "),

            btnNuevo    = new PatButton("Nuevo"),
            btnGuardar  = new PatButton("Guardar"),
            btnCancelar = new PatButton("Cancelar"),
            btnEliminar = new PatButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdClasificacion.setEnabled(false);
        txtIdClasificacion.setBorderLine();
        txtClasificacion.setBorderLine();

        pnlBtnPage.setBorder(getBorder());
        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new PatLabel(" Page:( "));
        pnlBtnPage.add(lblTotal); //cambiar
        pnlBtnPage.add(new PatLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotal);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(IAStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdClasificacion, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdClasificacion, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblTipo, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtClasificacion, gbc);

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}