package service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import model.Entrega;
import model.HistoricoEntrega;
import model.Pedido;
import model.enums.StatusEntrega;
import model.enums.StatusPedido;
import repository.EntregaDAO;
import repository.HistoricoDAO;
import repository.PedidoDAO;

public class ServiceEntrega {

    private static EntregaDAO entregaDAO = new EntregaDAO();
    private static PedidoDAO pedidoDAO = new PedidoDAO();
    private HistoricoDAO historicoDAO = new HistoricoDAO();
    
    public Entrega serviceGerarEntrega(int pedidoId, int motoristaId) throws SQLException{

        Pedido pedido = pedidoDAO.buscarPedidoPorId(pedidoId);

        if(pedido == null){
             throw new IllegalArgumentException("Pedido não localizado");
        }

        if (pedido.getStatus() != StatusPedido.PENDENTE) {
            throw new IllegalArgumentException("O pedido precisa estar PENDENTE para gerar uma entrega");
        }

        Entrega entrega = new Entrega(pedidoId, motoristaId, Date.valueOf(LocalDate.now()), null, StatusEntrega.EM_ROTA);
        entrega = entregaDAO.inserirEntrega(entrega);

        return entrega;
    }

    public void serviceAtualizarStatus(int entregaId, StatusEntrega novoStatus) throws SQLException, IllegalAccessException {

        Entrega entrega = entregaDAO.buscarEntregaPorId(entregaId);

        if(entrega == null) {
            throw new IllegalAccessException("Entrega não localizada");
        }

        Date dataEntrega = (novoStatus == StatusEntrega.ENTREGUE) ? Date.valueOf(LocalDate.now()) : null;

        entregaDAO.atualizarStatus(entregaId, novoStatus, dataEntrega);
    }
 
    public void serviceCancelarEntrega(int id){

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser menor ou igual a 0");
        }

        try{
            entregaDAO.excluirEntrega(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Entrega> serviceListarEntregas() throws SQLException{

        List<Entrega> entregas = entregaDAO.listarEntregas();

        try {
            return entregaDAO.listarEntregas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return entregas;
    }

    // public List<String> relatorioAtrasadasCidade() throws SQLException {
    //     return entregaDAO.relatorioAtrasadasCidade();
    // }

    // public List<String> relatorioMotoristas() throws SQLException {
    //     return entregaDAO.relatorioEntregasPorMotorista();
    // }

    // public List<String> relatorioClientesVolume() throws SQLException {
    //     return entregaDAO.relatorioVolumePorCliente();
    // }

    // public List<String> relatorioPendentesEstado() throws SQLException {
    //     return entregaDAO.relatorioPendentesEstado();
    // }
}
