package com.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.app.model.CityModel;
import com.app.model.CountryModel;
import com.app.model.StateModel;
import com.app.util.HibernateUtil;

public class AjaxDao 
{
	public Map<Integer,String> getCountryMap()
	{
		System.out.println("....Enter getCountryMap()....");
		
		Session s=null;
		List<CountryModel> countriesList=null;
		Map<Integer, String> countryMap=new HashMap<Integer, String>();
		
		try 
		{
			s=HibernateUtil.getsSessionFactory().openSession();
			Criteria criteria=s.createCriteria(CountryModel.class);
			countriesList = criteria.list();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		if(!countriesList.isEmpty())
		{
			for(CountryModel countryModel : countriesList)
			{
				countryMap.put(countryModel.getCountryId(), countryModel.getCountryName());
			}
			
		}
		
		System.out.println("....Exit getCountryMap()....");

		return countryMap;
	}
	
	public Map<Integer,String> getStateMap(int countryId)
	{
		System.out.println("....Enter getStateMap()....");

		List<StateModel> stateList=null;
		Map<Integer,String> stateMap=new HashMap<Integer, String>();
		Session s=null;
		
		try 
		{
			s=HibernateUtil.getsSessionFactory().openSession();
			Criteria c=s.createCriteria(StateModel.class);
			c.add(Restrictions.eq("countryId",countryId));
			stateList=c.list();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		if(!stateList.isEmpty())
		{
			for(StateModel stateModel :stateList)
			{
				stateMap.put(stateModel.getStateId(),stateModel.getStateName());
			}
		}
		
		System.out.println("....Exit getStateMap()....");

		return stateMap;
	}
	
	public Map<Integer,String> getCityMap(int stateId)
	{
		System.out.println("....Enter getCityMap()....");
		
		Map<Integer,String> cityMap=new HashMap<Integer, String>();
		List<CityModel> cityList=null;
		Session s=null;
		
		try 
		{
			s=HibernateUtil.getsSessionFactory().openSession();
			Criteria c=s.createCriteria(CityModel.class);
			c.add(Restrictions.eq("stateId", stateId));
			cityList=c.list();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		if(!cityList.isEmpty())
		{
			for(CityModel cityModel :cityList)
			{
				cityMap.put(cityModel.getCityId(), cityModel.getCityName());
			}
		}

		System.out.println("....Exit getCityMap()....");

		return cityMap;
		
	}

}
