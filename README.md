# ToDoApp
A simple and user-friendly To-Do app for managing tasks with features to add, edit, complete, and delete items.
# 📝 Java ToDo App (MVC | JSP | Servlets | MySQL)

A simple and efficient ToDo web application built using **Java**, **JSP**, **Servlets**, **JDBC**, and **MySQL** following the **MVC architecture**. This project demonstrates full-stack development using Java EE technologies for backend and modern UI tools like **HTML**, **CSS**, **JavaScript**, and **Bootstrap** for frontend.

## 📌 Features

- 🔐 **User Authentication**
  - Register a new account
  - Secure Login using hashed passwords
  - Session management for authentication

- ✅ **Task Management**
  - Add new tasks
  - View all tasks for the logged-in user
  - Mark tasks as complete/incomplete
  - Delete tasks
  - Status of tasks persists on reload

- 🎨 **Modern UI**
  - Responsive design using Bootstrap
  - Clean and user-friendly interface
  - Dynamic features using JavaScript

## 🧱 Technologies Used

### Backend
- **Java (Servlets + JSP)**
- **JDBC** – for database connectivity
- **MySQL** – as the relational database

### Frontend
- **HTML5**, **CSS3**, **JavaScript**
- **Bootstrap 5**

### Architecture
- **MVC (Model-View-Controller)** – for clean code separation and maintainability

## 🗂️ Project Structure

```bash
├── src/
│   ├── controller/       # Servlet classes (Login, Register, Task operations)
│   ├── dao/              # Data Access Object classes
│   ├── model/            # POJO classes (User, Task)
│   └── util/             # DB connection utility
│
├── WebContent/
│   ├── css/              # Custom stylesheets
│   ├── js/               # Custom JavaScript
│   ├── views/            # JSP files (login.jsp, register.jsp, home.jsp)
│   └── WEB-INF/          # web.xml and configuration
