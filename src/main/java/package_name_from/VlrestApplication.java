package package_name_from;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import package_name_from.model.Client;
import package_name_from.service.ClientService;
import package_name_from.service.ClientServiceImpl;

@SpringBootApplication
public class VlrestApplication {

	@Autowired
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(VlrestApplication.class, args);

//		System.out.println("===================here's ths beans:============");
//		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
//		for(String beanName : allBeanNames) {
//			System.out.println(beanName);
//		}

		ClientServiceImpl clientService = (ClientServiceImpl)applicationContext.getBean("clientServiceImpl");
		clientService.create(new Client("main aa", "main bb", "main pass 01"));

		ClientService clientService02 = applicationContext.getBean(ClientService.class);
		clientService.create(new Client("service 02", "service 02", "srv main pass 02"));

		clientService.create(new Client("s====", "====]==", "srv ======= pass 02"));
		clientService.create(new Client("---------", "------ 02", "------- main pass 02"));
		clientService.create(new Client("+++++", "++++++", "+++++++ main pass 02"));

		int a  = 2222;


	}

}
