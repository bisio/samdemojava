package it.innominata.proxy;

import java.io.IOException;
import java.util.List;

import it.innominata.adapter.DaggerListContinentAdapterFactory;
import it.innominata.adapter.ListContinentAdapter;
import it.innominata.om.Continent;
import it.innominata.simplesoapclient.Client;


public class ProxyClient {

	private Client client;
	
	public ProxyClient() throws IOException{
		client = new Client();
	}
	
	public List<Continent> listContinentsByName() throws IOException  {
		ListContinentAdapter adapter =  DaggerListContinentAdapterFactory.create().createListContinentAdapter();
		return adapter.transformOutput(client._listContinentsByName().getTContinent());
	}
}
