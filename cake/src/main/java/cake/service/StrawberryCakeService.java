package cake.service;

import org.springframework.stereotype.Service;

import cake.entity.Cake;

@Service(value = "StrawberryCakeService")
public class StrawberryCakeService extends AbstractCakeService{

	@Override
	protected void addOtherMaterial(Cake cake) {
		cake.setCakeName("草莓蛋糕");
		cake.setSupplement("新鲜草莓");
		System.out.println("当前正在制作好吃的草莓蛋糕");
	}

}
