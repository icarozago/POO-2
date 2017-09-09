/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Main.Room;
import java.util.List;

/**
 *
 * @author Icaro
 */
public interface RoomInterface {
    
    public void insertRoom (Room room);
    
    public void editRoom (Room room);
    
    public void deleteRoom (int number);
    
    public List<Room> findAllRooms ();
    
    public Room findRoomByNumber (int number);
    
    public List<Room> findRoomByCapacity (int capacity);
    
}
