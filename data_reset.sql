-- delete health indicators
DELETE FROM validated_config.health_indicators WHERE country_id = 'LKA';

-- delete country summary
DELETE FROM validated_config.countries_summary WHERE country_id = 'LKA';

-- delete resources
DELETE FROM validated_config.country_resource_links WHERE country_id = 'LKA';