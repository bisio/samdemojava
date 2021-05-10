package it.innominata.modules;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import org.dozer.DozerBeanMapper;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilityModule {
	
	@Provides
	@Singleton
	public DozerBeanMapper provideDozerMapper() {
		URL mapping = getClass().getClassLoader().getResource("dozer/dozer-mapping.xml");
		List<String> mappingFiles = new ArrayList<String>();
		mappingFiles.add(mapping.toString());
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFiles);
		return mapper;
	}
}
