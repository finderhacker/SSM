package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessagePrinter {
	private MessageService messageService ;

	@Autowired
	public MessagePrinter(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	
	public MessageService getMessageService(){
		return messageService ;
	}
	
	public void printMessage(){
		System.out.println(this.messageService.getMessage());
	}
}
