package com.app.model;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

import com.app.util.HibernateUtil;

public class App 
{
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Native SQL select
		NativeQuery nq=session.createSQLQuery("select * from country_master");
		List<Object[]> list = nq.getResultList();
		for(Object[] obj : list)
		{
			System.out.println(Arrays.toString(obj));
		}
		
		//HQL select
		String query="from CityModel";
		Query q=session.createQuery(query);
		List<CityModel> cityList=q.list();
		for(CityModel cityModel : cityList)
		{
			System.out.println(cityModel.toString());
		}
		
		//Criteria select
		Criteria c=session.createCriteria(StateModel.class);
		List<StateModel> stateList = c.list();
		for(StateModel s : stateList)
		{
			System.out.println(s.toString());
		}
		session.close();
		
		//Criteria select using HibernateUtil class
		Session s=HibernateUtil.getsSessionFactory().openSession();
		Criteria criteria=s.createCriteria(CountryModel.class);
		List<CountryModel> clist = criteria.list();
		for(CountryModel countryModel : clist)
		{
			System.out.println(countryModel.toString());
		}
							
	}

}
