/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Icaro
 */
public class HalfTicket extends Ticket {

    public HalfTicket(Movie movie, Session session, Sale sale) {
        this.movie = movie;
        this.value = 8.00;
        this.session = session;
        this.sale = sale;
    }

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
