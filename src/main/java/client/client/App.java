package client.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.ensimag.api.node.INode;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	 try {
    		            Registry registry = LocateRegistry.getRegistry(10000);
    		            INode stub = (INode) registry.lookup("getId");
    		            System.out.println(stub.getId()); // Affiche 3
    		        } catch (Exception e) {
    		            e.printStackTrace();
    		        }
    			System.out.println("coucou");
    }
}
