import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {
    private StockServerInterface server;

    public ClientImpl(StockServerInterface server) throws RemoteException {
        super();
        this.server = server;
    }

    public void register() throws RemoteException {
        server.registerClient(this);
    }

    public void unregister() throws RemoteException {
        server.unregisterClient(this);
    }

    public void notifyUpdate(String product, int oldQuantity, int newQuantity) throws RemoteException {
        System.out.println("Le stock de " + product + " a été mis à jour : " + oldQuantity + " -> " + newQuantity);
    }
}
