# URL Shortener

A Spring Boot application that generates short URLs from long URLs with expiration tracking and comprehensive error handling.

## Features

- **Short URL Generation**: Convert long URLs to shortened links
- **Expiration Tracking**: URLs automatically expire after 7 days
- **URL Validation**: Strict validation for supported domain extensions (.com, .in, .co.in, .org, .net, .gov, .edu, .info, .biz)
- **Error Handling**: Comprehensive exception handling with meaningful error codes
-  **Persistent Storage**: H2 in-memory database for URL storage
- **Lombok Integration**: Clean, boilerplate-free code

## Tech Stack

- **Framework**: Spring Boot 4.1.0
- **Language**: Java 17
- **Database**: H2 Database
- **ORM**: Hibernate JPA
- **Build Tool**: Maven
- **Libraries**: 
  - Lombok (code generation)
  - Guava (URL hashing - Murmur3)

## Project Structure

```
src/main/java/com/urlshortner/urlshortnerproject/
├── Controller/
│   └── UrlController.java         # REST endpoints
├── Service/
│   ├── UrlService.java            # Service interface
│   ├── UrlServiceImpl.java         # Service implementation
│   └── UrlDto.java                # Request DTO
├── Model/
│   ├── Url.java                   # JPA Entity
│   ├── UrlDto.java                # Request DTO
│   ├── UrlResponseDto.java        # Response DTO
│   └── UrlErrorResponseDto.java   # Error Response DTO
├── Repository/
│   └── UrlRepo.java               # Data access layer
├── Exception/
│   ├── BlankUrlException.java     # 400 - Blank URL
│   ├── UrlNotFoundException.java   # 404 - URL not found
│   ├── InvalidUrlFormatException.java  # 108 - Invalid format
│   └── GlobalExceptionHandler.java     # Global exception handler
└── Util/
    └── UrlValidator.java          # URL validation logic
```

## API Endpoints

### 1. Generate Short URL

**POST** `/api/v1/generate`

Generate a shortened URL from a long URL.

**Request Body:**
```json
{
  "originalUrl": "https://www.facebook.com/some/very/long/url"
}
```

**Success Response (200):**
```json
{
  "originalUrl": "https://www.facebook.com/some/very/long/url",
  "shortUrl": "2138db8a",
  "expirationTime": "2026-08-21T00:26:25.240385"
}
```

**Error Responses:**

- **400 - Blank URL:**
```json
{
  "status": "400",
  "error": "URL cannot be blank or empty"
}
```

- **108 - Invalid URL Format:**
```json
{
  "status": "108",
  "error": "Invalid URL format. URL must contain a valid domain extension like .com, .in, .co.in, .org, .net, .gov"
}
```

### 2. Redirect to Original URL

**GET** `/{shortUrl}`

Redirects to the original URL using the short code.

**Parameters:**
- `shortUrl` (path): The short URL code (e.g., `2138db8a`)

**Success Response (302):** Redirects to the original URL

**Error Response (404):**
```json
{
  "status": "404",
  "error": "Short URL not found: {shortUrl}"
}
```

## Error Codes

| Code | HTTP Status | Description |
|------|-------------|-------------|
| 400 | 400 Bad Request | URL is blank or empty |
| 404 | 404 Not Found | Short URL not found in database |
| 108 | 400 Bad Request | Invalid URL format (missing valid domain extension) |

## Supported Domain Extensions

- `.com`
- `.in`
- `.co.in`
- `.org`
- `.net`
- `.gov`
- `.edu`
- `.info`
- `.biz`

## Installation

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Steps

1. **Clone the repository:**
```bash
git clone https://github.com/yourusername/urlshortner-Springboot.git
cd urlshortner-Springboot
```

2. **Build the project:**
```bash
./mvnw clean build
```

3. **Run the application:**
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## Usage Examples

### Generate Short URL

```bash
curl -X POST http://localhost:8080/api/v1/generate \
  -H "Content-Type: application/json" \
  -d '{
    "originalUrl": "https://www.github.com/this/is/a/very/long/url/path"
  }'
```

### Redirect to Original URL

```bash
curl -L http://localhost:8080/2138db8a
```

## URL Validation Rules

- URL cannot be blank or empty
- URL must contain a valid domain extension from the supported list
- URL can start with `http://` or `https://`, or neither (will default to `https://`)
- Valid format: `[protocol://]domain[.subdomain].extension`

### Valid URLs
- `facebook.com`
- `https://www.example.com`
- `www.github.org`
- `api.domain.co.in`

### Invalid URLs
- `www.fb` (missing valid extension)
- `example` (no extension)
- `` (empty)
- `www.xyz123` (invalid extension)

## How It Works

1. **URL Submission**: User submits a URL via `/api/v1/generate`
2. **Validation**: The URL is validated against the format rules
3. **Hashing**: A Murmur3 hash is generated from the URL + current timestamp
4. **Storage**: The original URL, short code, and expiration date are saved
5. **Response**: Returns the short URL code and expiration time
6. **Redirection**: User can access the original URL using the short code

## Database Schema

### Url Entity

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT | Primary key (auto-generated) |
| originalUrl | CLOB | The full original URL |
| shortLink | VARCHAR | Unique short code (8 characters) |
| creationDate | TIMESTAMP | When the short URL was created |
| expirationDate | TIMESTAMP | When the short URL expires (7 days from creation) |

## Configuration

The application uses H2 in-memory database by default. Access H2 console at:
- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (empty)

## Future Enhancements

- [ ] Persistent database (PostgreSQL/MySQL)
- [ ] Custom short URL aliases
- [ ] Click analytics and statistics
- [ ] URL expiration cleanup job
- [ ] Rate limiting
- [ ] User authentication and management
- [ ] QR code generation

## License

MIT License

## Author

Created by Suman
