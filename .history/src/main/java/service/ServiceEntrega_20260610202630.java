package service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import model.Entrega;
import model.HistoricoEntrega;
import model.enums.StatusEntrega;
import model.enums.StatusPedido;
import repository.EntregaDAO;
import repository.HistoricoDAO;
import repository.PedidoDAO;

public class ServiceEntrega {

    private EntregaDAO entregaDAO = new EntregaDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private HistoricoEntregaDAO historicoDAO = new HistoricoEntregaDAO();
    
    public Entrega serviceGerarEntrega(int pedidoId, int motoristaId) throws SQLException{

        PedidoDAO pedidoDAO = pedidoDAO.buscarPedidoPorId(motoristaId);

        if(pedido == null){
             throw new IllegalArgumentException("Pedido não localizado");
        }

        if (pedido.getStatus() != StatusPedido.PENDENTE) {
            throw new IllegalArgumentException("O pedido precisa estar PENDENTE para gerar uma entrega");
        }

        Entrega entrega = new Entrega(pedidoId, motoristaId, Date.valueOf(LocalDate.now()), null, StatusEntrega.EM_ROTA);

        entrega = entregaDAO.inserirEntrega(entrega);

        pedidoDAO.atualizarStatusPedido(pedidoId, StatusPedido.ENTREGUE);

        return entrega;
    }

    public void serviceAtualizarStatus(int entregaId, StatusEntrega novoStatus) throws SQLException {

        Entrega entrega = entregaDAO.buscarEntregaPorId(entregaId);

        if(entrega == null) {
            throw new IllegalAccessException("Entrega não localizada");
        }

        Date dataEntrega = (novoStatus == StatusEntrega.ENTREGUE) ? Date.valueOf(LocalDate.now()) : null;

        entregaDAO.atualizarStatus(entregaId, novoStatus, dataEntrega);
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

        try {
            return entregaDAO.listarEntregas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> relatorioAtrasadasCidade() throws SQLException {
        return entregaDAO.relatorioAtrasadasCidade();
    }

    public List<String> relatorioMotoristas() throws SQLException {
        return entregaDAO.relatorioEntregasPorMotorista();
    }

    public List<String> relatorioClientesVolume() throws SQLException {
        return entregaDAO.relatorioVolumePorCliente();
    }

    public List<String> relatorioPendentesEstado() throws SQLException



    
}
