package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Entrega;
import model.HistoricoEntrega;
import model.Pedido;
import repository.EntregaDAO;
import repository.HistoricoDAO;
import repository.PedidoDAO;

public class ServiceEntrega {

    private EntregaDAO entregaDAO = new EntregaDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private HistoricoEntregaDAO historicoDAO = new HistoricoEntregaDAO();
    
    public Entrega serviceGerarEntrega(int pedidoId, int motoristaId) throws SQLException{

        Pedido pedidoDAO = pedidoDAO.buscarPedidoPorId(motoristaId);



    }

    public static void serviceCancelarEntrega(int id){

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser menor ou igual a 0");
        }
        var entregaDAO = new EntregaDAO();

        try{
            entregaDAO.excluirEntrega(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Entrega> serviceListarEntregas(){

        List<Entrega> entregas = new ArrayList();
        var entregaDAO = new EntregaDAO();

        try{
            entregaDAO.listarEntregas();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return entregas;


    }
}
