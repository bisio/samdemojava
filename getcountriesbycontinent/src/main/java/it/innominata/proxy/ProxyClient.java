package it.innominata.proxy;

import java.io.IOException;
import java.util.List;

import it.innominata.adapter.DaggerGetCountriesByContinentAdapterFactory;
import it.innominata.adapter.GetCountriesByContinentAdapter;
import it.innominata.om.CountryCodeAndNameGroupedByContinent;
import it.innominata.simplesoapclient.Client;


public class ProxyClient {

	private Client client;
	
	public ProxyClient() throws IOException{
		client = new Client();
	}
	
	public List<CountryCodeAndNameGroupedByContinent> getCountriesByContinent() throws IOException  {
		GetCountriesByContinentAdapter adapter =  DaggerGetCountriesByContinentAdapterFactory.create().createListContinentAdapter();
		return adapter.transformOutput(client._ListOfCountryNamesGroupedByContinent());
	}
}
