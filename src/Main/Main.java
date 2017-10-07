/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GraphicInterfaces.MovieWindowPanel;
import GraphicInterfaces.SessionListing;
import GraphicInterfaces.SessionWindowPanel;
import Utilities.ReserchUtilities;

/**
 *
 * @author Icaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MovieWindowPanel a = new MovieWindowPanel(ReserchUtilities.findMovieById(2));
        a.setVisible(true);
    }

}
