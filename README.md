# EmojiSearch

### General Info
EmojiSearch is a Java backend service designed for efficient emoji searching and retrieval.
	
### Technologies
This project is created with:

- **Spring Boot: 2.4.3** - A powerful and convention-over-configuration-based framework for building Java-based, production-grade Spring applications.
- **Spring Data JPA** - Simplifies data access using the Java Persistence API (JPA).
- **Gson: 2.8.6** - A library for JSON serialization and deserialization in Java.
- **PostgreSQL** - A powerful, open-source relational database system.
- **RESTful** - Follows the principles of Representational State Transfer for creating scalable web services.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/hgvicban/EmojiSearch.git
    ```

2. Navigate to the project directory:

    ```bash
    cd EmojiSearch
    ```

3. Build the project using Gradle:

    ```bash
    ./gradlew build
    ```

### Running the Application

1. Start the server:

    ```bash
    ./gradlew run
    ```

The EmojiSearch API will be accessible at `http://localhost:3000`.

## API Usage

### Search by Keyword

```http
GET emojis/{keyword}
```

Replace `{keyword}` with the desired search term. Example:

```http
GET emojis/smile
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

