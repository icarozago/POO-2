/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo2;

/**
 *
 * @author Icaro
 */
public class Room {
    
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
    
}
