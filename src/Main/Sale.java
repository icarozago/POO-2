/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaces.SerializableInterface;
import Utilities.ReserchUtilities;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Icaro
 */
public class Sale implements SerializableInterface {

    private Integer id;

    private Date date;

    private List<Ticket> tickets;

    private double amount;

    private static final String SALE_INSERT_QUERY = "Insert into venda (valor) values (?)";

    public static final String SALE_FIND_QUERY = "Select * from venda ";

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean insert(Object object) {
        try {
            Sale sale = (Sale) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SALE_INSERT_QUERY);
            preparedStatement.setString(1, String.valueOf(sale.getAmount()));

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Venda cadastrada com Sucesso!");

                Sale updatedSale = ReserchUtilities.findSaleByTime(sale.getDate());

                sale.getTickets().forEach(e -> {
                    e.setSale(updatedSale);
                    e.insertTicket(e);
                    e.impressTicket();
                });

                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a Venda.");
        }
        return false;
    }

    @Override
    public boolean edit(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
