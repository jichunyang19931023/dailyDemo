package cake.service;

import org.springframework.stereotype.Service;

import cake.entity.Cake;

@Service(value = "TeaCakeService")
public class TeaCakeService extends AbstractCakeService{

	@Override
	protected void addOtherMaterial(Cake cake) {
		cake.setCakeName("抹茶蛋糕");
		cake.setSupplement("抹茶粉");
		System.out.println("当前正在制作好吃的抹茶蛋糕");
	}

}
