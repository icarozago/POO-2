/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author Icaro
 */
public interface MovieInterface {
    
    /**
     * Select the movies in theater.
     * 
     * @return
     *  Return a list of names of the movies in theater.
     */
    public List<String> getInTheaterMovieNames ();
    
}
