/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unip.library.view;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Beatriz
 */
public class FormAPS extends javax.swing.JFrame {

    
    CardLayout cardLayout;
    
    public FormAPS() {
        initComponents();
        Component [] components = this.getContentPane().getComponents();
        for(Component component : components){
            if(component instanceof JButton){
                ((JButton) component).setUI(new BasicButtonUI());
                ((JButton) component).setFocusPainted(false);
            }
        }
        
        cardLayout = (CardLayout)(pnl_Cards.getLayout());
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
        pnl_Menu = new javax.swing.JPanel();
        btn_Books = new javax.swing.JButton();
        btn_Authors = new javax.swing.JButton();
        btn_Publishers = new javax.swing.JButton();
        label_Title = new javax.swing.JLabel();
        label_Exit = new javax.swing.JLabel();
        pnl_Cards = new javax.swing.JPanel();
        pnl_Authors = new javax.swing.JPanel();
        pnl_Publishers = new javax.swing.JPanel();
        pnl_Books = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnl_Menu.setBackground(new java.awt.Color(51, 51, 51));

        btn_Books.setBackground(new java.awt.Color(68, 68, 68));
        btn_Books.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Books.setForeground(new java.awt.Color(230, 230, 230));
        btn_Books.setText("Books");
        btn_Books.setBorder(null);
        btn_Books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BooksActionPerformed(evt);
            }
        });

        btn_Authors.setBackground(new java.awt.Color(68, 68, 68));
        btn_Authors.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Authors.setForeground(new java.awt.Color(230, 230, 230));
        btn_Authors.setText("Authors");
        btn_Authors.setBorder(null);
        btn_Authors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AuthorsActionPerformed(evt);
            }
        });

        btn_Publishers.setBackground(new java.awt.Color(68, 68, 68));
        btn_Publishers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Publishers.setForeground(new java.awt.Color(230, 230, 230));
        btn_Publishers.setText("Publishers");
        btn_Publishers.setBorder(null);
        btn_Publishers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PublishersActionPerformed(evt);
            }
        });

        label_Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_Title.setForeground(new java.awt.Color(230, 230, 230));
        label_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Title.setText("Amazônia");

        label_Exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_Exit.setForeground(new java.awt.Color(255, 255, 255));
        label_Exit.setText("X");
        label_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_ExitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnl_MenuLayout = new javax.swing.GroupLayout(pnl_Menu);
        pnl_Menu.setLayout(pnl_MenuLayout);
        pnl_MenuLayout.setHorizontalGroup(
            pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Books, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Authors, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Publishers, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(label_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_MenuLayout.setVerticalGroup(
            pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_MenuLayout.createSequentialGroup()
                        .addComponent(label_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_MenuLayout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addGroup(pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Publishers, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Authors, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Books, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );

        pnl_Cards.setLayout(new java.awt.CardLayout());

        pnl_Authors.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout pnl_AuthorsLayout = new javax.swing.GroupLayout(pnl_Authors);
        pnl_Authors.setLayout(pnl_AuthorsLayout);
        pnl_AuthorsLayout.setHorizontalGroup(
            pnl_AuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        pnl_AuthorsLayout.setVerticalGroup(
            pnl_AuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        pnl_Cards.add(pnl_Authors, "pnl_Authors");

        pnl_Publishers.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnl_PublishersLayout = new javax.swing.GroupLayout(pnl_Publishers);
        pnl_Publishers.setLayout(pnl_PublishersLayout);
        pnl_PublishersLayout.setHorizontalGroup(
            pnl_PublishersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        pnl_PublishersLayout.setVerticalGroup(
            pnl_PublishersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        pnl_Cards.add(pnl_Publishers, "pnl_Publishers");

        pnl_Books.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout pnl_BooksLayout = new javax.swing.GroupLayout(pnl_Books);
        pnl_Books.setLayout(pnl_BooksLayout);
        pnl_BooksLayout.setHorizontalGroup(
            pnl_BooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        pnl_BooksLayout.setVerticalGroup(
            pnl_BooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        pnl_Cards.add(pnl_Books, "pnl_Books");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_Cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_PublishersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PublishersActionPerformed
        cardLayout.show(pnl_Cards, "pnl_Publishers");
    }//GEN-LAST:event_btn_PublishersActionPerformed

    private void btn_BooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BooksActionPerformed
        cardLayout.show(pnl_Cards, "pnl_Books");
    }//GEN-LAST:event_btn_BooksActionPerformed

    private void btn_AuthorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AuthorsActionPerformed
        cardLayout.show(pnl_Cards, "pnl_Authors");
    }//GEN-LAST:event_btn_AuthorsActionPerformed

    private void label_ExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_ExitMousePressed
        System.exit(0);
    }//GEN-LAST:event_label_ExitMousePressed

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
            java.util.logging.Logger.getLogger(FormAPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAPS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAPS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Authors;
    private javax.swing.JButton btn_Books;
    private javax.swing.JButton btn_Publishers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_Exit;
    private javax.swing.JLabel label_Title;
    private javax.swing.JPanel pnl_Authors;
    private javax.swing.JPanel pnl_Books;
    private javax.swing.JPanel pnl_Cards;
    private javax.swing.JPanel pnl_Menu;
    private javax.swing.JPanel pnl_Publishers;
    // End of variables declaration//GEN-END:variables
}