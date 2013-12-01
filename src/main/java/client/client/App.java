package client.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.ensimag.api.bank.BankAction;
import com.ensimag.api.bank.BankAction.ACTION;
import com.ensimag.api.bank.BankMessage;
import com.ensimag.api.bank.IBankAction;
import com.ensimag.api.bank.IBankNode;
import com.ensimag.api.message.EnumMessageType;
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
    		            String[] name = registry.list();
    		            for (int i=0; i<name.length;i++)
    		            System.out.println(name[i]);
    		            IBankNode stub = (IBankNode) registry.lookup("exportBankNode1");
    		            
    		            stub.onMessage(new BankMessage(10, 
    		            							   new BankAction(ACTION.ADD_ACCOUNT), 
    		            							   stub.getId(), 
    		            							   stub.getId(), 
    		            							   5, 
    		            							   EnumMessageType.SINGLE_DEST)
    		            			);
    		            
    		            //System.out.println(stub.getId()); // Affiche 1
    		        } catch (Exception e) {
    		            e.printStackTrace();
    		        }
    		
    }
}
