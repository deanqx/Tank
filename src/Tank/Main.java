/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tank;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author dean
 */
public class Main extends javax.swing.JFrame
{
    Tank tank;
    Tank modified_tank;
    ArrayList<Tank> tanks = new ArrayList<>();
    
    private int getIndexOfTank(int number)
    {
        int i = 0;
        for (; i < tanks.size(); i++)
        {
            if (tanks.get(i).getNumber() == number)
            {
                break;
            }
        }
        
        return i;
    }
    
    // @returns True for error
    private boolean save_modified()
    {
        dModify_btnSave.setEnabled(false);
        dModify_btnSaveClose.setEnabled(false);
        
        int new_volumen;
        
        try
        {
            new_volumen = Integer.parseInt(dModify_txtNewVolumen.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(diaNew,
                    "Bitte in 'Volumen' nur ganze Zahlen eintragen");
            
            dModify_btnSave.setEnabled(true);
            dModify_btnSaveClose.setEnabled(true);
            return true;
        }
        
        if (modified_tank.setVolumen(new_volumen))
        {
            JOptionPane.showMessageDialog(diaModify, 
                    "Das Volumen ist größer als das Maximale Volumen");
            
            dModify_btnSave.setEnabled(true);
            dModify_btnSaveClose.setEnabled(true);
            return true;
        }
        
        tanks.set(getIndexOfTank(modified_tank.getNumber()), modified_tank);
        
        dModify_btnSave.setEnabled(true);
        dModify_btnSaveClose.setEnabled(true);
        return false;
    }
    
    private void open_modify_dialog()
    {
        if (cmbNumber.getSelectedItem().equals(cmbNumber.getModel().getElementAt(0)))
        {
            JOptionPane.showMessageDialog(this, "Es ist kein Tank ausgewählt.");
            return;
        }
        
        dModify_txtNumber.setText(Integer.toString(tank.getNumber()));
        dModify_txtContent.setText(txtContent.getText());
        
        int i = 0;
        for (; i < dModify_cmbContent.getModel().getSize(); i++)
        {
            if (dModify_cmbContent.getModel().getElementAt(i).equals(txtContent.getText()))
            {
                break;
            }
        }
        
        dModify_cmbContent.setSelectedIndex(i);
        
        dModify_txtVolumen.setText(txtVolumen.getText());
        dModify_txtNewVolumen.setText(txtVolumen.getText());
        dModify_txtMaxVol.setText(txtMaxVol.getText());
        diaModify.setVisible(true);
    }
    
    private void open_create_dialog()
    {
        dNew_txtNumber.setText("");
        dNew_cmbContent.setSelectedIndex(0);
        dNew_txtVolumen.setText("");
        dNew_txtMaxVol.setText("");
        diaNew.setVisible(true);
    }
    
    private void cancel_diaNew()
    {
        String number_str = dNew_txtNumber.getText();
        String content = dNew_cmbContent.getSelectedItem().toString();
        String volumen_str = dNew_txtVolumen.getText();
        String maxvol_str = dNew_txtMaxVol.getText();
        
        if (number_str.isEmpty() && content.equals(dNew_cmbContent.getItemAt(0))
                && volumen_str.isEmpty() && maxvol_str.isEmpty())
        {
            diaNew.dispose();
            return;
        }
        
        int result = JOptionPane.showConfirmDialog(diaNew,
                "Alle hier eingegeben Werte gehen verloren. Sind Sie sicher?",
                "Warnung", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.YES_OPTION)
        {
            diaNew.dispose();
        }
    }    
    
    private void cancel_diaModify()
    {
        String new_inhalt = dModify_cmbContent.getSelectedItem().toString();
        int new_volumen = Integer.parseInt(dModify_txtNewVolumen.getText());
        
        if (new_inhalt.equals(dModify_txtContent.getText()) 
                && Integer.toString(new_volumen).equals(dModify_txtVolumen.getText()))
        {
            diaModify.dispose();
            return;
        }
        
        int result = JOptionPane.showConfirmDialog(diaNew,
                "Alle hier eingegeben Werte gehen verloren. Sind Sie sicher?",
                "Warnung", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.YES_OPTION)
        {
            diaModify.dispose();
        }
    }

    /**
     * Creates new form Main
     */
    public Main()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        diaNew = new javax.swing.JDialog();
        dNew_lblTitel = new javax.swing.JLabel();
        dNew_btnCreate = new javax.swing.JButton();
        dNew_lblMaxVol = new javax.swing.JLabel();
        dNew_txtVolumen = new javax.swing.JTextField();
        dNew_lblVolumen = new javax.swing.JLabel();
        dNew_lblNumber = new javax.swing.JLabel();
        dNew_lblContent = new javax.swing.JLabel();
        dNew_txtNumber = new javax.swing.JTextField();
        dNew_txtMaxVol = new javax.swing.JTextField();
        dNew_cmbContent = new javax.swing.JComboBox<>();
        dNew_btnCancel = new javax.swing.JButton();
        diaModify = new javax.swing.JDialog();
        dModify_lblTitel = new javax.swing.JLabel();
        dModify_btnSave = new javax.swing.JButton();
        dModify_lblMaxVol = new javax.swing.JLabel();
        dModify_txtVolumen = new javax.swing.JTextField();
        dModify_lblVolumen = new javax.swing.JLabel();
        dModify_lblNumber = new javax.swing.JLabel();
        dModify_lblContent = new javax.swing.JLabel();
        dModify_txtNumber = new javax.swing.JTextField();
        dModify_txtMaxVol = new javax.swing.JTextField();
        dModify_btnCancel = new javax.swing.JButton();
        dModify_btnSaveClose = new javax.swing.JButton();
        dModify_cmbContent = new javax.swing.JComboBox<>();
        dModify_txtContent = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dModify_txtNewVolumen = new javax.swing.JTextField();
        dModify_AddToVolume = new javax.swing.JButton();
        dModify_SubToVolume = new javax.swing.JButton();
        lblTitel = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        lblMaxVol = new javax.swing.JLabel();
        txtVolumen = new javax.swing.JTextField();
        lblVolumen = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        txtContent = new javax.swing.JTextField();
        lblNumber = new javax.swing.JLabel();
        lblContent = new javax.swing.JLabel();
        txtMaxVol = new javax.swing.JTextField();
        btnModify = new javax.swing.JButton();
        cmbNumber = new javax.swing.JComboBox<>();

        diaNew.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        diaNew.setTitle("Tank - Neuen Tank anlegen");
        diaNew.setMinimumSize(new java.awt.Dimension(400, 248));
        diaNew.setResizable(false);
        diaNew.addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                diaNewWindowClosing(evt);
            }
        });

        dNew_lblTitel.setFont(new java.awt.Font("SF Pro Display", 0, 24)); // NOI18N
        dNew_lblTitel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dNew_lblTitel.setText("Neue Tank anlegen");

        dNew_btnCreate.setText("Eintrag erstellen");
        dNew_btnCreate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dNew_btnCreateActionPerformed(evt);
            }
        });

        dNew_lblMaxVol.setText("Maximales Volumen (Liter)");

        dNew_lblVolumen.setText("Volumen (Liter)");

        dNew_lblNumber.setText("Tanknummer");

        dNew_lblContent.setText("Inhalt");

        dNew_txtNumber.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dNew_txtNumberActionPerformed(evt);
            }
        });

        dNew_txtMaxVol.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dNew_txtMaxVolActionPerformed(evt);
            }
        });

        dNew_cmbContent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Benzin", "Diesel" }));

        dNew_btnCancel.setText("Abbrechen");
        dNew_btnCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dNew_btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diaNewLayout = new javax.swing.GroupLayout(diaNew.getContentPane());
        diaNew.getContentPane().setLayout(diaNewLayout);
        diaNewLayout.setHorizontalGroup(
            diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaNewLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(diaNewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dNew_btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dNew_btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dNew_lblTitel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(diaNewLayout.createSequentialGroup()
                        .addComponent(dNew_lblMaxVol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(dNew_txtMaxVol, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(diaNewLayout.createSequentialGroup()
                        .addComponent(dNew_lblVolumen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dNew_txtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaNewLayout.createSequentialGroup()
                        .addGroup(diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dNew_lblNumber)
                            .addComponent(dNew_lblContent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dNew_cmbContent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dNew_txtNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        diaNewLayout.setVerticalGroup(
            diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaNewLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(dNew_lblTitel)
                .addGap(18, 18, 18)
                .addGroup(diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dNew_txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dNew_lblNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dNew_lblContent)
                    .addComponent(dNew_cmbContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dNew_txtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dNew_lblVolumen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dNew_txtMaxVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dNew_lblMaxVol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diaNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dNew_btnCreate)
                    .addComponent(dNew_btnCancel))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        diaModify.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        diaModify.setTitle("Tank - Anpassen der Tankdaten");
        diaModify.setMinimumSize(new java.awt.Dimension(607, 316));
        diaModify.setResizable(false);
        diaModify.addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                diaModifyWindowClosing(evt);
            }
        });

        dModify_lblTitel.setFont(new java.awt.Font("SF Pro Display", 0, 24)); // NOI18N
        dModify_lblTitel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dModify_lblTitel.setText("Anpassen der Tankdaten");

        dModify_btnSave.setText("Speichern");
        dModify_btnSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dModify_btnSaveActionPerformed(evt);
            }
        });

        dModify_lblMaxVol.setText("Maximales Volumen (Liter)");

        dModify_txtVolumen.setEditable(false);
        dModify_txtVolumen.setFocusable(false);
        dModify_txtVolumen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dModify_txtVolumenActionPerformed(evt);
            }
        });

        dModify_lblVolumen.setText("Volumen (Liter)");

        dModify_lblNumber.setText("Tanknummer");

        dModify_lblContent.setText("Inhalt");

        dModify_txtNumber.setEditable(false);
        dModify_txtNumber.setFocusable(false);
        dModify_txtNumber.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dModify_txtNumberActionPerformed(evt);
            }
        });

        dModify_txtMaxVol.setEditable(false);
        dModify_txtMaxVol.setFocusable(false);
        dModify_txtMaxVol.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dModify_txtMaxVolActionPerformed(evt);
            }
        });

        dModify_btnCancel.setText("Abbrechen");
        dModify_btnCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dModify_btnCancelActionPerformed(evt);
            }
        });

        dModify_btnSaveClose.setText("Speichern und Beenden");
        dModify_btnSaveClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dModify_btnSaveCloseActionPerformed(evt);
            }
        });

        dModify_cmbContent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Benzin", "Diesel" }));

        dModify_txtContent.setEditable(false);
        dModify_txtContent.setFocusable(false);

        jLabel1.setText("Neue Werte:");

        dModify_AddToVolume.setText("+");
        dModify_AddToVolume.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dModify_AddToVolumeActionPerformed(evt);
            }
        });

        dModify_SubToVolume.setText("-");
        dModify_SubToVolume.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dModify_SubToVolumeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diaModifyLayout = new javax.swing.GroupLayout(diaModify.getContentPane());
        diaModify.getContentPane().setLayout(diaModifyLayout);
        diaModifyLayout.setHorizontalGroup(
            diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaModifyLayout.createSequentialGroup()
                .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(diaModifyLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dModify_btnSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dModify_btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, diaModifyLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(diaModifyLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dModify_btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(diaModifyLayout.createSequentialGroup()
                                .addComponent(dModify_lblTitel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addGroup(diaModifyLayout.createSequentialGroup()
                                .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dModify_lblMaxVol)
                                    .addComponent(dModify_lblVolumen)
                                    .addComponent(dModify_lblNumber)
                                    .addComponent(dModify_lblContent))
                                .addGap(63, 63, 63)
                                .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dModify_txtVolumen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(dModify_txtNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(dModify_txtMaxVol, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(dModify_txtContent))
                                .addGap(38, 38, 38)
                                .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dModify_cmbContent, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dModify_txtNewVolumen)
                                    .addGroup(diaModifyLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 70, Short.MAX_VALUE))
                                    .addGroup(diaModifyLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(dModify_AddToVolume)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dModify_SubToVolume)))))))
                .addGap(15, 15, 15))
        );
        diaModifyLayout.setVerticalGroup(
            diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaModifyLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(dModify_lblTitel)
                .addGap(18, 18, 18)
                .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dModify_txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dModify_lblNumber)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(diaModifyLayout.createSequentialGroup()
                        .addComponent(dModify_lblContent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dModify_txtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dModify_lblVolumen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dModify_txtMaxVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dModify_lblMaxVol)))
                    .addGroup(diaModifyLayout.createSequentialGroup()
                        .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dModify_cmbContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dModify_txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dModify_txtNewVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(diaModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dModify_AddToVolume)
                            .addComponent(dModify_SubToVolume))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(dModify_btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dModify_btnSaveClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dModify_btnCancel)
                .addGap(21, 21, 21))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tank Verwaltung");

        lblTitel.setFont(new java.awt.Font("SF Pro Display", 0, 24)); // NOI18N
        lblTitel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitel.setText("Tank Verwaltung");

        lblVersion.setText("1.0.0");

        lblMaxVol.setText("Maximales Volumen (Liter)");

        txtVolumen.setEditable(false);
        txtVolumen.setFocusable(false);

        lblVolumen.setText("Volumen (Liter)");

        btnNew.setText("Neuen Tank anlegen");
        btnNew.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNewActionPerformed(evt);
            }
        });

        txtContent.setEditable(false);
        txtContent.setFocusable(false);
        txtContent.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtContentActionPerformed(evt);
            }
        });

        lblNumber.setText("Tanknummer");

        lblContent.setText("Inhalt");

        txtMaxVol.setEditable(false);
        txtMaxVol.setFocusable(false);

        btnModify.setText("Tankdaten Ändern");
        btnModify.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnModifyActionPerformed(evt);
            }
        });

        cmbNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cmbNumber.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVersion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVolumen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMaxVol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaxVol, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblContent)
                                    .addComponent(lblNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContent, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(cmbNumber, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumber)
                    .addComponent(cmbNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContent)
                    .addComponent(txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVolumen)
                    .addComponent(txtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaxVol)
                    .addComponent(txtMaxVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnModify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVersion)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnNewActionPerformed
    {//GEN-HEADEREND:event_btnNewActionPerformed
        if (diaNew.isVisible())
        {
            diaNew.toFront();
            return;
        }
        
        open_create_dialog();
    }//GEN-LAST:event_btnNewActionPerformed

    private void dNew_btnCreateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dNew_btnCreateActionPerformed
    {//GEN-HEADEREND:event_dNew_btnCreateActionPerformed
        String number_str = dNew_txtNumber.getText();
        String content_str = dNew_cmbContent.getSelectedItem().toString();
        String volumen_str = dNew_txtVolumen.getText();
        String maxvol_str = dNew_txtMaxVol.getText();
        
        if (number_str.isEmpty() || content_str.equals(dNew_cmbContent.getItemAt(0))
                || volumen_str.isEmpty() || maxvol_str.isEmpty())
         
        {
            JOptionPane.showMessageDialog(diaNew, "Bitte in allen Feldern Werte eingeben");
            return;
        }
        
        try
        {
            int new_volumen = Integer.parseInt(volumen_str);
            int new_maxvol = Integer.parseInt(maxvol_str);
            
            Tank new_tank = new Tank(Integer.parseInt(number_str), 
                    content_str, new_maxvol);

            if (new_tank.setVolumen(new_volumen))
            {
                JOptionPane.showMessageDialog(diaModify, 
                        "Das Volumen ist größer als das Maximale Volumen");
                return;
            }
            
            ComboBoxModel<String> current_model = cmbNumber.getModel();
            DefaultComboBoxModel<String> new_model = new DefaultComboBoxModel<>();
            
            for (int i = 0; i < current_model.getSize(); i++)
            {
                new_model.addElement(current_model.getElementAt(i));
            }
            
            new_model.addElement(Integer.toString(new_tank.getNumber()) + " | " + new_tank.getContent());
            
            cmbNumber.setModel(new_model);
            tanks.add(new_tank);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(diaNew,
                    "Bitte in 'Kistennummer', 'Volumen' und 'Maximales Volumen'" 
                    + "nur ganze Zahlen eintragen");
            return;
        }
        
        diaNew.dispose();
    }//GEN-LAST:event_dNew_btnCreateActionPerformed

    private void txtContentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtContentActionPerformed
    {//GEN-HEADEREND:event_txtContentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContentActionPerformed

    private void dNew_txtMaxVolActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dNew_txtMaxVolActionPerformed
    {//GEN-HEADEREND:event_dNew_txtMaxVolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dNew_txtMaxVolActionPerformed

    private void diaNewWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_diaNewWindowClosing
    {//GEN-HEADEREND:event_diaNewWindowClosing
        cancel_diaNew();
    }//GEN-LAST:event_diaNewWindowClosing

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnModifyActionPerformed
    {//GEN-HEADEREND:event_btnModifyActionPerformed
        open_modify_dialog();
    }//GEN-LAST:event_btnModifyActionPerformed

    private void dModify_btnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dModify_btnSaveActionPerformed
    {//GEN-HEADEREND:event_dModify_btnSaveActionPerformed
        save_modified();
    }//GEN-LAST:event_dModify_btnSaveActionPerformed

    private void dModify_txtNumberActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dModify_txtNumberActionPerformed
    {//GEN-HEADEREND:event_dModify_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dModify_txtNumberActionPerformed

    private void dModify_txtMaxVolActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dModify_txtMaxVolActionPerformed
    {//GEN-HEADEREND:event_dModify_txtMaxVolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dModify_txtMaxVolActionPerformed

    private void diaModifyWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_diaModifyWindowClosing
    {//GEN-HEADEREND:event_diaModifyWindowClosing
        cancel_diaModify();
    }//GEN-LAST:event_diaModifyWindowClosing

    private void dModify_btnCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dModify_btnCancelActionPerformed
    {//GEN-HEADEREND:event_dModify_btnCancelActionPerformed
        cancel_diaModify();
    }//GEN-LAST:event_dModify_btnCancelActionPerformed

    private void dNew_btnCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dNew_btnCancelActionPerformed
    {//GEN-HEADEREND:event_dNew_btnCancelActionPerformed
        cancel_diaNew();
    }//GEN-LAST:event_dNew_btnCancelActionPerformed

    private void dModify_btnSaveCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dModify_btnSaveCloseActionPerformed
    {//GEN-HEADEREND:event_dModify_btnSaveCloseActionPerformed
        if (!save_modified())
        {
            diaModify.dispose();
        }
    }//GEN-LAST:event_dModify_btnSaveCloseActionPerformed

    private void dModify_txtVolumenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dModify_txtVolumenActionPerformed
    {//GEN-HEADEREND:event_dModify_txtVolumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dModify_txtVolumenActionPerformed

    private void dModify_AddToVolumeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dModify_AddToVolumeActionPerformed
    {//GEN-HEADEREND:event_dModify_AddToVolumeActionPerformed
        int new_volumen;
        
        try
        {
            new_volumen = Integer.parseInt(dModify_txtNewVolumen.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(diaNew,
                    "Bitte in 'Volumen' nur ganze Zahlen eintragen");

            return;
        }
        
        if (modified_tank.setVolumen(new_volumen))
        {
            JOptionPane.showMessageDialog(diaModify, 
                    "Das Volumen ist größer als das Maximale Volumen");

            return;
        }
        
        modified_tank.decrease();
        dModify_txtNewVolumen.setText(Integer.toString(modified_tank.getVolumen()));
    }//GEN-LAST:event_dModify_AddToVolumeActionPerformed

    private void dModify_SubToVolumeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dModify_SubToVolumeActionPerformed
    {//GEN-HEADEREND:event_dModify_SubToVolumeActionPerformed
        int new_volumen;
        
        try
        {
            new_volumen = Integer.parseInt(dModify_txtNewVolumen.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(diaNew,
                    "Bitte in 'Volumen' nur ganze Zahlen eintragen");

            return;
        }
        
        if (modified_tank.setVolumen(new_volumen))
        {
            JOptionPane.showMessageDialog(diaModify, 
                    "Das Volumen ist größer als das Maximale Volumen");

            return;
        }
        
        modified_tank.increase();
        dModify_txtNewVolumen.setText(Integer.toString(modified_tank.getVolumen()));
    }//GEN-LAST:event_dModify_SubToVolumeActionPerformed

    private void dNew_txtNumberActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dNew_txtNumberActionPerformed
    {//GEN-HEADEREND:event_dNew_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dNew_txtNumberActionPerformed

    private void cmbNumberActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbNumberActionPerformed
    {//GEN-HEADEREND:event_cmbNumberActionPerformed
        String number_str = (String) cmbNumber.getSelectedItem();
        
        if (number_str.equals(cmbNumber.getModel().getElementAt(0)))
        {
            txtContent.setText("");
            txtVolumen.setText("");
            txtMaxVol.setText("");
            return;
        }
        
        int number = Integer.parseInt(number_str.split(" | ")[0]);
        
        tank = tanks.get(getIndexOfTank(number));
        
        txtContent.setText(tank.getContent());
        txtVolumen.setText(Integer.toString(tank.getVolumen()));
        txtMaxVol.setText(Integer.toString(tank.getMaxvol()));
    }//GEN-LAST:event_cmbNumberActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnNew;
    private javax.swing.JComboBox<String> cmbNumber;
    private javax.swing.JButton dModify_AddToVolume;
    private javax.swing.JButton dModify_SubToVolume;
    private javax.swing.JButton dModify_btnCancel;
    private javax.swing.JButton dModify_btnSave;
    private javax.swing.JButton dModify_btnSaveClose;
    private javax.swing.JComboBox<String> dModify_cmbContent;
    private javax.swing.JLabel dModify_lblContent;
    private javax.swing.JLabel dModify_lblMaxVol;
    private javax.swing.JLabel dModify_lblNumber;
    private javax.swing.JLabel dModify_lblTitel;
    private javax.swing.JLabel dModify_lblVolumen;
    private javax.swing.JTextField dModify_txtContent;
    private javax.swing.JTextField dModify_txtMaxVol;
    private javax.swing.JTextField dModify_txtNewVolumen;
    private javax.swing.JTextField dModify_txtNumber;
    private javax.swing.JTextField dModify_txtVolumen;
    private javax.swing.JButton dNew_btnCancel;
    private javax.swing.JButton dNew_btnCreate;
    private javax.swing.JComboBox<String> dNew_cmbContent;
    private javax.swing.JLabel dNew_lblContent;
    private javax.swing.JLabel dNew_lblMaxVol;
    private javax.swing.JLabel dNew_lblNumber;
    private javax.swing.JLabel dNew_lblTitel;
    private javax.swing.JLabel dNew_lblVolumen;
    private javax.swing.JTextField dNew_txtMaxVol;
    private javax.swing.JTextField dNew_txtNumber;
    private javax.swing.JTextField dNew_txtVolumen;
    private javax.swing.JDialog diaModify;
    private javax.swing.JDialog diaNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblContent;
    private javax.swing.JLabel lblMaxVol;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JLabel lblVolumen;
    private javax.swing.JTextField txtContent;
    private javax.swing.JTextField txtMaxVol;
    private javax.swing.JTextField txtVolumen;
    // End of variables declaration//GEN-END:variables
}
