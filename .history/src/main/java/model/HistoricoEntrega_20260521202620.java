package model;

import java.sql.Date;

public class HistoricoEntrega {
    
    private int id;
    private int entrega_id;
    private Date data_evento;
    private String descricao;
    
    public HistoricoEntrega(int id, int entrega_id, Date data_evento, String descricao) {
        this.id = id;
        this.entrega_id = entrega_id;
        this.data_evento = data_evento;
        this.descricao = descricao;
    }

    

    
}
