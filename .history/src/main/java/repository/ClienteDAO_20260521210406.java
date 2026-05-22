package repository;

import model.Cliente;

public class ClienteDAO {
    
    public void inserirCliente(Cliente cliente){
        String command = """
                INSERT INTO Cliente
                    nome,
                    cpf_cnpj,
                    endereco,
                    cidade,
                    estado
                VALUES    
                """;
    }
