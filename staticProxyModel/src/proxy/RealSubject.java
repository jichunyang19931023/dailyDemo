package proxy;

/** 
 * 真正执行任务的类，实现了代理接口。 
 */ 
public class RealSubject implements Subject{

	/**
	 * 执行给定名字的任务。这里打印出任务名，并休眠500ms模拟任务执行了很长时间
	 * @param taskName
	 */
	public void dealTask(String taskName) {
		System.out.println("执行任务：" + taskName);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
