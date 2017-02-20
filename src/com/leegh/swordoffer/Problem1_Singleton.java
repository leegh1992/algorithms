package com.leegh.swordoffer;

/**
 * 
 * @author lee
 * @date 2017年2月20日
 *       参考链接：http://blog.csdn.net/jason0539/article/details/23297037/
 */
public class Problem1_Singleton {

}

/**
 * 1. 饿汉式
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
 * 2. 懒汉式
 */
class Singleton_LanHan{
  private static Singleton_LanHan INSTANCE;
  private Singleton_LanHan(){};

/*  懒汉式线程不安全的
  public static Singleton_LanHan getInstance(){
      if (INSTANCE == null){
          return new Singleton_LanHan();
      }
      return INSTANCE;
  }
*/
  //懒汉式线程安全的：
  public static synchronized Singleton_LanHan getInstance(){
      if (INSTANCE == null){
          return new Singleton_LanHan();
      }
      return INSTANCE;
  }
}
