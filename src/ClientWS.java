import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        // la creation d'un client du web service
        BanqueService stubws = new BanqueWS().getBanqueServicePort();
        System.out.println("conversion Euro To DH :");
        System.out.println(stubws.conversionEuroToDH(300));

        Compte cp = stubws.getCompte(2L);
        System.out.println("Information du compte numero 2 :");
        System.out.println("Code : "+cp.getCode());
        System.out.println("Solde : "+cp.getSolde());

        List<Compte> cptes = stubws.listComptes();

        System.out.println("la liste de tout les Comptes");
        cptes.forEach(c->{
            System.out.println("--------------------------------------------");
            System.out.println("Code : "+c.getCode());
            System.out.println("Solde : "+c.getSolde());
        });
    }
}
