/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Main.Room;
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
public class ReserchUtilities {
    
    public static List<String> findAllRooms() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alunos_tcc", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(Room.ROOM_FIND_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(resultSet.getString("numero"));
            }

            return result;
        } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro, nenhuma Sala encontrada!");
        }
        return null;
    }
}
