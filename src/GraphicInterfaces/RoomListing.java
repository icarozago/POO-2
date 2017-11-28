package GraphicInterfaces;

import Main.Room;
import Utilities.ReserchUtilities;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RoomListing extends javax.swing.JFrame {

    /**
     * Cria um novo form RoomListing.
     */
    public RoomListing() {
        initComponents();
        fillTable(ReserchUtilities.findAllRooms());

        radioButtonNao.addActionListener(ae -> radioButtonSim.setSelected(false));

        radioButtonSim.addActionListener(ae -> radioButtonNao.setSelected(false));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonIncluir = new javax.swing.JButton();
        buttonAlterar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSalas = new javax.swing.JTable();
        labelSalas = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        textFieldNumero = new javax.swing.JTextField();
        labelArCondicionado = new javax.swing.JLabel();
        radioButtonSim = new javax.swing.JRadioButton();
        radioButtonNao = new javax.swing.JRadioButton();
        buttonLimparFiltros = new javax.swing.JButton();
        buttonAtualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonIncluir.setText("Incluir");
        buttonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIncluirActionPerformed(evt);
            }
        });

        buttonAlterar.setText("Alterar");
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        tableSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número", "Lotação", "Ar Condicionado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableSalas);

        labelSalas.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        labelSalas.setText("Salas");

        labelNumero.setText("Número: ");

        labelArCondicionado.setText("Ar condicionado:");

        radioButtonSim.setText("Sim");
        radioButtonSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonSimActionPerformed(evt);
            }
        });

        radioButtonNao.setText("Não");

        buttonLimparFiltros.setText("Limpar Filtros");
        buttonLimparFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparFiltrosActionPerformed(evt);
            }
        });

        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(buttonIncluir)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSalas)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelNumero)
                                        .addComponent(labelArCondicionado))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(radioButtonSim)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(radioButtonNao))
                                        .addComponent(textFieldNumero))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonLimparFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero)
                    .addComponent(textFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLimparFiltros))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArCondicionado)
                    .addComponent(radioButtonSim)
                    .addComponent(radioButtonNao)
                    .addComponent(buttonAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIncluir)
                    .addComponent(buttonAlterar)
                    .addComponent(buttonExcluir)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Insere um novo Room.
     * 
     * @param evt 
     *  Evento do botão.
     */
    private void buttonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIncluirActionPerformed
        RoomWindowPanel roomWindowPanel = createRoomWindowPanel(true);
        roomWindowPanel.setVisible(true);
    }//GEN-LAST:event_buttonIncluirActionPerformed

    /**
     * Edita o Room selecionado.
     * 
     * @param evt 
     *  Evento do botão.
     */
    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed
        RoomWindowPanel roomWindowPanel = createRoomWindowPanel(false);
        roomWindowPanel.setVisible(true);
    }//GEN-LAST:event_buttonAlterarActionPerformed

    /**
     * Deleta o Room selecionado.
     * 
     * @param evt
     *  Evento do botão. 
     */
    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        RoomWindowPanel roomWindowPanel = createRoomWindowPanel(false);
        roomWindowPanel.setVisible(true);
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void radioButtonSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonSimActionPerformed

    /**
     * Limpa todos os filtros de RoomListing.
     * 
     * @param evt 
     *  Evento do botão.
     */
    private void buttonLimparFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparFiltrosActionPerformed
        textFieldNumero.setText("");
        radioButtonNao.setSelected(false);
        radioButtonSim.setSelected(false);
    }//GEN-LAST:event_buttonLimparFiltrosActionPerformed

    /**
     * Atualiza a tabela em RoomListing.
     * 
     * @param evt
     *  Evento do botão. 
     */
    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarActionPerformed
        Boolean airConditioning = null;
        Integer number = null;
        
        if (radioButtonNao.isSelected()) {
            airConditioning = false;
        } else if (radioButtonSim.isSelected()) {
            airConditioning = true;
        }

        if (!textFieldNumero.getText().isEmpty()) {
            number = Integer.parseInt(textFieldNumero.getText());
        }

        List<Room> rooms = ReserchUtilities.findRoomsByParams(number, airConditioning);

        fillTable(rooms);
    }//GEN-LAST:event_buttonAtualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RoomListing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomListing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomListing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomListing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomListing().setVisible(true);
            }
        });
    }

    public RoomWindowPanel createRoomWindowPanel(boolean insert) {
        if (insert) {
            return new RoomWindowPanel();
        } else {
            Room room = new Room();
            Integer roomNumber = Integer.parseInt(tableSalas.getValueAt(
                    tableSalas.getSelectedRow(), 0).toString());

            room.setId(ReserchUtilities.findRoomByNumber(roomNumber).getId());
            room.setNumber(roomNumber);
            room.setCapacity(Integer.parseInt(tableSalas.getValueAt(
                    tableSalas.getSelectedRow(), 1).toString()));

            if (tableSalas.getValueAt(tableSalas.getSelectedRow(), 2).toString()
                    .equals("Sim")) {
                room.setAir_conditioning(true);
            } else {
                room.setAir_conditioning(false);
            }

            return new RoomWindowPanel(room);
        }
    }

    /**
     * Preenche a tabela de acordo com a lista de salas recebidas por parâmetro.
     *
     * @param rooms
     *  Lista de salas a serem incluídas na tabela.
     */
    private void fillTable(List<Room> rooms) {

        DefaultTableModel defaultTableModel = (DefaultTableModel) tableSalas.getModel();

        while (tableSalas.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }

        for (Room room : rooms) {

            Object row[] = new Object[3];
            row[0] = room.getNumber();
            row[1] = room.getCapacity();
            if (room.getAir_conditioning()) {
                row[2] = "Sim";
            } else {
                row[2] = "Não";
            }
            defaultTableModel.addRow(row);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlterar;
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonIncluir;
    private javax.swing.JButton buttonLimparFiltros;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelArCondicionado;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelSalas;
    private javax.swing.JRadioButton radioButtonNao;
    private javax.swing.JRadioButton radioButtonSim;
    private javax.swing.JTable tableSalas;
    private javax.swing.JTextField textFieldNumero;
    // End of variables declaration//GEN-END:variables
}
