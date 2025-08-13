# AvGeek - Aviation Dashboard

A comprehensive web application for aviation enthusiasts, professionals, and students. Built with Spring Boot, featuring role-based access control and specialized dashboards for different user types.

## 🚀 Features

### Role-Based Access Control
- **Admin**: System management, user administration, content moderation
- **Pilot**: Flight logbook management, flight tracking
- **Spotter**: Aircraft spotting submissions, photo uploads
- **Student**: Learning resources, interactive quizzes
- **Fan**: Flight browsing, favorites management

### Key Functionality
- ✅ Secure authentication with Spring Security
- ✅ Role-based navigation and access control
- ✅ Responsive Bootstrap 5 UI
- ✅ H2 in-memory database with auto-seeding
- ✅ File upload support for spotter photos
- ✅ CRUD operations for all major entities
- ✅ Interactive quiz system for students
- ✅ Favorites system for aviation fans

## 🛠️ Technology Stack

- **Backend**: Java 17, Spring Boot 3.2.0
- **Database**: H2 (in-memory)
- **Security**: Spring Security with BCrypt encryption
- **Frontend**: Thymeleaf, Bootstrap 5, Font Awesome
- **Build Tool**: Maven

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- Modern web browser

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone <repository-url>
cd AvGeek
```

### 2. Run the Application
```bash
mvn spring-boot:run
```

### 3. Access the Application
Open your browser and navigate to: `http://localhost:8080`

### 4. Login with Demo Accounts

| Role | Username | Password |
|------|----------|----------|
| Admin | `admin` | `password` |
| Pilot | `pilot1` | `password` |
| Spotter | `spotter1` | `password` |
| Student | `student1` | `password` |
| Fan | `fan1` | `password` |

## 📁 Project Structure

```
AvGeek/
├── src/
│   ├── main/
│   │   ├── java/com/avgeek/
│   │   │   ├── config/          # Security configuration
│   │   │   ├── controller/      # MVC controllers
│   │   │   ├── model/          # JPA entities
│   │   │   ├── repository/     # Data access layer
│   │   │   ├── service/        # Business logic
│   │   │   └── AvGeekApplication.java
│   │   └── resources/
│   │       ├── templates/      # Thymeleaf templates
│   │       ├── application.properties
│   │       └── data.sql        # Seed data
│   └── test/                   # Test files
├── pom.xml
└── README.md
```

## 🎯 User Roles & Features

### 👨‍💼 Admin
- **Dashboard**: System statistics and quick actions
- **User Management**: View, add, edit, delete users
- **Flight Management**: Manage flight information
- **Content Moderation**: Approve/reject spotter submissions
- **Resource Management**: Manage learning materials

### ✈️ Pilot
- **Dashboard**: Flight overview and recent logbook entries
- **Logbook Management**: Add, edit, delete flight entries
- **Flight Tracking**: View assigned flights and status

### 📷 Spotter
- **Dashboard**: Submit new sightings and view gallery
- **Photo Upload**: Upload aircraft photos with metadata
- **Submission Management**: Track approval status
- **Gallery**: Browse approved sightings from community

### 🎓 Student
- **Dashboard**: Access learning resources and quizzes
- **Learning Resources**: Browse aviation materials by category
- **Interactive Quizzes**: Test knowledge with multiple-choice questions
- **Progress Tracking**: Monitor learning progress

### ❤️ Fan
- **Dashboard**: Browse flights and manage favorites
- **Flight Browser**: View all available flights
- **Favorites System**: Save and track favorite flights
- **Flight Statistics**: View flight status and trends

## 🔧 Configuration

### Database
- **Type**: H2 in-memory database
- **Auto-seeding**: Enabled with sample data
- **Console**: Available at `http://localhost:8080/h2-console`

### File Upload
- **Location**: `uploads/` directory
- **Max Size**: 10MB per file
- **Supported Formats**: Images (JPG, PNG)

### Security
- **Password Encryption**: BCrypt
- **Session Management**: Spring Security default
- **CSRF Protection**: Enabled

## 📊 Sample Data

The application comes pre-loaded with:

- **5 Users**: One for each role
- **5 Flights**: Various routes and statuses
- **3 Logbook Entries**: Sample pilot flight records
- **3 Spotter Submissions**: Aircraft sightings with photos
- **4 Learning Resources**: Aviation educational materials
- **5 Quiz Questions**: Interactive assessment questions
- **2 Favorites**: Sample fan flight preferences

## 🧪 Testing

### Run Tests
```bash
mvn test
```

### Manual Testing
1. Login with different user roles
2. Test CRUD operations for each role
3. Verify role-based access control
4. Test file upload functionality
5. Complete student quizzes
6. Manage favorites as a fan

## 🚀 Deployment

### Local Development
```bash
mvn spring-boot:run
```

### Production Build
```bash
mvn clean package
java -jar target/aviation-dashboard-0.0.1-SNAPSHOT.jar
```

### Docker (Optional)
```bash
docker build -t avgeek .
docker run -p 8080:8080 avgeek
```

## 🔒 Security Features

- **Authentication**: Form-based login
- **Authorization**: Role-based access control
- **Password Security**: BCrypt encryption
- **CSRF Protection**: Enabled for all forms
- **Session Management**: Secure session handling

## 🎨 UI/UX Features

- **Responsive Design**: Works on desktop, tablet, and mobile
- **Modern Interface**: Bootstrap 5 with custom styling
- **Role-Based Navigation**: Dynamic menus based on user role
- **Interactive Elements**: Tooltips, alerts, and confirmations
- **Accessibility**: Semantic HTML and ARIA labels

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Check the documentation
- Review the sample data and configurations

## 🎉 Acknowledgments

- Spring Boot team for the excellent framework
- Bootstrap team for the responsive UI components
- Font Awesome for the beautiful icons
- Aviation community for inspiration

---

**AvGeek** - Connecting aviation enthusiasts through technology! ✈️
