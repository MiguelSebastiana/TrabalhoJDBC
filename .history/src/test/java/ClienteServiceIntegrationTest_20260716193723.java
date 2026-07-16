import org.junit.jupiter.api.DisplayName;

import service.ServiceCliente;

@DisplayName("Teste de Integração - Service Cliente")
class ClienteServiceIntegrationTest {
    
    private ServiceCliente clienteService;

    private static final String SQL_CREATE_TABLE = 
            " CREATE TABLE Cliente (" +
            " id INT AUTO_INCREMENT PRIMARY KEY," +
            " nome VARCHAR(150) NOT NULL," +
            " cpf_cnpj VARCHAR(18) NOT NULL UNIQUE,"



}
