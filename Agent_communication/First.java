package msg;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;


public class First extends Agent {
	
	protected void setup()
	{
		addBehaviour(new OneShotBehaviour(){
			public void action(){
				ACLMessage msg=new ACLMessage(ACLMessage.INFORM);
				msg.setContent("Sent");
				msg.addReceiver(new AID("second",AID.ISLOCALNAME));
				send(msg);
				
			}
		});	
		
	}

}
