package it.innominata.adapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.dozer.DozerBeanMapper;
import org.oorsprong.websamples.TContinent;

import it.innominata.om.Continent;

public class ListContinentAdapter {
	
	
	private final DozerBeanMapper mapper;

	@Inject
	public ListContinentAdapter(DozerBeanMapper mapper) {
		this.mapper = mapper;
	}
	
	public  List<Continent> transformOutput(List<TContinent> out) {
		List<Continent> results = new ArrayList<Continent>();
		for (TContinent tContinent: out) {
			results.add(mapper.map(tContinent,Continent.class));
		}
		return results;
	}
}
