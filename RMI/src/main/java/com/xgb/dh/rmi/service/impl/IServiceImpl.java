package com.xgb.dh.rmi.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.xgb.dh.rmi.service.IService;

public class IServiceImpl extends UnicastRemoteObject implements IService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8865597144712490988L;

	public IServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String queryName(String no) throws RemoteException {
		String str = "0";
		if(no != null) {
			if("1".equals(no)) {
				str = "get 1 is ONE";
			}
		}
		return str;
	}

}
