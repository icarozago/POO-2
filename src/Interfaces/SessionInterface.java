/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Main.Session;
import java.util.List;

/**
 *
 * @author Icaro
 */
public interface SessionInterface {
    
    public void persistSession (Session session);
    
    public List<Session> findAllSessions ();
    
    public List<Session> findSessionByTime (String time);
    
    public List<Session> findSessionByRoom (Integer roomId);
    
}
