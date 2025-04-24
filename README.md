# House Rentals

A full-stack property rental platform that streamlines the interaction between tenants, dealers, owners, and admins, enhanced with AI/ML-based decision support and automated email/chat integrations.

## Features

### Tenant Actions
- Search and view properties
- Apply filters and compare using AI-based recommendations
- Leave reviews and submit queries
- Report owners and express interest via contact forms

### Dealer/Owner Actions
- Upload property listings
- Get AI/ML-based rent suggestions
- Receive tenant interest notifications via email

### 🛡Admin Actions
- Review reports submitted by tenants
- Ban users if reports are valid

## System Overview

This platform integrates several services as shown in the diagram:
- **AI Model**: For property comparisons
- **ML Model**: For rent prediction
- **Email Service**: For sending contact/interest notifications
- **Chatbot**: For handling user queries (tenant support)


## 🛠️ Tech Stack

- **Frontend**: HTML, CSS, JavaScript (assumed)
- **Backend**: Java with Spring Boot
- **Database**: MySQL
- **AI/ML Integration**: Custom models for rent and property comparison
- **Communication**: SMTP/Email, Chatbot Integration

## ⚙️ Configuration

Here’s the `application.properties` setup for the Spring Boot backend:

```properties
spring.application.name=house-rental
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/house_rentals
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/itsdhruvrpandey01/House-Rentals.git
   cd House-Rentals
   ```

2. Set up the MySQL database:
   ```sql
   CREATE DATABASE house_rentals;
   ```

3. Update the `application.properties` with your local credentials.

4. Run the Spring Boot application:
   ```bash
   ./mvnw spring-boot:run
   ```

5. Access the app at `http://localhost:8081`

## Future Enhancements

- Integrate advanced chatbot for multilingual support
- Add payment gateway for rental transactions
- Notification system via SMS
- Mobile app version

## 👥 Contributors

- [**Dhruv Pandey**](https://github.com/itsdhruvrpandey01) – Project Lead & Backend Development  
- [**Ayush**](https://github.com/ayushkhopatkar) – Frontend Development  
- [**Sagar**](https://github.com/Sagargd4) – Frontend Development  
- [**Ganesh**](https://github.com/Ganeshhhhh) – Backend Development

