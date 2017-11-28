package Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class WholeTicket extends Ticket {
    /**
     * Cria um novo ticket (construtor)
     * @param movie
     * @param session
     * @param sale 
     */
    public WholeTicket (Movie movie, Session session, Sale sale) {
        this.movie = movie;
        this.value = 16.00;
        this.session = session;
        this.sale = sale;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void impressTicket() {
        /**
         * Imprime o ticket na tela
         */
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat hour = new SimpleDateFormat("HH:mm");
        JOptionPane.showMessageDialog(null, ""
                + "Ingresso Entrada Inteira"
                + "\nFilme: " + movie.getName()
                + "\nSala: " + session.getRoom().getNumber()
                + "\nHora Sessão: " + session.getTime()
                + "\nData Venda: " + date.format(sale.getDate())
                + "\nHora Venda: " + hour.format(sale.getDate())
                + "\nValor: R$ 16,00");
    }
}
