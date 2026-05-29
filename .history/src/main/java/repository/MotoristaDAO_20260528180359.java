package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.protocol.Resultset;

import connection.ConnectionFactory;
import model.Motorista;

public class MotoristaDAO {

    public Motorista inserirMotorista(Motorista motorista) throws SQLException{
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
                    PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){

                        stmt.setString(1, motorista.getNome());
                        stmt.setString(2, motorista.getCnh());
                        stmt.setString(3, motorista.getVeiculo());
                        stmt.setString(4, motorista.getCidade_base());

                        stmt.executeUpdate();
                        
                        ResultSet rs = stmt.getGeneratedKeys();

                        if(rs.next()){
                            motorista.setId(rs.getInt(1));
                        }
                    
                    }

        return motorista;
    }

    public Motorista buscarMotoristaPorID(int id) throws SQLException{

        String command = """
                SELECT
                    (id,
                    nome,
                    cnh,
                    veiculo
                    cidade_base)
                VALUES
                (?,?,?,?,?)
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){

                stmt.setInt(1, id);
                stmt.executeQuery();

                ResultSet rs = stmt.executeQuery();

                if(rs.next()){
                    
                }
            }
    }
}
