package proxy;

public class ClientMain {
	public static void main(String[] args){
		Subject proxy = SubjectStaticFactory.getInstance();
		proxy.dealTask("任务1");
	}
}
