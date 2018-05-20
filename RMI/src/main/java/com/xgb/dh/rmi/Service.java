package com.xgb.dh.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.xgb.dh.rmi.service.impl.IServiceImpl;

/**
 * RMI 服务端
 * @author Administrator
 *
 */
public class Service {
	
	public static void main(String[] args) {
		//注册管理器
		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry(8088);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		
		try {
			//创建一个服务
			IServiceImpl server = new IServiceImpl();
			//将服务绑定命名
			registry.bind("vince", server);
			System.out.println("bind Server");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
