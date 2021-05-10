package it.innominata.adapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.dozer.DozerBeanMapper;
import org.oorsprong.websamples.TCountryCodeAndNameGroupedByContinent;

import it.innominata.om.CountryCodeAndNameGroupedByContinent;

public class GetCountriesByContinentAdapter {
		
	private final DozerBeanMapper mapper;

	@Inject
	public GetCountriesByContinentAdapter(DozerBeanMapper mapper) {
		this.mapper = mapper;
	}
	
	public  List<CountryCodeAndNameGroupedByContinent> transformOutput(List<TCountryCodeAndNameGroupedByContinent> out) {
		
		List<CountryCodeAndNameGroupedByContinent> results = new ArrayList<CountryCodeAndNameGroupedByContinent>();
		for (TCountryCodeAndNameGroupedByContinent tCountryCodeAndNameGroupedByContinent: out ) {
			results.add(mapper.map(tCountryCodeAndNameGroupedByContinent, CountryCodeAndNameGroupedByContinent.class));
		}
		return results;
	}
}
