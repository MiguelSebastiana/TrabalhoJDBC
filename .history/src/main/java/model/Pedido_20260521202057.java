package model;

import java.sql.Date;

public class Pedido {
    
    private int id;
    private int cliente_id;
    private Date data_pedido;
    private double volume_m3;
    private double peso_kg;
    private StatusPedido status;

    public Pedido(int id, int cliente_id, Date data_pedido, double volume_m3, double peso_kg, StatusPedido status) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.status = status;
    }

    
    
}
