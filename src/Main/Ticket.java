package Main;

public abstract class Ticket {
    protected Movie movie;
    
    protected double value;
    
    protected Session session;
    
    protected Sale sale;
    
    protected abstract void impressTicket();
}
