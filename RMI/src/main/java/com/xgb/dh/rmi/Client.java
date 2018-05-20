package com.xgb.dh.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.xgb.dh.rmi.service.IService;

/**
 * RMI 客户端
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		//注册管理器
		Registry registry = null;
		try {
			//获取服务注册管理器
			registry = LocateRegistry.getRegistry("127.0.0.1",8088);
			
			//列出所有注册的服务
			String[] list = registry.list();
			for(String s : list) {
				System.out.println(s);
			}
			
		}catch(RemoteException e) {
			e.printStackTrace();
		}
		
		try {
			//根据命名获取服务
			IService service = (IService)registry.lookup("vince");
			
			//调用远程方法
			String result = service.queryName("1");
			// 输出调用结果  
			System.out.println("result from remote : " + result);  

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
