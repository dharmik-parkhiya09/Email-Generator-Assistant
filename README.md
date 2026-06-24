
# 📧 Email Generator Assistant

An AI-powered Email Generator Assistant built with Spring Boot and Google Gemini AI. This application helps users generate professional, formal, friendly, or custom email responses instantly using Generative AI.

## 🚀 Features

* Generate professional emails using AI
* Multiple email tone options

  * Professional
  * Friendly
  * Formal
  * Casual
* REST API-based architecture
* Spring Boot backend
* Gemini AI integration
* Clean and scalable project structure
* Easy API testing using Postman

---

## 🛠️ Tech Stack

### Backend

* Java 24
* Spring Boot 3
* Spring Web
* Maven

### AI Integration

* Google Gemini API

### Tools

* Postman
* Git
* GitHub

---

## 📂 Project Structure

```text
Email-Generator-Assistant
│
├── src/main/java
│   ├── controller
│   ├── service
│   ├── entity
│   ├── config
│   └── EmailGeneratorAssistantApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── pom.xml
└── README.md
```

## ⚙️ Configuration

Add the following properties inside `application.properties`:

```properties
gemini.api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent
gemini.api.key=YOUR_GEMINI_API_KEY
```

Replace:

```text
YOUR_GEMINI_API_KEY
```

with your actual Gemini API Key.

---

## ▶️ Running the Project

### Clone Repository

```bash
git clone https://github.com/dharmik-parkhiya09/Email-Generator-Assistant.git
```

### Navigate to Project

```bash
cd Email-Generator-Assistant
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## 📡 API Endpoint

### Generate Email

```http
POST /api/email/generate
```

### Request Body

```json
{
  "emailContent": "I am unable to attend the meeting tomorrow.",
  "tone": "Professional"
}
```

### Sample Response

```json
{
  "generatedEmail": "Dear Team, I regret to inform you that I will be unable to attend tomorrow's meeting..."
}
```

---

## 💡 Use Cases

* Business Email Writing
* Interview Follow-up Emails
* Leave Request Emails
* Client Communication
* Professional Replies
* Internship & Placement Communications

---

## 🔮 Future Enhancements

* Email Subject Generation
* Multi-language Support
* Gmail Integration
* Email Templates Library
* Email Summarization
* Spring Security Authentication
* React Frontend Dashboard

---

## 👨‍💻 Author

**Dharmik Parkhiya**

* Java Backend Developer
* Spring Boot Enthusiast
* ICT Engineering Student

GitHub:
https://github.com/dharmik-parkhiya09

---

## ⭐ Support

If you like this project:

* Star the repository
* Fork the repository
* Contribute improvements

---

## 📜 License

This project is open-source and available under the MIT License.
