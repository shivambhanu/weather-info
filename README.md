# Weather Info

## Assumptions
Fetching weather for a particular date(Historical Dates) needs subscription from API providers.
Fetching weather forecast for future dates only goes max for 14 days ahead.
As it is not specified in the assignment clearly, about the date that whether it is talking about past dates or future, I am going with the current weather info.
Hence, Removing the date parameter from the picture.


## API Endpoints
- http://localhost:8080/geocode/852202   -> Get latitude and longitude for the given pincode
- http://localhost:8080/geocode  -> Get all lat & long stored in database
- http://localhost:8080/api/weather?pincode=852201   -> Get **CURRENT** weather info for a particular pincode