import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import connection.ConnectionFactory;
import service.ServiceCliente;

@DisplayName("Teste de Integração - Service Cliente")
class ClienteServiceIntegrationTest {
    
    private ServiceCliente clienteService;

    private static final String SQL_CREATE_TABLE = 
            " CREATE TABLE Cliente (" +
            " id INT AUTO_INCREMENT PRIMARY KEY," +
            " nome VARCHAR(150) NOT NULL," +
            " cpf_cnpj VARCHAR(18) NOT NULL UNIQUE," +
            " endereco VARCHAR(255) NOT NULL," +
            " cidade VARCHAR(100) NOT NULL," +
            "  estado CHAR(2) NOT NULL" +
            " );";

    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS Cliente";

    private static final String SQL_TRUNCATE_TABLE = "TRUNCATE TABLE Cliente";

    @BeforeAll
    static void setupDataBase() throws SQLException {

        try(Connection conn = ConnectionFactory.getConnection())
    } 




}
