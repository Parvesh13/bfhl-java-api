# REST API Assignment by Parvesh 2310991011 (BFHL -- Chitkara University)

This project implements the **BFHL REST API assignment**, designed to
process structured input and return customized responses strictly as per
the given specifications. The API supports mathematical operations and
AI-based responses.

------------------------------------------------------------------------

## API Endpoints

-   **POST /bfhl**
-   **GET /health**

**Live Demo:**\
https://bfhl-java-api.onrender.com

------------------------------------------------------------------------

## Sample Requests & Responses

### Health Check

``` json
{
  "is_success": true,
  "official_email": "parvesh1011.be23@chitkara.edu.in"
}
```

------------------------------------------------------------------------

### Fibonacci

``` json
{
  "fibonacci": 7
}
```

``` json
{
  "is_success": true,
  "official_email": "parvesh1011.be23@chitkara.edu.in",
  "data": [0,1,1,2,3,5,8]
}
```

------------------------------------------------------------------------

### Prime Numbers

``` json
{
  "prime": [2,4,7,9,11]
}
```

``` json
{
  "is_success": true,
  "official_email": "parvesh1011.be23@chitkara.edu.in",
  "data": [2,7,11]
}
```

------------------------------------------------------------------------

### LCM

``` json
{
  "lcm": [12,18,24]
}
```

``` json
{
  "is_success": true,
  "official_email": "parvesh1011.be23@chitkara.edu.in",
  "data": 72
}
```

------------------------------------------------------------------------

### HCF

``` json
{
  "hcf": [24,36,60]
}
```

``` json
{
  "is_success": true,
  "official_email": "parvesh1011.be23@chitkara.edu.in",
  "data": 12
}
```

------------------------------------------------------------------------

### AI (Google Gemini)

``` json
{
  "AI": "What is the capital city of Maharashtra?"
}
```

``` json
{
  "is_success": true,
  "official_email": "parvesh1011.be23@chitkara.edu.in",
  "data": "Mumbai"
}
```

------------------------------------------------------------------------

## Tech Stack

-   Java 17
-   Spring Boot
-   Maven
-   REST APIs
-   Google Gemini AI

------------------------------------------------------------------------

## Author

**Parvesh**\
Chitkara University\
parvesh1011.be23@chitkara.edu.in
