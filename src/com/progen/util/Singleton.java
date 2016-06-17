package com.progen.util;

import com.progen.cache.impl.PrimaryCache;

public class Singleton
{
	private static PrimaryCache Instance=null;


	public static PrimaryCache getInstance()
	{
		if(Instance==null)
		{
			Instance=new PrimaryCache();
		}
		return Instance;
	}






}
