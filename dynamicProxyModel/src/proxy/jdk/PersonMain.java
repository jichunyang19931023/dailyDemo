package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class PersonMain {
	
	public static void main(String[] args){
		// 创建一个实例对象，这个对象是被代理的对象
		Person person = new PersonImpl();
		// 创建一个与代理对象相关联的InvocationHandler
		InvocationHandler handler = new PersonHandler(person);
		/*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象
         * 第一个参数 person.getClass().getClassLoader()，使用handler这个类的ClassLoader对象来加载代理对象
         * 第二个参数person.getClass().getInterfaces()，为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 将这个代理对象关联到了上方的 InvocationHandler这个对象上
         */
		Person proxy = (Person)Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), handler);
		//代理执行对应的方法
		proxy.say();
	}
}
