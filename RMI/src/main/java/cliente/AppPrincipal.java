package cliente;

import comum.IServicoRemoto;
import comum.Pessoa;
import comum.Professor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AppPrincipal {
    public static void main(String[] args){
        try {
            IServicoRemoto objPessoa = (IServicoRemoto) Naming.lookup("rmi://localhost:8282/pessoa");
            Professor p1 = new Professor();

            p1.setId(1);
            p1.setNome("Amanda");
            p1.setTelefone("16998302364");
            p1.setCidade("AQA");

            Professor p2 = new Professor();
            p2.setId(2);
            p2.setNome("Lucas");
            p2.setTelefone("16997915111");
            p2.setCidade("SANCA");

            objPessoa.inserir(p1);
            objPessoa.inserir(p2);

            for(Pessoa professor : objPessoa.listarPessoa()){
                System.out.println("ID: " + professor.getId());
                System.out.println("Nome: " + professor.getNome());
                System.out.println("Telefone: " + professor.getTelefone());
                System.out.println("Cidade: " + professor.getCidade());
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (RemoteException e){
            e.printStackTrace();
        } catch (NotBoundException e){
            e.printStackTrace();
        }
    }
}
