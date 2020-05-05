package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonHandler implements InvocationHandler{
	// 要代理的真实对象
	private Object obj;

	// 构造方法，给要代理的真实对象赋初值
	public PersonHandler(Object obj) {
		this.obj = obj;
	}
	
	/*
	 *proxy:指代我们所代理的那个真实对象
	 *method:指代的是我们所要调用真实对象的某个方法的Method对象
	 *args:指代的是调用真实对象某个方法时接受的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 在代理真实对象前可以添加一些自己的操作
		System.out.println("Before invoke " + method.getName());
		// 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		Object result = method.invoke(obj, args);
		// 在代理真实对象后我们也可以添加一些自己的操作
		System.out.println("after invoke " + method.getName());
		return result;
	}

}
