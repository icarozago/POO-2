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
    
    public boolean insertRoom (Room room);
    
    public boolean editRoom (Room room);
    
    public boolean deleteRoom (int number);
    
    //public List<Room> findAllRooms ();
    
    public Room findRoomByNumber (Integer number);
    
    public List<Room> findRoomByCapacity (int capacity);
    
}
