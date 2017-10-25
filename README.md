# gdhi-automation
Functional automation tests for GDHI project using Gauge and WebDriver

## Pre-requisites
* Install gauge (Refer to http://getgauge.github.io/documentation/user/0.5.0/installations/operating_system)
* Install chromedriver executable (Refer to https://sites.google.com/a/chromium.org/chromedriver/getting-started)

## Environment variables to be set
* `BROWSER=<chrome/firefox>`
* `CHROME_DRIVER_PATH=<path to chromedriver executable>` (if using Chrome)

## Running specs
`gradle gauge`
