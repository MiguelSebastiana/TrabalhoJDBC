import java.sql.SQLException;

import model.Cliente;
import repository.ClienteDAO;
import utils.Ferramentas;
import view.MenuInicial;

public class Main {
    public static void main(String[] args) throws SQLException{
        
        try{
        MenuInicial.menu();
        }catch(Exception e){
            Ferramentas.linha();
            System.err.print("Erro ao iniciar sistema");
            Ferramentas.linha();
        }
    }
}