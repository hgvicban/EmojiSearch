# EmojiSearch

## Table of contents
* [General Info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General Info
This project is an Emoji Search Spring Boot application.
	
## Technologies
Project is created with:
* Spring Boot: 2.4.3
* Spring Data JPA
* Gson: 2.8.6
* PostgreSQL
* RESTful
	
## Setup
1. Download the code from github.  
`git clone https://github.com/hgvicban/EmojiSearch.git`
2. Build the project.  
`gradlew clean build`
3. Launch the application.  
`java -jar java -jar build/libs/com.hgvicban-0.0.1-SNAPSHOT.jar`
4. Use Postman to test the REST API.  

    #### Test Application
    The application will be running on http://localhost:9090/

    #### GET call to retrieve emojis by keyword
    GET emojis/{keyword}  
    GET emojis/smile  

## License
This project is licensed under the terms of the MIT license.
