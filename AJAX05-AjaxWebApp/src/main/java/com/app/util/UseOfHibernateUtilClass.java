package com.app.util;

import org.hibernate.SessionFactory;

public class UseOfHibernateUtilClass 
{
	public static void main(String[] args)
	{
		SessionFactory sf1 = HibernateUtil.getsSessionFactory();
		SessionFactory sf2 = HibernateUtil.getsSessionFactory();
		SessionFactory sf3 = HibernateUtil.getsSessionFactory();
		
		System.out.println(sf1.hashCode());
		System.out.println(sf2.hashCode());
		System.out.println(sf3.hashCode());
		
		if (sf1 == sf2 && sf2 == sf3) 
		{
			System.out.println("Three objects point to the same memory location on the heap i.e, to the same object");
        }
  
        else 
        {
            System.out.println("Three objects DO NOT point to the same memory location on the heap");
        }
	}

}
