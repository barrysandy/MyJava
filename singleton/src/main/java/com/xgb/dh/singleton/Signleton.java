package com.xgb.dh.singleton;

/**
 * @name 单例模式-懒汉式。
 * 这段代码简单明了，而且使用了懒加载模式，但是却存在致命的问题。
 * 当有多个线程并行调用 getInstance()的时候，就会创建多个实例。
 * 也就是说在多线程下不能正常工作。
 * @author xgb
 * @version 0.0.1
 * @data 2018-5-21
 */

//public class Signleton {
//	
//	private static Signleton instance = null;
//	
//	//构造方法私有化
//	private Signleton() { }
//	
//	//通过静态公共的方式对外提供获取实例
//	public static Signleton getInstance() {
//		//懒汉式，类加载时不创建实例
//		if(instance == null) {
//			instance = new Signleton();
//		}
//		return instance;
//	}
//}
 

/**
 * @name 单例模式-懒汉式-线程安全。
 * 虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。
 * 因为在任何时候只能有一个线程调用 getInstance()方法。
 * 但是同步操作只需要在第一次调用时才被需要，
 * 即第一次创建单例实例对象时。这就引出了双重检验锁。
 * @author xgb
 * @version 0.0.2
 * @data 2018-5-21
 */
//public class Signleton {
//	private static Signleton instance;
//	private Signleton() {}
//	
//	public static synchronized Signleton getInstacne() {
//		if(instance == null) {
//			instance = new Signleton();
//		}
//		return instance;
//	}
//}



/**
 * @name 单例模式-懒汉式（双重校验锁）- 线程安全。
 * 优化了同步方法，提升获取实例的效率。
 * @author xgb
 * @version 0.0.3
 * @data 2018-5-21
 */
//public class Signleton {
//	//声明volatile保证编译器不进行优化
//	private volatile static Signleton instance;
//	private Signleton() {}
//	
//	public static Signleton getInstacne() {
//		if(instance == null) {
//			synchronized(Signleton.class) {
//				if(instance != null) {
//					instance = new Signleton();
//				}
//			}
//		}
//		return instance;
//	}
//}


/**
 * @name 单例模式-静态内部类。
 * 这种写法仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder是私有的，
 * 除了 getInstance()之外没有办法访问它，因此它是懒汉式的；同时读取实例的时候不会进行同步，
 * 没有性能缺陷；也不依赖 JDK版本。
 * @author xgb
 * @version 0.0.1
 * @data 2018-5-21
 */
public class Signleton {
	private static class SignletonHolder{
		private static final Signleton INSTANCE = new Signleton();
	}
	
	private Signleton() {}
	
	public static final Signleton getInstance() {
		return SignletonHolder.INSTANCE;
	}
}