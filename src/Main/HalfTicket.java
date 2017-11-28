
package Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class HalfTicket extends Ticket {

    /**
     * Constroi a meia entrada.
     * 
     * @param movie
     *  Filme.
     * @param session
     * @param sale 
     */
    public HalfTicket(Movie movie, Session session, Sale sale) {
        this.movie = movie;
        this.value = 8.00;
        this.session = session;
        this.sale = sale;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    protected void impressTicket() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat hour = new SimpleDateFormat("HH:mm");
        JOptionPane.showMessageDialog(null, ""
                + "Ingresso Meia Entrada"
                + "\nFilme: " + movie.getName()
                + "\nSala: " + session.getRoom().getNumber()
                + "\nHora Sessão: " + session.getTime()
                + "\nData Venda: " + date.format(sale.getDate())
                + "\nHora Venda: " + hour.format(sale.getDate())
                + "\nValor: R$ 8,00");
    }

}
