package cake.service;

import org.springframework.stereotype.Service;

import cake.entity.Cake;

@Service
public abstract class AbstractCakeService {

	//处理做蛋糕的重复逻辑在父类实现
	public Cake doCake(){
		Cake cake = new Cake();
		cake.setEggs(2);
		cake.setFlour(250);
		cake.setSugar(30);
		//让子类实现不同的蛋糕处理
		addOtherMaterial(cake);
		return cake;
	}
	
	// 不同属性的赋值留给子类实现
    protected abstract void addOtherMaterial(Cake cake);
    
}