import model.Cliente;
import repository.ClienteDAO;
import view.MenuInicial;

public class Main {
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("Miguel", "12345678910", "Avaí, Rua Antonio Umlauf, num 68 ", "Guaramirim","SC");

        ClienteDAO clienteDAO = new ClienteDAO();

        try
        {
            
        }
        clienteDAO.inserirCliente(cliente);
        
    }
}