-- delete health indicators
DELETE FROM country_health_data.health_indicators WHERE country_id = 'LKA';

-- delete country summary
DELETE FROM country_health_data.country_summary WHERE country_id = 'LKA';

-- delete resources
DELETE FROM country_health_data.country_resource_links WHERE country_id = 'LKA';

delete from country_health_data.development_indicators where country_id='LKA';