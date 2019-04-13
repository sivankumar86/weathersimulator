# weathersimulator
Generate weather  sample data based on location and time

It is used to generate sample weather data per hour basis for testing 

Prerequesties 
 - Install Java >1.8 and scala >2.12
 - Install Gradle >5.0
 
 Steps to run the program:
   1. Clone the source code 
   2. Go to root directory (build.property)
   3. Execute below command to generate 30 city and 10 hours on each city 
 
 ################
 
 gradle run 
 
 ###############
 
 If you want to custamize the city and hours 
 
 ###################
 
 gradle run --args="--numberofcity 10 --hours 2"
 
 ##############
 
 
 You can visualize data using Athena and R or quicksight.

1. Upload  output.csv file to s3 and create a table in athena

Create external table weather_data(city string,position string ,lTime string,condition string,temperature string) ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde' 
WITH SERDEPROPERTIES ("separatorChar" = "|", "escapeChar" = "\\") 
LOCATION 's3://<s3path>/'

2. Format the data using view feature

CREATE OR REPLACE VIEW "geoview" AS
SELECT city,split(position,',')[1] lan,split(position,',')[2] lon,temperature, format_datetime(from_iso8601_timestamp(ltime),'yyyy-MM-dd hh') lt FROM "warroom_db"."weather_data" 

3. Visualize the data using quick sight

https://docs.aws.amazon.com/quicksight/latest/user/geospatial-data-prep.html

Feedback is always welcome. 
