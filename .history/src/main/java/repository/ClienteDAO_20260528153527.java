package repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Cliente;
import model.Motorista;
import model.Pedido;

public class ClienteDAO {
    
    public Cliente inserirCliente(Cliente cliente) throws SQLException{
        String command = """
                INSERT INTO Cliente
                    (nome,
                    cpf_cnpj,
                    endereco,
                    cidade,
                    estado)
                VALUES
                (?,?,?,?,?)    
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf_cnpj());
                stmt.setString(3, cliente.getEndereco());
                stmt.setString(4, cliente.getCidade());
                stmt.setString(5, cliente.getEstado());
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();

                if(rs.next()){
                    cliente.setId(rs.getInt(1));
                }

            }

            return cliente;
    }

    public Motorista inserirMotorista(Motorista motorista) throws SQLException{
        String command = """
                INSERT INTO Motorista
                    ()
                """;
    }

    public Pedido inserirPedido(Pedido pedido) throws SQLException{
        String command = """
                INSERT INTO Pedido
                    (cliente_id,
                    data_pedido,
                    volume_m3,
                    peso_kg
                    status)
                VALUES
                (?,?,?,?,?)
                """;

                try(Connection conn = ConnectionFactory.getConnection();
                   PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
                        
                    stmt.setInt(1, pedido.getCliente_id());
                    stmt.setDate(2, pedido.getData_pedido());
                    stmt.setDouble(3, pedido.getVolume_m3());
                    stmt.setDouble(4, pedido.getPeso_kg());
                    stmt.setString(5, pedido.getStatus().getDescricao());

                    ResultSet rs = stmt.getGeneratedKeys();

                    if(rs.next()){
                        pedido.setId(rs.getInt(1));
                    }
                }

                return pedido;
    }


}
