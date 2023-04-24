import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            // Création du serveur
            StockServerImpl server = new StockServerImpl();

            // Enregistrement du serveur auprès de RMI
            Registry registry = LocateRegistry.createRegistry(1089);
            registry.rebind("StockServer", server);
         System.out.print("ajouter client 1, supprimer client 2,ajouter quantity 3,supprimer quantity 4 , afficher modification 5: ");
Scanner scanner = new Scanner(System.in);         
            // Création de deux clients
            ClientImpl client1 = new ClientImpl(server);
            ClientImpl client2 = new ClientImpl(server);
int nbr = scanner.nextInt();
            // Enregistrement des clients auprès du serveur
if(nbr==1){
 System.out.print("ajouter client: ");
            client1.register();
            client2.register();
 System.out.print("le client est ajouter ");
}
            // Modification du stock
if(nbr==3){
 System.out.print("ajouter quantity: ");
            server.addQuantity("Produit 1", 10);
 System.out.print("le quantity est ajouter ");
}
  if(nbr==4){
 System.out.print("supprimer quantity: ");
            server.removeQuantity("Produit 2", 5);
 System.out.print("le quantity est suprimer ");
}
if(nbr==2){
 System.out.print("remove client: ");
            // Désenregistrement des clients auprès du serveur
            client1.unregister();
            client2.unregister();
 System.out.print("le  client est suprimer  ");
}
if(nbr==5){
 System.out.print("afficher les modification  ");

    // Enregistrement des clients auprès du serveur
            client1.register();
            client2.register();

            // Modification du stock
            server.addQuantity("Produit 1", 10);
            server.removeQuantity("Produit 2", 5);

            // Désenregistrement des clients auprès du serveur
            client1.unregister();
            client2.unregister();
}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
