# Project Information and Limitations
--------------------------------------------------------------------------------------------------

## INSTRUCTIONS
--------------------------------------------------------------------------------------------------

1. Download the Postman collection from the "resources" package.



## HOW TO RUN MYSQL DATA BASE CONTAINER
--------------------------------------------------------------------------------------------------
1. Open a terminal in the root directory of the project.
2. Run the following command to start the MySQL container:
   docker-compose up -d

   

Artemis-MQ  - UI in browser
-------------------------------------------------------------------------------------------
http://localhost:8161/
userName = admin
password = admin




# HOW TO ADD NEW USER USING CURL
--------------------------------------------------------------------------------------------------

curl --location "http://127.0.0.1:8080/api/users" --header "Content-Type: application/json" --data "{\"firstName\": \"Yossi\", \"lastName\": \"Tal\"}"

curl --location "http://127.0.0.1:8080/api/users" --header "Content-Type: application/json" --data "{\"firstName\": \"Dani\", \"lastName\": \"Cohen\"}"

--------------------------------------------------------------------------------------------------





