# Feed App

Feed App is a social media platform that allows users to post content, interact with one another, and manage user authentication. The project includes features such as user registration, login, posting, commenting, and secure session management with JWT tokens.

## Screenshots

<img width="1202" alt="Screenshot 2025-01-29 at 2 41 52 PM" src="https://github.com/user-attachments/assets/1beb08aa-e5b4-45eb-8455-b98ac55cabc1" />

<img width="1107" alt="Screenshot 2025-01-29 at 2 41 04 PM" src="https://github.com/user-attachments/assets/a732db00-c77f-4903-a3ad-fd0c94291f24" />

<img width="1384" alt="Screenshot 2025-01-29 at 2 40 35 PM" src="https://github.com/user-attachments/assets/d00c543f-b835-40ee-857c-a4d6334650d4" />

<img width="921" alt="Screenshot 2025-01-29 at 2 41 16 PM" src="https://github.com/user-attachments/assets/206cafe9-95f7-4e08-974a-0bc8262330fe" />

<img width="791" alt="Screenshot 2025-01-29 at 2 41 27 PM" src="https://github.com/user-attachments/assets/95bb2d9b-c801-468f-9eb3-15940790a18b" />


## Project Structure

The project is divided into two main directories:

1. **FeedAppBackEnd**: Contains the backend code for the application.
2. **FeedAppFrontEnd**: Contains the frontend code for the application.

### FeedAppBackEnd

The backend is built using Spring Boot and provides RESTful APIs for user authentication, posting content, and interacting with posts. It includes the following key components:

- **User Registration and Login**: Users can register and log in to the application. Passwords are securely hashed, and JWT tokens are used for session management.
- **Posting Content**: Users can create, read, update, and delete posts.
- **Commenting**: Users can comment on posts.
- **Secure Session Management**: JWT tokens are used to manage user sessions securely.

#### Directory Structure

```
FeedAppBackEnd/
├── .github/
│   └── workflows/
│       └── ci.yml
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/bptn/feedApp/
│   │   │       ├── controller/
│   │   │       ├── exception/
│   │   │       ├── filter/
│   │   │       ├── jpa/
│   │   │       ├── provider/
│   │   │       ├── repository/
│   │   │       ├── security/
│   │   │       └── service/
│   │   └── resources/
│   │       ├── application.yml
│   │       └── config.yml
│   └── test/
│       └── java/
│           └── com/bptn/feedApp/
│               └── controller/
├── mvnw
├── mvnw.cmd
└── pom.xml
```
### FeedAppFrontEnd

The frontend is built using React and provides a user-friendly interface for interacting with the application. It includes the following key components:

- **User Registration and Login**: Users can register and log in to the application.
- **Posting Content**: Users can create, view, and delete posts.
- **Commenting**: Users can comment on posts.
- **Profile Management**: Users can update their profile information.

#### Directory Structure

```
FeedAppFrontEnd/
├── src/
│   ├── appRoutes/
│   │   └── AppRoutes.js
│   ├── assets/
│   │   └── images/
│   ├── components/
│   │   ├── AddFeed.js
│   │   ├── FeedCard.js
│   │   ├── MyProfile.js
│   │   ├── UpdateBasicProfile.js
│   │   └── UpdatePublicProfile.js
│   ├── context/
│   ├── pages/
│   │   ├── App/
│   │   │   ├── CompleteProfile.js
│   │   │   ├── Dashboard.js
│   │   │   ├── MyFeeds.js
│   │   │   └── Profile.js
│   │   └── User/
│   │       ├── Login.js
│   │       ├── Register.js
│   │       └── VerifyEmail.js
│   ├── util/
│   │   └── ApiUtil.js
│   ├── index.js
│   └── index.css
├── package.json
└── README.md
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Node.js and npm
- Maven

### Backend Setup

1. Navigate to the FeedAppBackEnd directory.
2. Run the following command to build the project: ./mvnw clean install

3. Run the following command to start the backend server: ./mvnw spring-boot:run

Frontend Setup
1. Navigate to the FeedAppFrontEnd directory.
2. Run the following command to install the dependencies: npm install

3. Run the following command to start the frontend development server: npm start

Features

 - User Registration: Users can register by providing their details.
 - User Login: Users can log in using their credentials.
 - Posting Content: Users can create, view, and delete posts.
 - Commenting: Users can comment on posts.
 - Profile Management: Users can update their profile information.
 - Secure Session Management: JWT tokens are used to manage user sessions securely.

Technologies Used

Backend: Spring Boot, Spring Security, JWT, JPA, PostgreSQL

Frontend: React, TailwindCSS
