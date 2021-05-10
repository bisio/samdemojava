package it.innominata.simplesoapclient;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.oorsprong.websamples.ArrayOftContinent;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.CountryInfoServiceSoapType;
import org.oorsprong.websamples.TCountryCodeAndNameGroupedByContinent;


public class Client {

	private CountryInfoService oorsprongService;
	private CountryInfoServiceSoapType oorsprongPort;

	public Client() throws IOException  {
		URL oorsprongUrl = new URL("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
		oorsprongService = new CountryInfoService(oorsprongUrl);
		oorsprongPort  = oorsprongService.getCountryInfoServiceSoap();
	}
	
	public List<TCountryCodeAndNameGroupedByContinent> _ListOfCountryNamesGroupedByContinent() throws IOException {
		return oorsprongPort.listOfCountryNamesGroupedByContinent().getTCountryCodeAndNameGroupedByContinent();
	}
	
	public ArrayOftContinent _listContinentsByName() throws IOException {
		return oorsprongPort.listOfContinentsByName();
	}
	
}
