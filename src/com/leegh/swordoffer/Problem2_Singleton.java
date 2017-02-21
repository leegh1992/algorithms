package com.leegh.swordoffer;

/**
 * 
 * @author lee
 * @date 2017年2月20日
 *       参考链接：http://blog.csdn.net/jason0539/article/details/23297037/
 */
public class Problem2_Singleton {

}

/**
 * 1. 饿汉式，类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了
 */
class Singleton_EHan {
	// 类加载时就初始化
	private static final Singleton_EHan INSTANCE = new Singleton_EHan();

	private Singleton_EHan() {
	}; // 保证不被其他类new出来

	public static Singleton_EHan getInstance() {
		return INSTANCE;
	}
}

/**
 * 2. 懒汉式，只有当调用getInstance的时候，才回去初始化这个单例。
 */
class Singleton_LanHan {
	private static Singleton_LanHan INSTANCE;

	private Singleton_LanHan() {
	};

	// 懒汉式线程不安全的
	/*public static Singleton_LanHan getInstance() {
		if (INSTANCE == null) {
			return new Singleton_LanHan();
		}
		return INSTANCE;
	}
*/
	// 懒汉式线程安全的：
	public static synchronized Singleton_LanHan getInstance() {
		if (INSTANCE == null) {
			return new Singleton_LanHan();
		}
		return INSTANCE;
	}
}

/**
 * 3、静态内部类
 */
class Singleton_StaticInnerClass {
	private static class SingletonHolder {
		private static final Singleton_StaticInnerClass INSTANCE = new Singleton_StaticInnerClass();
	}

	private Singleton_StaticInnerClass() {
	}

	public static Singleton_StaticInnerClass getInstance() {
		return SingletonHolder.INSTANCE;
	}
}


/**
 * 4、双重检验锁模式
 */
class Singleton_DoubleCheck{

  private volatile static Singleton_DoubleCheck INSTANCE; //volatile可以使instance变量不会在多线程中存在副本，直接从内存中读
          //即：volatile的赋值操作后面会有个“内存屏障”，防止读操作被JVM重排序到内存屏障之前。
  private Singleton_DoubleCheck(){}

  public static Singleton_DoubleCheck getInstance(){
      if (INSTANCE == null){
          synchronized (Singleton_DoubleCheck.class){
              if (INSTANCE == null){
                  return new Singleton_DoubleCheck();
              }
          }
      }
      return INSTANCE;
  }

}