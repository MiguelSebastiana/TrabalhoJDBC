package repository;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    public Cliente buscarClientePorId(int id) throws SQLException{
        String commnad = """
                SELECT 
                    (id,
                    nome,
                    cpf_cnpj,
                    endereco,
                    cidade,
                    estado)
                FROM Cliente
                WHERE id = ?
                """;
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(commnad)){

                stmt.setInt(1, id);
                stmt.executeUpdate();
                
                ResultSet rs = stmt.executeQuery();

                if (rs.next()){
                    return new Cliente (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                    );
                }
            }

        return null;
    }

    public List<Cliente> listarTodosClientes() throws SQLException{

        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        String commnad = """
                SELECT 
                    id,
                    nome,
                    cpf_cnpj,
                    endereco,
                    cidade,
                    estado
                FROM Cliente
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(commnad)){

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                     cliente = new Cliente (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                    );
                    clientes.add(cliente);
                }
                return clientes;
            }
    }

    public boolean deletarCliente(int id) throws SQLException{
        String command = """
                    DELETE FROM Cliente
                    WHERE id = ?;
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){

                stmt.setInt(1, id);

                int linhasAlteradas = stmt.executeUpdate();

                if(linhasAlteradas > 0){
                    return true;
                }
                return false;
            }
    }

    public boolean possuiPedidos(int idCliente) throws SQLException{

        String command = """
                    SELECT COUNT(*) FROM Pedido
                    WHERE cliente_id = ?;
                """;

                try(Connection conn = )
    }
}
