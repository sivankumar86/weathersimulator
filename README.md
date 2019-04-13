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
 
 
Feedback is always welcome. 
