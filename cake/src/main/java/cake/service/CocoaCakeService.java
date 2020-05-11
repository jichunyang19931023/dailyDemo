package cake.service;

import org.springframework.stereotype.Service;

import cake.entity.Cake;

@Service(value = "CocoaCakeService")
public class CocoaCakeService extends AbstractCakeService{

	@Override
	protected void addOtherMaterial(Cake cake) {
		cake.setCakeName("可可蛋糕");
		cake.setSupplement("可可粉");
		System.out.println("当前正在制作好吃的可可蛋糕");
	}

}
