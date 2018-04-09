package steps;

import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import pages.*;

class BaseStep {
    LandingPage landingPage = new LandingPage();
    InputForm inputForm = new InputForm();
    MethodologyPage methodologyPage = new MethodologyPage();
    ListOfIndicatorsPage listOfIndicatorsPage = new ListOfIndicatorsPage();
    CountryPage countryPage = new CountryPage();
    ListOfCountriesPage listOfCountriesPage=new ListOfCountriesPage();
    AdminPage adminPage = new AdminPage();

    DataStore specDataStore = DataStoreFactory.getSpecDataStore();


}
