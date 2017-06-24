package msg;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;


public class First extends Agent {
	
	AgentSecurityDelegator agentSecurityDelegator;
	
	protected void setup()
	{
		try {
			agentSecurityDelegator = new AgentSecurityDelegator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addBehaviour(new OneShotBehaviour(){
			public void action(){
				
				
				ACLMessage msg=new ACLMessage(ACLMessage.INFORM);
				msg.setContent(agentSecurityDelegator.encrypt("Hi"));
				msg.addReceiver(new AID("second",AID.ISLOCALNAME));
				send(msg);
				
			}
		});	
		
	}

}
