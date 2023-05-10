package com.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements Cloneable 
{
	private static SessionFactory sf=null;
	
	private HibernateUtil()
	{
		
	}
	
	public static SessionFactory getsSessionFactory()
	{
		System.out.println("....Enter getsSessionFactory().... ");

		if(sf==null)
		{
			System.out.println("At first Session Factory is Null...");
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			synchronized (cfg) 
			{
				if(sf==null)
				{
					sf= cfg.buildSessionFactory();
				}
			}
		}
		System.out.println("....Exit getsSessionFactory().... ");

		return sf;
	}
}
