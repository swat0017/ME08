TEAM ME08 (TECHFORTUNES)

ANDROID APPLICATION NAME : WILDAID

FIT5120-IE Project
This is the code repository for Monash students team ME08 that is developing an android application to assess the risks caused to animals by bushfire and the the ways in which people who want to volunteer and contribute can help them.Our team name is TECHFORTUNES and our app name is WILDAID
The architecture used is MYSQL database stored in AWS RDS instance,queried using lambda functions and API gateway 
Android Studio is used for developing the application

![system arch-updated](https://user-images.githubusercontent.com/70090040/97425345-1daa7100-1966-11eb-8bfb-5004c5b80ad5.jpeg)


TECH STACK DETAILS-

Java is the main language used in developing our application.The application interacts with the database through AWS.A lambda function is created in AWS using Python script.
AWS RDS instance Steps--Log in to AWS console->Services->Search for RDS->Create Database->Choose options Standard create,Mysql,Free tier,set DB name and password,Default VPC and default settings.Once the RDS instance is created,you can connect to the instance from your local system using MYSQL workbench

To run the application,you can either 
1.Download the apk file situated in the apk folder and run it in your android phone 
2.Use an emulator like appetize.io
3.Or pull the code to your local environment and import it in Android studio and run the app to test the application using android emulator

INSTRUCTION ON IMPORTING AND RUNNING THE APPLICATION:

To run the app on an emulator as follows:

1.In Android Studio, create an Android Virtual Device (AVD) that the emulator can use to install and run your app.
In the toolbar, select your app from the run/debug configurations drop-down menu.
From the target device drop-down menu, select the AVD that you want to run your app on.

2. Target device drop-down menu.

3. Click Run .

4. Android Studio installs the app on the AVD and starts the emulator. You now see "Hello, World!" displayed in the app.


INTEGRATION OF OUR APPLICATION WITH AMAZON WEB SERVICES:

Aws rds endpoint- mydatabase-1.cj1vq2k4dclz.us-east-1.rds.amazonaws.com
Steps-Log in to AWS console->Services->Search for Lambda->Create function->function name,choose python script->upload python script zip file->Test lambda
For each individual query a seperate lambda function is created and API gateway is integrated to a lambda function for API access from outside

Steps for creating API gateway-once the lambda function is created and tested successfully,we can expose it via an api gateway for external access.
AWS console->Services->Search for API Gateway->Create API->REST API build-> API name->create resource->Create method->GET-> Select integration type lambda and map lambda function-DEPLOY API ->Stage dev
Once the API is deployed successfully you can access the resource from outside to get the JSON response
This URL is integrated in the java side app->src->main->java->com->example->me08->networkconnection->APIGatewayConnection.java
All methods accessing AWS api gateway are written here with base url as https://4jv3dcocbj.execute-api.us-east-1.amazonaws.com/dev/

Please refer to this link for more information : https://docs.aws.amazon.com/lambda/latest/dg/with-android-example.html

INTEGRATION OF OUR APPLICATION WITH IBM WATSON ASSISTANT:

We have created a service with IBM cloud for IBM Watson assistant.
We are using IBM Watson assistant for our application's chatbot feature.
In IBM Watson assistant we have created Dialogs and Intent. The Dialogs are for training the Bot for the replies to the users questions. The Intents are created to train the Bot with various responses from the user for giving appropriate response.

To Run the android application with IBM cloud assistance, 

1. Sign up for an IBM Cloud account.
2. Create an instance of the Watson service you want to use and get your credentials:
3. Go to the IBM Cloud catalog page and select the service you want.
4. Log in to your IBM Cloud account.
5. Click Create.
6. Click Show to view the service credentials.
7. Copy the apikey value, or copy the username and password values if your service instance doesn't provide an apikey.
8. Copy the url value.

For more information on running android studio with IBM watson assistance
1. https://developer.ibm.com/recipes/tutorials/making-an-android-mobile-app-that-uses-the-ibm-watson-conversation-service-as-a-chatbot/
2. https://cloud.ibm.com/docs/solution-tutorials?topic=solution-tutorials-android-watson-chatbot

IMAGES USED FOR OUR APPLICATION

Images are stored in S3 Bucket and the URL is saved in database tables which is accessed via the API gateway
All the images are taken from pixabay free license
www.pixabay.com


