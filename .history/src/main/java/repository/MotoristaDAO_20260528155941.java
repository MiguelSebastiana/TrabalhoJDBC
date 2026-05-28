package repository;

import java.sql.SQLException;

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

                try(Connection conn = Conne)
    }
}
