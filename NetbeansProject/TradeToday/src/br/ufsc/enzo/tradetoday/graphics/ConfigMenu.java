/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.enzo.tradetoday.graphics;

import br.ufsc.enzo.tradetoday.config.Config;
import br.ufsc.enzo.tradetoday.config.ConfigHandler;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author 18100527
 */
public class ConfigMenu extends javax.swing.JFrame {

    /**
     * Creates new form ConfigMenu
     */
    public ConfigMenu() {
        initComponents();
        opened = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        refreshRate = new javax.swing.JLabel();
        rankingAlgorithm = new javax.swing.JLabel();
        customKey = new javax.swing.JLabel();
        rrComBox = new javax.swing.JComboBox<>();
        raComBox = new javax.swing.JComboBox<>();
        ckTextField = new javax.swing.JFormattedTextField();
        applyBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Configurations");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(30, 30, 30));
        setName("cfgMenu"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(30, 30, 30));

        refreshRate.setBackground(new java.awt.Color(40, 40, 40));
        refreshRate.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        refreshRate.setForeground(new java.awt.Color(200, 200, 200));
        refreshRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refreshRate.setText("RefeshRate");
        refreshRate.setOpaque(true);

        rankingAlgorithm.setBackground(new java.awt.Color(40, 40, 40));
        rankingAlgorithm.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        rankingAlgorithm.setForeground(new java.awt.Color(200, 200, 200));
        rankingAlgorithm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rankingAlgorithm.setText("Ranking Algorithm");
        rankingAlgorithm.setOpaque(true);

        customKey.setBackground(new java.awt.Color(40, 40, 40));
        customKey.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        customKey.setForeground(new java.awt.Color(200, 200, 200));
        customKey.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customKey.setText("Custom Key");
        customKey.setOpaque(true);

        rrComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        raComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ckTextField.setColumns(16);
        ckTextField.setDocument(new JTextFieldLimit(16));

        applyBtn.setText("Apply");
        applyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rankingAlgorithm, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(refreshRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rrComBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(raComBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ckTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rrComBox)
                    .addComponent(refreshRate, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(raComBox)
                    .addComponent(rankingAlgorithm, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customKey, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(ckTextField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(applyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBtnActionPerformed
        // TODO add your handling code here:
        String rr = Config.getRefreshTimes()[rrComBox.getSelectedIndex()];
        String ra = Config.getRankingAlgorithms()[raComBox.getSelectedIndex()];
        String ck = ckTextField.getText();
        if(ck.length() < 16){
            JOptionPane.showMessageDialog(null, "Invalid Custom Key!", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        ConfigHandler.setCustomKey(ck);
        ConfigHandler.setRankingAlgorithm(ra);
        ConfigHandler.setRefreshRate(rr);
        closeConfigMenu();
    }//GEN-LAST:event_applyBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        Config cfg = ConfigHandler.getConfig();
        String ck = cfg.getCustomKey();
        String ra = cfg.getRankingAlgorithm();
        String rr = cfg.getRefreshRate();
        ConfigHandler.setCustomKey(ck);
        ConfigHandler.setRankingAlgorithm(ra);
        ConfigHandler.setRefreshRate(rr);
        closeConfigMenu();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void closeConfigMenu() {
        opened = false;
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JFormattedTextField ckTextField;
    private javax.swing.JLabel customKey;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> raComBox;
    private javax.swing.JLabel rankingAlgorithm;
    private javax.swing.JLabel refreshRate;
    private javax.swing.JComboBox<String> rrComBox;
    // End of variables declaration//GEN-END:variables

    
    //Custom private classes
    private class JTextFieldLimit extends PlainDocument {
        private int limit;
        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }

        public void insertString(int offset, String str, AttributeSet attr) 
                throws BadLocationException {
            if (str == null)
              return;

            if ((getLength() + str.length()) <= limit) {
              super.insertString(offset, str, attr);
            }
        }
    }
    
    private boolean opened;
    
    boolean isOpened(){
        return opened;
    }
}
