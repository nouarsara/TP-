import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface StockServerInterface extends Remote {
    Map<String, Integer> getStock() throws RemoteException;
    int getQuantity(String product) throws RemoteException;
    void addQuantity(String product, int quantity) throws RemoteException;
    void removeQuantity(String product, int quantity) throws RemoteException;
    void registerClient(ClientInterface client) throws RemoteException;
    void unregisterClient(ClientInterface client) throws RemoteException;
}
