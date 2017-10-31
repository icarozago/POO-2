/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterfaces;

/**
 *
 * @author Icaro
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setSize(800, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuMoovie = new javax.swing.JMenu();
        menuItemMovie = new javax.swing.JMenuItem();
        menuRoom = new javax.swing.JMenu();
        menuItemRoom = new javax.swing.JMenuItem();
        menuSession = new javax.swing.JMenu();
        menuItemSession = new javax.swing.JMenuItem();
        menuSale = new javax.swing.JMenu();
        menuItemSell = new javax.swing.JMenuItem();
        menuItemSales = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuMoovie.setText("Filme");

        menuItemMovie.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        menuItemMovie.setText("Filme");
        menuItemMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMovieActionPerformed(evt);
            }
        });
        menuMoovie.add(menuItemMovie);

        jMenuBar1.add(menuMoovie);

        menuRoom.setText("Sala");
        menuRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRoomActionPerformed(evt);
            }
        });

        menuItemRoom.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        menuItemRoom.setText("Sala");
        menuItemRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRoomActionPerformed(evt);
            }
        });
        menuRoom.add(menuItemRoom);

        jMenuBar1.add(menuRoom);

        menuSession.setText("Sessão");
        menuSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSessionActionPerformed(evt);
            }
        });

        menuItemSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemSession.setText("Sessão");
        menuItemSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSessionActionPerformed(evt);
            }
        });
        menuSession.add(menuItemSession);

        jMenuBar1.add(menuSession);

        menuSale.setText("Venda");

        menuItemSell.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, 0));
        menuItemSell.setText("Efetuar Venda");
        menuSale.add(menuItemSell);

        menuItemSales.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemSales.setText("Vendas");
        menuItemSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalesActionPerformed(evt);
            }
        });
        menuSale.add(menuItemSales);

        jMenuBar1.add(menuSale);

        menuExit.setText("Sair");
        menuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuExitMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSessionActionPerformed

    }//GEN-LAST:event_menuSessionActionPerformed

    private void menuRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRoomActionPerformed

    }//GEN-LAST:event_menuRoomActionPerformed

    private void menuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_menuExitMouseClicked

    private void menuItemRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRoomActionPerformed
        RoomListing roomListing = new RoomListing();
        roomListing.setVisible(true);
    }//GEN-LAST:event_menuItemRoomActionPerformed

    private void menuItemSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSessionActionPerformed
        SessionListing sessionListing = new SessionListing();
        sessionListing.setVisible(true);
    }//GEN-LAST:event_menuItemSessionActionPerformed

    private void menuItemSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemSalesActionPerformed

    private void menuItemMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMovieActionPerformed
        MovieListing movieListing = new MovieListing();
        movieListing.setVisible(true);
    }//GEN-LAST:event_menuItemMovieActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuExit;
    private javax.swing.JMenuItem menuItemMovie;
    private javax.swing.JMenuItem menuItemRoom;
    private javax.swing.JMenuItem menuItemSales;
    private javax.swing.JMenuItem menuItemSell;
    private javax.swing.JMenuItem menuItemSession;
    private javax.swing.JMenu menuMoovie;
    private javax.swing.JMenu menuRoom;
    private javax.swing.JMenu menuSale;
    private javax.swing.JMenu menuSession;
    // End of variables declaration//GEN-END:variables
}
