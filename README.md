# ME08
FIT5120-IE Project
This is the code repository for Monash students team Me08 that is developing an android application to assess 
the risks caused to animals by bushfire and the the ways in which people who want to volunteer and contribute can help them.
The architecture used is MYSQL database stored in AWS RDS instance,queried using lambda functions and API gateway 
Android Studio is used for developing the application


To run the application,you can either 
1.Download the apk file situated in the apk folder and run it in your android phone 
2.Use an emulator like appetize.io
3.Or pull the code to your local environment and import it in Android studio and run the app to test the application using android emulator

Tech stack used-

Java is the main language used in developing our application.The application interacts with the database through AWS.A lambda function is created in AWS using Python script.
AWS RDS instance Steps--Log in to AWS console->Services->Search for RDS->Create Database->Choose options Standard create,Mysql,Free tier,set DB name and password,Default VPC and default settings.Once the RDS instance is created,you can connect to the instance from your local system using MYSQL workbench

Database details-
Aws rds endpoint- mydatabase-1.cj1vq2k4dclz.us-east-1.rds.amazonaws.com
Name-mydatabase
Username-admin
Password-monash_1234


Steps-Log in to AWS console->Services->Search for Lambda->Create function->function name,choose python script->upload python script zip file->Test lambda
For each individual query a seperate lambda function is created and API gateway is integrated to a lambda function for API access from outside

