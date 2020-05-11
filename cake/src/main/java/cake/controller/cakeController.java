package cake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cake.entity.Cake;
import cake.service.AbstractCakeService;

@RestController
public class cakeController {
	
	@Autowired
	private ApplicationContext applicationContext;

	@GetMapping("doCake")
	public Cake doCake(@RequestParam("supplement") String supplement) {
		AbstractCakeService cake = (AbstractCakeService) applicationContext.getBean(supplement + "CakeService");
		return cake.doCake();
	}
}
