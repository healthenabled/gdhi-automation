#!/bin/sh
echo 'Attempting to remove indicator data for the country in test (ie. Sri Lanka)...'
psql -U gdhi -h gdhi.czbru2dc77of.us-east-1.rds.amazonaws.com -d gdhi_showcase < data_reset.sql
echo 'Indicator data deleted for Sri Lanka.'