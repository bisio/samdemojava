package it.innominata.lambda;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.innominata.om.Continent;
import it.innominata.proxy.ProxyClient;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	
	private ProxyClient client;
	
	public App() throws IOException {
		System.out.println("Initializing a new instance");
		System.out.println("Now integrated with github.");
		if( System.getenv("DEBUG_SOAP") != null) {
			System.out.println("Enabling soap debugging");
			System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
			System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
			System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
			System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		}
		
		client = new ProxyClient();
		System.out.println("Starting GetContinents Lambda");
	}

	private final ObjectMapper objectMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		try {
			
			List<Continent> continents =  client.listContinentsByName();
						
			APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent().withHeaders(headers);

			return response.withStatusCode(200).withBody(objectMapper.writeValueAsString(continents));

		} catch (IOException e) {
			e.printStackTrace();
			APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent().withHeaders(headers);
			return response.withStatusCode(500).withBody("{}");
		}
	}
}
