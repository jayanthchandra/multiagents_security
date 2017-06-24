package msg;

import javax.swing.JOptionPane;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Second extends Agent {
	
	AgentSecurityDelegator agentSecurityDelegator;
	
	protected void setup(){
		
		try {
			agentSecurityDelegator = new AgentSecurityDelegator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addBehaviour(new CyclicBehaviour(){
			
			public void action(){
				ACLMessage msg=receive();
				if(msg!=null){
					String recv = agentSecurityDelegator.decrypt(msg.getContent());
					JOptionPane.showMessageDialog(null,"Message Received:"+recv);					
				}else block();
				
			}
		});
		
	}

}
