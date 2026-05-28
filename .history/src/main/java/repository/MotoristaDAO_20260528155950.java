package repository;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Motorista;

public class MotoristaDAO {

    public MotoristaDAO inserirMotorista(Motorista motorista) throws SQLException{
        String command = """
                INSERT INTO Motorista
                    (nome,
                    cnh,
                    veiculo,
                    cidade_base)
                VALUES
                (?,?,?,?)
                """;

                try(Connection conn = ConnectionFactory.getConnection();
                    Pre)
    }
}
