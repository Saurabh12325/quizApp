 <img src = "![image](https://github.com/user-attachments/assets/81b0f409-6280-4539-a04b-1ce7fd9da750)
">
Hey, This is my first Major project as a "JAVA Backened with Spring Boot".
QuizSutra - Interactive Quiz Application Backend 🧠💻

📜 Overview
QuizSutra is a robust and interactive quiz application backend built using Spring Boot and integrated with MongoDB Atlas for data management.
This platform supports features for administrators and players, enabling seamless quiz creation, participation, and leaderboard management.


🚀 Features and workflow of the backened 
 1:- Admin Panel:
Admin registration and login.
Quiz creation and management.
2:- Quiz Player Functionality:
Play quizzes based on category and difficulty.
Real-time scoring and streak tracking.
:- Comprehensive API:
User and quiz management endpoints.
Flexible quiz fetching based on filters.
Scalability: Hosted on Render, utilizing cloud-based MongoDB Atlas.

🛠️ Tech Stack
Backend Framework: Spring Boot
Database: MongoDB Atlas
Language: Java
Hosting: Render

📚 API Endpoints
Admin Functionality
Register Admin
POST /admin/register
Register a new admin with credentials.

Login Admin
POST /admin/login
Authenticate admin and receive an access token.

Create Quiz
POST /admin/createQuiz
Add quizzes with titles and questions.

Fetch Admin Quizzes
GET /admin/fetchQuiz?adminId={adminId}
View all quizzes created by a specific admin.

Quiz Retrieval:-
By Category
GET /quizzes/category/{category}

By Difficulty
GET /quizzes/difficulty/{difficulty}

Player Data Management:-
Save Player Data
POST /QuizEntry/SavePlayerData

Retrieve All Players
GET /QuizEntry/findAll

