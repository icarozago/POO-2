
package Main;

import Interfaces.SerializableInterface;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Session implements SerializableInterface {

    private Integer id;

    private Room room;

    private String time;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Query geral de seleção das sessoes
     */
    public static final String SESSION_FIND_QUERY = " select * from sessao ";

     /**
     * Query para insercao a sesssao
     */
    private static final String SESSION_INSERT_QUERY = " insert into sessao (hora_sessao, salaId) values (?, ?)";
    /**
     * Query para atualizacao a sesssao
     */
    private static final String SESSION_EDIT_QUERY = " update sessao set hora_sessao = ?, salaId = ? where id = ?";
    /**
     * Query para deletar a sesssao
     */
    private static final String SESSION_DELETE_QUERY = " delete from sessao where id = ?";

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean insert(Object object) {
        try {
            Session session = (Session) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SESSION_INSERT_QUERY);
            preparedStatement.setString(1, session.getTime());
            preparedStatement.setString(2, String.valueOf(session.getRoom().getId()));

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sessão cadastrada com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a Sessão.");
        }
        return false;
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public boolean edit(Object object) {
        try {
            Session session = (Session) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SESSION_EDIT_QUERY);
            preparedStatement.setString(1, session.getTime());
            preparedStatement.setString(2, String.valueOf(session.getRoom().getId()));
            preparedStatement.setString(3, session.getId().toString());

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sessão editada com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar a Sessão.");
        }
        return false;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean delete(Object object) {
        try {
            Integer sessionId = (Integer) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SESSION_DELETE_QUERY);
            preparedStatement.setString(1, sessionId.toString());

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sessão excluída com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a Sessão.");
        }
        return false;
    }

}
