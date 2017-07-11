package iutservice.jaxws.service;

import iutservice.jaxws.beans.Company;

public interface CompanyService {

	public boolean addCompany(String name, String hourOpening, String hourClosing);
	
	public boolean deleteCompany(int id);
	
	public Company getCompany(int id);
	
	public Company getCompanyByName(String name);
	
	public Company[] getAllCompanies();
	
	public boolean isOpen(int id);
}

