/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.RollingCoilDAO;
import DAO.RollingCoilDataDAO;
import UIHelper.CustomHeaderRenderer;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.RollingCoilDataModel;
import model.RollingCoilModel;

/**
 *
 * @author User
 */
public class MainForm extends javax.swing.JFrame {
    private boolean ckbThicknessIsChecked = true;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        loadDataCbb();
        setColorHeaderTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbbCoilNo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCoil = new javax.swing.JTable();
        ckbTemperature = new javax.swing.JCheckBox();
        ckbThickness = new javax.swing.JCheckBox();
        btnInquiry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Training Form");
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Coil No:");

        tblCoil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Col No", "Time", "seq", "Temperature", "Thickness"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCoil);

        ckbTemperature.setText("Temperature");
        ckbTemperature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbTemperatureActionPerformed(evt);
            }
        });

        ckbThickness.setText("Thickness");
        ckbThickness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbThicknessActionPerformed(evt);
            }
        });

        btnInquiry.setText("Inquiry");
        btnInquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInquiryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ckbTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ckbThickness, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbbCoilNo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInquiry, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbCoilNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInquiry, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckbTemperature)
                    .addComponent(ckbThickness))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ckbThicknessActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ckbThicknessActionPerformed
        // TODO add your handling code here:
        ckbThicknessIsChecked = true;
        if (ckbThicknessIsChecked) {
            ckbTemperature.setSelected(false);
        }
    }// GEN-LAST:event_ckbThicknessActionPerformed

    private void ckbTemperatureActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ckbTemperatureActionPerformed
        // TODO add your handling code here:
        ckbThicknessIsChecked = false;
        if (ckbThicknessIsChecked == false) {
            ckbThickness.setSelected(false);
        }
    }// GEN-LAST:event_ckbTemperatureActionPerformed

    private void btnInquiryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInquiryActionPerformed
        // TODO add your handling code here:
        loadDataTbl();
    }// GEN-LAST:event_btnInquiryActionPerformed

    public void setColorHeaderTable() {
        CustomHeaderRenderer customHeaderRenderer = new CustomHeaderRenderer();
        customHeaderRenderer.setBackgroundColor(new Color(24, 107, 146));
        customHeaderRenderer.setTextColor(Color.WHITE);
        customHeaderRenderer.setTextFont(new Font("Segoe UI", Font.BOLD, 12));

        tblCoil.getTableHeader().setDefaultRenderer(customHeaderRenderer);
    }

    public boolean isTblEmpty(DefaultTableModel model) {
        return model.getRowCount() == 0;
    }

    public void loadDataTbl() {
        String coilNo = cbbCoilNo.getSelectedItem().toString();
        System.out.println(coilNo);

        // load data to tblCoilData
        RollingCoilDataDAO rollingCoilDataDAO = new RollingCoilDataDAO();
        DefaultTableModel dfTblCoil = (DefaultTableModel) this.tblCoil.getModel();
        dfTblCoil.setRowCount(0);
        // List<CoilDataModel> lstCoilDataModels = coilNo.equals("*") ? coilDataDao.getAllCoilData() : coilDataDao.findByCoilNo(coilNo);

        List<RollingCoilDataModel> lstRollingCoilData = coilNo.equals("*") 
                ? rollingCoilDataDAO.getAllRollingCoilData()
                : rollingCoilDataDAO.findByCoilNo(coilNo);

        for (RollingCoilDataModel rcdm : lstRollingCoilData) {
            Object[] row = new Object[] { rcdm.getCoilNo(), rcdm.getTime(), rcdm.getSeq(), rcdm.getTemperature(), rcdm.getThickness() };
            dfTblCoil.addRow(row);
        }

        System.out.println("total rows: " + dfTblCoil.getRowCount());
    }

    public void loadDataCbb() {
        // load data to cbbCoil
        RollingCoilDAO rcdao = new RollingCoilDAO();
        List<RollingCoilModel> lstRollingCoil = rcdao.getAllRollingCoil();
        DefaultComboBoxModel cbbCoilNo = new DefaultComboBoxModel();
        cbbCoilNo.addElement("*");

        for (RollingCoilModel dataCoil : lstRollingCoil) {
            cbbCoilNo.addElement(dataCoil.getCoilNo());
        }
        this.cbbCoilNo.setModel(cbbCoilNo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInquiry;
    private javax.swing.JComboBox<String> cbbCoilNo;
    private javax.swing.JCheckBox ckbTemperature;
    private javax.swing.JCheckBox ckbThickness;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCoil;
    // End of variables declaration//GEN-END:variables
}
