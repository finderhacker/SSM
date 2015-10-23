package jmockit.gw;

import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.SocketChannel;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import mockit.Capturing;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;

public class GuoWeiTest {
	private GuoWei gg = new GuoWei();

	@Test
	@Ignore
	public void mixExpectation(@Mocked final GuoWei gw) {
		new Expectations() {
			{
				onInstance(gw).getAge();
//				gw.getAge();

				result = new Delegate() {
					int i=0;
					
					int a(){

						i++;
						
						if(i%2 == 0){
							return 20;
						}
						else{
							return 10;
						}
						
					}
				};
			}
		};

		System.out.println(gg.getAge() + " " + gg.getName() + " " + gg);
		
		GuoWei te = new GuoWei();
		System.out.println(te.getAge() + " " + te.getName() + " " + te);
		
		System.out.println(gw.getAge() + " " + gw.getName() + " " + gw);
		System.out.println(gw.getAge() + " " + gw.getName() + " " + gw);
		System.out.println(gw.getAge() + " " + gw.getName() + " " + gw);
		System.out.println(gw.getAge() + " " + gw.getName() + " " + gw);
	}
	
	@Test
	public void aa(
			 @Mocked Socket anySocket // will match any new Socket object created during the test
			 , @Mocked GuoWei gw
		) throws Exception{
		

			   // Inside production code:
			   Socket sk = new Socket(); // mocked as "anySocket"
			   SocketChannel ch = sk.getChannel(); // mocked as "cascadedChannel"
			   
			   System.out.println(gw);
			   System.out.println(gw.getUut());
			   System.out.println(gw.getUut());
			   
			   GuoWei g2 = new GuoWei();
			   System.out.println(g2.getUut());
			   System.out.println(g2.getUut());
	}
	
	
	@Test
	public void postErrorMessageToUIForInvalidInputFields(@Mocked final FacesContext jsf)
	{
	   // Set up invalid inputs, somehow.

	   // Code under test which validates input fields from a JSF page, adding
	   // error messages to the JSF context in case of validation failures.
	   FacesContext ctx = FacesContext.getCurrentInstance();

	   ctx.addMessage(null, new FacesMessage("Input xyz is invalid: blah blah..."));

	   // Test code: verify appropriate error message was added to context.
	   new Verifications() {{
	      FacesMessage msg;
	      jsf.addMessage(null, msg = withCapture());
	      Assert.assertTrue(msg.getSummary().contains("blah blah"));
	   }};
	}
}
