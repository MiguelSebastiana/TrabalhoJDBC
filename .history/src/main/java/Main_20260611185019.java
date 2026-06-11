import java.sql.SQLException;

import model.Cliente;
import repository.ClienteDAO;
import view.MenuInicial;

public class Main {
    public static void main(String[] args) throws SQLException{
        
        try{
        MenuInicial.menu();
        }catch(Exception e){
            System.err.print(e);
        }
    }
}