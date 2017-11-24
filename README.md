# gdhi-automation
Functional automation tests for GDHI project using Gauge and WebDriver

## Pre-requisites
* Install gauge (Refer to http://getgauge.github.io/documentation/user/0.5.0/installations/operating_system)
* Install chromedriver executable (Refer to https://sites.google.com/a/chromium.org/chromedriver/getting-started)

## For running from a remote CI agent
* Install xvfb and run it as a daemon
* Create a ~/.pgpass file with the Postgres DB password
* Add a task in the CI job to run the data_reset.sh file (this task will require the ~/.pgpass file to connect to the database)
* Set an environment variable `DISPLAY=0:0` to let chrome run in a virtual display

## Environment variables to be set
* `BROWSER=<chrome/firefox>`
* `CHROME_DRIVER_PATH=<path to chromedriver executable>` (if using Chrome)
* `APP_BASE_URL=<URL for the map page of the app>`
* `INPUT_FORM_URL=<URL for the questionairre>`

## Running specs
`./gradlew clean gauge`
