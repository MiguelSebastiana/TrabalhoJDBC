package model;

import java.sql.Date;

public class Entrega {

    private int id;
    private int pedido_id;
    private int motorista_id;
    private Date data_saida;
    private Date data_entrega;
    private StatusEntrega status;

    public Entrega(int id, int pedido_id, int motorista_id, Date data_saida, Date data_entrega, StatusEntrega status) {
        this.id = id;
        this.pedido_id = pedido_id;
        this.motorista_id = motorista_id;
        this.data_saida = data_saida;
        this.data_entrega = data_entrega;
        this.status = status;
    }

    

    
    
}
