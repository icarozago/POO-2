/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interfaces.SerializableInterface;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Icaro
 */
public class Room implements SerializableInterface{
    
    private Integer id;
    
    private int number;
    
    private int capacity;
    
    private boolean airConditioning;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean getAir_conditioning() {
        return airConditioning;
    }

    public void setAir_conditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public static final String ROOM_FIND_QUERY = " select * from sala ";

    private static final String ROOM_INSERT_QUERY = " insert into sala (lotacao, numero, ar_condicionado) values (?, ?, ?) ";
    
    private static final String ROOM_EDIT_QUERY = " update sala set lotacao = ?, numero = ?, ar_condicionado = ? where id = ? ";
    
    private static final String ROOM_DELETE_QUERY = " delete from sala where id = ? ";

    @Override
    public boolean insert(Object object) {
        try {
            Room room = (Room) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement = connection.prepareStatement(ROOM_INSERT_QUERY);
            preparedStatement.setString(1, String.valueOf(room.getCapacity()));
            preparedStatement.setString(2, String.valueOf(room.getNumber()));
            preparedStatement.setString(3, String.valueOf(room.getAir_conditioning()));

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sala cadastrada com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a Sala.");
        }
        return false;
    }

    @Override
    public boolean edit(Object object) {
        try {
            Room room = (Room) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement = connection.prepareStatement(ROOM_EDIT_QUERY);
            preparedStatement.setString(1, String.valueOf(room.getCapacity()));
            preparedStatement.setString(2, String.valueOf(room.getNumber()));
            preparedStatement.setString(3, String.valueOf(room.getAir_conditioning()));
            preparedStatement.setString(4, String.valueOf(room.getId()));

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sala editada com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar a Sala.");
        }
        return false;
    }

    @Override
    public boolean delete(Object object) {
        try {
            Integer id = (Integer) object;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinema", "root", "123456");

            PreparedStatement preparedStatement = connection.prepareStatement(ROOM_DELETE_QUERY);
            preparedStatement.setString(1, String.valueOf(id));

            if (preparedStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sala excluída com Sucesso!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a Sala.");
        }
        return false;
    }
    
}
