package it.innominata.adapter;

import 	javax.inject.Singleton;

import dagger.Component;
import it.innominata.modules.UtilityModule;

@Singleton
@Component(modules=UtilityModule.class)
public interface GetCountriesByContinentAdapterFactory {
	GetCountriesByContinentAdapter createListContinentAdapter();
}
