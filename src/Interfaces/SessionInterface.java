/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Main.Session;

/**
 *
 * @author Icaro
 */
public interface SessionInterface {
    
    public boolean insertSession (Session session);
    
    public boolean editSession (Session session);
    
    public boolean deleteSession (Integer sessionId);
}
