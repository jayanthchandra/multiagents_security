package msg;

import javax.swing.JOptionPane;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Second extends Agent {
	
	protected void setup(){
		addBehaviour(new CyclicBehaviour(){
			
			public void action(){
				ACLMessage msg=receive();
				if(msg!=null){
					JOptionPane.showMessageDialog(null,"Message Received:"+msg.getContent());					
				}else block();
				
			}
		});
		
	}

}
