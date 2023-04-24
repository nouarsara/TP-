import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    void notifyUpdate(String product, int oldQuantity, int newQuantity) throws RemoteException;
}
