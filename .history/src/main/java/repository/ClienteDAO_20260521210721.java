package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {
    
    public void inserirCliente(Cliente cliente){
        String command = """
                INSERT INTO Cliente
                    (nome,
                    cpf_cnpj,
                    endereco,
                    cidade,
                    estado);
                VALUES
                (?,?,?,?,?,?)    
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf_cnpj());
                stmt.setString(3, cliente.getEndereco());
                stmt.setString(4, cliente.getCidade());
                stmt.setString(5, cliente.)
            }
    }
