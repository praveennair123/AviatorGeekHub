AvGeek – Aviation Dashboard ✈️

AvGeek is a full-stack web application for aviation enthusiasts, pilots, spotters, students, and fans. It offers role-based dashboards with CRUD operations, secure authentication, and a responsive UI to manage and explore aviation data efficiently.

🚀 Features

Role-Based Dashboards

Admin: Manage users, flights, and approve/reject spotter submissions.

Pilot: View flights and manage logbook entries.

Spotter: Submit aircraft sightings with photos and view approved submissions.

Student: Access aviation resources and take quizzes.

Fan: Browse flights and mark favourites.

Core Functionalities

Secure login/logout via Spring Security with BCrypt encryption.

Role-based navigation and access control.

CRUD operations for flights, users, logbooks, sightings, resources, quizzes, and favourites.

Responsive UI with Thymeleaf + Bootstrap 5.

Dark mode toggle for improved user experience.

Database & Seed Data

In-memory H2 Database, auto-seeded with demo users and sample data.

Preloaded flights, logbook entries, spotter submissions, resources, quizzes, and favourites.

🛠 Tech Stack

Backend: Java 17+, Spring Boot (MVC)

Frontend: Thymeleaf, Bootstrap 5

Database: H2 (in-memory)

Security: Spring Security with role-based authentication

Other: File upload support for spotter images

💾 Seed Accounts
Role	Username	Password
Admin	admin@aviation.com	password
Pilot	pilot@aviation.com	password
Spotter	spotter@aviation.com	password
Student	student@aviation.com	password
Fan	fan@aviation.com	password
⚡ Getting Started

Clone:

git clone https://github.com/your-username/avgeek.git
cd avgeek


Build and run:

mvn spring-boot:run


Open in browser: http://localhost:8080/login

Log in with demo accounts to explore dashboards.

✅ Acceptance Criteria

Runs locally with mvn spring-boot:run

Login at /login

Role-specific pages with dynamic navigation

CRUD functional for main entities

Preloaded demo data for testing

🎨 UI & Experience

Fully responsive, mobile-friendly dashboards

Dark mode toggle

Clean design suitable for portfolios

📌 Future Improvements

Real-time aviation API integration

Analytics dashboards for pilots and fans

Notifications for spotter submissions and quizzes

Profile management and enhanced file uploads
