import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class StockServerImpl extends UnicastRemoteObject implements StockServerInterface {
    private Map<String, Integer> stock;
    private List<ClientInterface> clients;

    public StockServerImpl() throws RemoteException {
        super();
        stock = new HashMap<String, Integer>();
        clients = new ArrayList<ClientInterface>();
    }

    public Map<String, Integer> getStock() throws RemoteException {
        return stock;
    }

    public int getQuantity(String product) throws RemoteException {
        if (stock.containsKey(product)) {
            return stock.get(product);
        } else {
            return 0;
        }
    }

    public void addQuantity(String product, int quantity) throws RemoteException {
        int currentQuantity = 0;
        if (stock.containsKey(product)) {
            currentQuantity = stock.get(product);
        }
        stock.put(product, currentQuantity + quantity);
        notifyClients(product, currentQuantity, currentQuantity + quantity);
    }

    public void removeQuantity(String product, int quantity) throws RemoteException {
        int currentQuantity = 0;
        if (stock.containsKey(product)) {
            currentQuantity = stock.get(product);
        }
        stock.put(product, currentQuantity - quantity);
        notifyClients(product, currentQuantity, currentQuantity - quantity);
    }

    public void registerClient(ClientInterface client) throws RemoteException {
        clients.add(client);
    }

    public void unregisterClient(ClientInterface client) throws RemoteException {
        clients.remove(client);
    }

    private void notifyClients(String product, int oldQuantity, int newQuantity) throws RemoteException {
        for (ClientInterface client : clients) {
            client.notifyUpdate(product, oldQuantity, newQuantity);
        }
    }
}
