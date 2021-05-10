package it.innominata.om;

import java.util.List;

public class CountryCodeAndNameGroupedByContinent {
	private Continent continent;
	private List<CountryCodeAndName> countryCodeAndNames;
	
	public Continent getContinent() {
		return continent;
	}
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
	public List<CountryCodeAndName> getCountryCodeAndNames() {
		return countryCodeAndNames;
	}
	public void setCountryCodeAndNames(List<CountryCodeAndName> countryCodeAndNames) {
		this.countryCodeAndNames = countryCodeAndNames;
	}
	
}
