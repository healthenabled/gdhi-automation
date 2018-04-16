package data;

import java.util.HashMap;

public class DataFactory {

    public static HashMap<String, String> getValidInputFormDataFor(String countryName) {
        HashMap<String, String> data = new HashMap<>();
        data.put("countryName", countryName);
        data.put("organisation", "Ministry of Health");
        data.put("date", "01-11-2017");
        data.put("dataEntryName", "Data Entry");
        data.put("dataEntryRole", "Data Entry Assistant");
        data.put("dataEntryEmail", "data_entry@country.org");
        data.put("dataCollectorName", "Data Collector");
        data.put("dataCollectorRole", "Director of Digital Health");
        data.put("dataCollectorEmail", "data_collector@country.org");
        data.put("countryContactName", "Mr.Minister");
        data.put("countryContactRole", "Union Health Minister");
        data.put("countryContactEmail", "country_contact@country.org");
        data.put("resource1", "http://resource1.country.org");
        data.put("resource2", "http://resource2.country.org");
        data.put("resource3", "http://resource3.country.org");
        data.put("resource4", "http://resource4.country.org");
        data.put("resource5", "http://resource5.country.org");
        data.put("countrySummary", "This is a detailed summary. Please refer to the resources for further details.");
        data.put("indicator1Score", "1");
        data.put("indicator2Score", "2");
        data.put("indicator3Score", "3");
        data.put("indicator4Score", "4");
        data.put("indicator5Score", "5");
        data.put("indicator6Score", "0");
        data.put("indicator7Score", "1");
        data.put("indicator8Score", "2");
        data.put("indicator9Score", "3");
        data.put("indicator10Score", "4");
        data.put("indicator11Score", "5");
        data.put("indicator12Score", "1");
        data.put("indicator13Score", "2");
        data.put("indicator14Score", "3");
        data.put("indicator15Score", "4");
        data.put("indicator16Score", "5");
        data.put("indicator17Score", "1");
        data.put("indicator18Score", "2");
        data.put("indicator19Score", "3");
        data.put("indicator20Score", "4");
        data.put("indicator21Score", "5");
        data.put("indicator22Score", "1");
        data.put("indicator23Score", "2");
        data.put("indicator24Score", "3");
        data.put("indicator25Score", "4");
        data.put("indicator26Score", "5");
        data.put("indicator27Score", "1");
        data.put("indicator28Score", "2");
        data.put("indicator29Score", "3");
        data.put("indicator30Score", "3");
        data.put("resourcesText","Resources");
        return data;
    }
}
