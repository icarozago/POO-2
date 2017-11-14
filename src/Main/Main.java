/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GraphicInterfaces.MovieListing;
import GraphicInterfaces.SaleWindowPanel;

/**
 *
 * @author Icaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //SessionListing b = new SessionListing();
        //b.setVisible(true);
        
        MovieListing a = new MovieListing();
        //a.setVisible(true);
        
        //RoomListing c = new RoomListing();
        //c.setVisible(true);
        
        SaleWindowPanel d = new SaleWindowPanel();
        d.setVisible(true);
    }

}
