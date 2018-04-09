#!/bin/sh
echo 'Attempting to remove indicator data for the country in test (ie. Sri Lanka)... in QA database'
psql -h gdhi-qa-v2.czbru2dc77of.us-east-1.rds.amazonaws.com -U gdhi -d gdhi_qa < data_reset.sql
echo 'Indicator data deleted for Sri Lanka.'