package GraphicInterfaces;

import Main.HalfTicket;
import Main.Movie;
import Main.Sale;
import Main.Session;
import Main.Ticket;
import Main.WholeTicket;
import Utilities.ReserchUtilities;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SaleWindowPanel extends javax.swing.JFrame {

    /**
     * Creates new form SaleWindowPanel
     */
    public SaleWindowPanel() {
        initComponents();
        ReserchUtilities.getInTheaterMoviesNames().forEach((movie) -> comboBoxMovie.addItem(movie));
        comboBoxMovie.addItemListener((ItemEvent ie) -> {
            comboBoxSession.removeAllItems();
            ReserchUtilities.findSessionsByMovie(ReserchUtilities.findMovieByName(
                    comboBoxMovie.getSelectedItem().toString()).getId()).forEach(
                    (session) -> comboBoxSession.addItem(session.getTime()));
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMovie = new javax.swing.JLabel();
        comboBoxMovie = new javax.swing.JComboBox<>();
        labelSession = new javax.swing.JLabel();
        comboBoxSession = new javax.swing.JComboBox<>();
        labelHalfTicket = new javax.swing.JLabel();
        textFieldHalfTicket = new javax.swing.JTextField();
        labelWholeTicket = new javax.swing.JLabel();
        textFieldWholeTicket = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelMovie.setText("Filme:");

        comboBoxMovie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        labelSession.setText("Sessão:");

        comboBoxSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        labelHalfTicket.setText("Ingressos Meia:");

        labelWholeTicket.setText("Ingressos Inteiro:");

        buttonSave.setText("Salvar");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelWholeTicket)
                            .addComponent(labelHalfTicket)
                            .addComponent(labelSession)
                            .addComponent(labelMovie))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxMovie, 0, 276, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxSession, 0, 81, Short.MAX_VALUE)
                                    .addComponent(textFieldHalfTicket)
                                    .addComponent(textFieldWholeTicket))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMovie))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSession)
                    .addComponent(comboBoxSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHalfTicket)
                    .addComponent(textFieldHalfTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWholeTicket)
                    .addComponent(textFieldWholeTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave)
                    .addComponent(buttonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        Sale sale = new Sale();
        sale.setDate(new Date());
        int numberHalfTickets = textFieldHalfTicket.getText().isEmpty() ? 0 
                : Integer.parseInt(textFieldHalfTicket.getText());
        int numberWholeTickets = textFieldWholeTicket.getText().isEmpty() ? 0 
                : Integer.parseInt(textFieldWholeTicket.getText());
        List<Ticket> tickets = new ArrayList<>();

        Movie movie = ReserchUtilities.findMovieByName(
                comboBoxMovie.getSelectedItem().toString());
        
        final Set<Session> sessionSelected
                = movie.getSessions().stream().filter(e -> e.getTime()
                .equals(comboBoxSession.getSelectedItem().toString()))
                        .collect(Collectors.toSet());
        
        for (Session session : sessionSelected) {
            for (int i = 0; i < numberHalfTickets; i++) {
                tickets.add(new HalfTicket(movie, session, sale));
            }
            
            for (int i = 0; i < numberWholeTickets; i++) {
                tickets.add(new WholeTicket(movie, session, sale));
            }
        }
        
        sale.setTickets(tickets);
        
        int amount = 0;
        
        for (Ticket ticket : tickets) {
            amount += ticket.getValue();
        }
        
        sale.setAmount(amount);
        
        if (sale.insert(sale)) {
            this.dispose();
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

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
            java.util.logging.Logger.getLogger(SaleWindowPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleWindowPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleWindowPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleWindowPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleWindowPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<String> comboBoxMovie;
    private javax.swing.JComboBox<String> comboBoxSession;
    private javax.swing.JLabel labelHalfTicket;
    private javax.swing.JLabel labelMovie;
    private javax.swing.JLabel labelSession;
    private javax.swing.JLabel labelWholeTicket;
    private javax.swing.JTextField textFieldHalfTicket;
    private javax.swing.JTextField textFieldWholeTicket;
    // End of variables declaration//GEN-END:variables
}
