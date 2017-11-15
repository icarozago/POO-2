package Main;

import Utilities.ReserchUtilities;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class Ticket {
    protected Movie movie;
    
    protected double value;
    
    protected Session session;
    
    protected Sale sale;
    
    protected abstract void impressTicket();

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
    
    public boolean insertTicket(Ticket ticket) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("insert into ingresso (filmeid, sessaoid, valor, vendaid) values (?, ?, ?, ?)");
            preparedStatement.setString(1, ticket.getMovie().getId().toString());
            preparedStatement.setString(2, ticket.getSession().getId().toString());
            preparedStatement.setString(3, String.valueOf(ticket.getValue()));
            preparedStatement.setString(4, ticket.getSale().getId().toString());

            if (preparedStatement.executeUpdate() > 0) {                
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Ingresso.");
        }
        return false;
    }
}
