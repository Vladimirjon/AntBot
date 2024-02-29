package UserInterface.Form;

import javax.swing.*;

import DataAcess.DTO.ClasificacionHormigaDTO;
import DataAcess.HormigaBL;
import UserInterface.IAStyle;
import UserInterface.CustomerControl.JPButton;
import UserInterface.CustomerControl.JPLabel;
import UserInterface.CustomerControl.JPTextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClasificacionPanel  extends JPanel implements ActionListener {
    private Integer idHormiga = 0, idMaxHormiga=0;
    private HormigaBL hormigaBL = null;
    private ClasificacionHormigaDTO clasificacionHormigaDTO = null;

    public ClasificacionPanel() {
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
        idHormiga      = 1;
        hormigaBL      = new HormigaBL();
        clasificacionHormigaDTO        = hormigaBL.getByIdClasificacion(idHormiga);
        // idMaxHormiga   = hormigaBL.getMaxRow();
    }

    private void showRow() {
        boolean clasifiacionNull = (clasificacionHormigaDTO == null);
        txtIdClasificacion.setText((clasifiacionNull) ? " " : clasificacionHormigaDTO.getIdCategoriaHormiga().toString());
        // txtHumedad.setText((clasifiacionNull) ? " " : clasificacionHormigaDTO.getHumedadSuelo().toString());
        // txtIdTipoRiego.setText((clasifiacionNull) ? " " : clasificacionHormigaDTO.getIdTipoRiego().toString());
        // txtFechaCrea.setText((clasifiacionNull) ? " " : clasificacionHormigaDTO.getFechaCrea());
        // txtFechaModifica.setText((clasifiacionNull) ? " " : clasificacionHormigaDTO.getFechaModifica());
        lblTotalReg.setText(idHormiga.toString() + " de " + idMaxHormiga.toString());
    }

    private void btnNuevoClick() {
        clasificacionHormigaDTO = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean clasifiacionNull = (clasificacionHormigaDTO == null);
        // String buttonText = ((JButton) e.getSource()).getText();
        // try {
        //     if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((clasifiacionNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
        //         if (clasifiacionNull)
        //             clasificacionHormigaDTO = new ClasificacionHormigaDTO(txtHumedad.getText());
        //         else
        //             clasificacionHormigaDTO.setHumedadSuelo(txtHumedad.getText());
    
        //         if(!((clasifiacionNull) ? hormigaBL.create(clasificacionHormigaDTO) : hormigaBL.update(clasificacionHormigaDTO)))
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

                if (!hormigaBL.delete(clasificacionHormigaDTO.getIdCategoriaHormiga()))
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
            if(clasificacionHormigaDTO == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idHormiga = 1;
        if (e.getSource() == btnRowAnt && (idHormiga > 1))
            idHormiga--;
        if (e.getSource() == btnRowSig && (idHormiga < idMaxHormiga))
            idHormiga++;
        if (e.getSource() == btnRowFin)
            idHormiga = idMaxHormiga;
        try {
            clasificacionHormigaDTO    = hormigaBL.getByIdClasificacion(idHormiga);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"IdHormiga", "Clasificacion"};
        Object[][] data = new Object[hormigaBL.getAll().size()][1];  
        int index = 0;
        for(ClasificacionHormigaDTO r : hormigaBL.getAll()) {
            data[index][0] = r.getIdCategoriaHormiga();
            // data[index][1] = r.getHumedadSuelo();
            // data[index][2] = r.getIdTipoRiego();
            // data[index][3] = r.getFechaCrea();
            // data[index][4] = r.getFechaModifica();
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.BLACK);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 170));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strIdDato = table.getModel().getValueAt(row, 0).toString();
                    idHormiga = Integer.parseInt(strIdDato);
                    try {
                        clasificacionHormigaDTO = hormigaBL.getByIdClasificacion(idHormiga);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdDato);
                }
            }
        });
    }

    private JPLabel 
            lblTitulo   = new JPLabel("CLASIFICACION"),
            lblHormiga   = new JPLabel(" Num. Hormiga :      "),
            lblHumedad   = new JPLabel(" Clasifiacion : "),
            lblTotalReg = new JPLabel(" 0 de 0 ");
    private JPTextBox 
            txtIdClasificacion   = new JPTextBox();
            // txtIdTipoRiego = new JPTextBox(),
            // txtHumedad   = new JPTextBox(),
            // txtFechaCrea = new  JPTextBox(),
            // txtFechaModifica = new JPTextBox();

    private JPButton 
            btnPageIni  = new JPButton(" |< "),
            btnPageAnt  = new JPButton(" << "),
            btnPageSig  = new JPButton(" >> "),
            btnPageFin  = new JPButton(" >| "),

            btnRowIni   = new JPButton(" |< "),
            btnRowAnt   = new JPButton(" << "),
            btnRowSig   = new JPButton(" >> "),
            btnRowFin   = new JPButton(" >| "),

            btnNuevo    = new JPButton("Nuevo"),
            btnGuardar  = new JPButton("Guardar"),
            btnCancelar = new JPButton("Cancelar"),
            btnEliminar = new JPButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdClasificacion.setEnabled(true);
        txtIdClasificacion.setBorderLine();
        // txtHumedad.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new JPLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new JPLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(IAStyle.createBorderRect());

        gbc.insets = new Insets(1, 1, 1, 1);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
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
        gbc.ipady = 135;
        gbc.ipadx = 435;
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

        gbc.insets = new Insets(1, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblHormiga, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdClasificacion, gbc);

        // gbc.gridy = 6;
        // gbc.gridx = 0;
        // add(lblHumedad, gbc);
        // gbc.gridy = 6;
        // gbc.gridx = 1;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        // // add(txtHumedad, gbc);



        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(2, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}