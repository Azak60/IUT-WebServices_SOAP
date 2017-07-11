package iutservice.jaxws.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import iutservice.jaxws.beans.Company;

public class CompanyServiceImpl implements CompanyService {
	

	private static Map<Integer,Company> companies = new HashMap<Integer,Company>();
	
	@Override
	public boolean addCompany(String name, String hourOpening, String hourClosing) {
		
		String[] hoursO = hourOpening.split(":");
		
		if(hoursO.length != 2){
			return false;
		} else if (Integer.parseInt(hoursO[0]) <= 0 && Integer.parseInt(hoursO[0]) > 24){
			return false;
		} else if (Integer.parseInt(hoursO[1]) < 0 && Integer.parseInt(hoursO[1]) > 59){
			return false;
		}
		
		String[] hoursC = hourClosing.split(":");
		
		if(hoursC.length != 2){
			return false;
		} else if (Integer.parseInt(hoursC[0]) <= 0 && Integer.parseInt(hoursC[0]) > 24){
			return false;
		} else if (Integer.parseInt(hoursC[1]) < 0 && Integer.parseInt(hoursC[1]) > 59){
			return false;
		}
		
		if (Integer.parseInt(hoursC[0]) < Integer.parseInt(hoursO[0])){
			return false;
		} else if (Integer.parseInt(hoursC[0]) == Integer.parseInt(hoursO[0])){
			if (Integer.parseInt(hoursC[1]) < Integer.parseInt(hoursO[1])){
				return false;
			}
		}
		
		int id = companies.size();
		Company c = new Company(hourClosing, hourOpening, id, name);
		companies.put(c.getId(), c);
		return true;
	}

	@Override
	public boolean deleteCompany(int id) {
		if(companies.get(id) == null){
			return false;
		}
		companies.remove(id);
		return true;
	}

	@Override
	public Company getCompany(int id) {
		Company c = null;
		if (companies.get(id) != null){
			c = companies.get(id);
		}
		return c;
	}
	
	@Override 
	public Company getCompanyByName(String name){
		Set<Integer> ids = companies.keySet();
		Company c = null;
		for(Integer id : ids){
			if (companies.get(id).getName().contains(name)){
			c = companies.get(id);
			}
		}
		return c;
	}

	@Override
	public Company[] getAllCompanies() {
		Set<Integer> ids = companies.keySet();
		if (ids.size() > 0){
			Company[] c = new Company[ids.size()];
			int i=0;
			for(Integer id : ids){
				c[i] = companies.get(id);
				i++;
			}
			return c;
		} else {
			return null;
		}
	}
	
	@Override
	public boolean isOpen(int id){
		Company c = companies.get(id);
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("hh:mm");
	    String date = ft.format(dNow);
	    String[] hoursD = date.split(":");
	    String[] hoursO = c.getHourOpening().split(":");
	    String[] hoursC = c.getHourClosing().split(":");
	    
	    if (Integer.parseInt(hoursO[0]) > Integer.parseInt(hoursD[0])){
	    	return false;
	    } else if (Integer.parseInt(hoursO[0]) == Integer.parseInt(hoursD[0])){
	    	if(Integer.parseInt(hoursO[1]) > Integer.parseInt(hoursD[1])){
	    		return false;
	    	}
	    }
	    
	    if (Integer.parseInt(hoursC[0]) < Integer.parseInt(hoursD[0])){
	    	return false;
	    } else if (Integer.parseInt(hoursC[0]) == Integer.parseInt(hoursD[0])){
	    	if (Integer.parseInt(hoursC[1]) < Integer.parseInt(hoursD[1])){
	    		return false;
	    	}
	    }
		
		return true;
	}

}
