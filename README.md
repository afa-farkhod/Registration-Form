# Registration-Form
Registration Form Windows Desktop Application built on Eclipse Window Builder

<p align="center">
  <img src="https://user-images.githubusercontent.com/24220136/223286360-5916ce24-01d2-40db-91aa-00d531938f6c.png" alt="Image">
</p>

- After optimizing the code here is the updated app:

<p align="center">
  <img src="https://user-images.githubusercontent.com/24220136/223347329-ac4e3a2a-facb-4ec7-b7e3-305856d32057.png" alt="Image">
</p>

- Latest UI update, including the Exit button removal, instead Exit is now available in the File menu:

<p align="center">
  <img src="https://user-images.githubusercontent.com/24220136/225279921-3dbe88d3-5fed-48e2-864f-ea27115b570e.png" alt="Image">
</p>

## [Implementation](https://github.com/af4092/Registration-Form/blob/main/Registration/src/RegistrationForm(UPDATE).java)

- `Java Swing` application that implements a user registration form. It uses various `Swing` components such as `JFrame`, `JPanel`, `JLabel`, `JTextField`, `JRadioButton`, `JButton`, `JTable`, `JComboBox`, etc. to create a graphical user interface.
- The application allows users to register by entering their personal information such as name, address, age, gender, mobile number, email, username, and password. Users can also view the registered users' information in a table and perform operations like deleting records.
- The main class in the code is `RegistrationForm`, which extends `JFrame` and serves as the main window for the application. It contains methods for handling user interactions, database operations, and GUI setup.
- Here's a brief overview of the code:
  - The `main` method creates an instance of the `RegistrationForm` class and makes it visible.
  - The `RegistrationForm` class defines the main JFrame and sets up the user interface components.
  - The `clock` method is used to display the current time.
  - The `fillComboBox` method retrieves data from the database and populates the `comboBoxName` JComboBox component with the names of registered users.
  - The `RegistrationForm` constructor sets up the main frame, menu bar, labels, text fields, radio buttons, buttons, table, scroll pane, and event listeners.
  - The event listeners handle actions such as registering a user, clearing the form, loading data from the database, deleting records, etc.
  - The database connection and CRUD operations are performed using `JDBC` (Java Database Connectivity) with a MySQL database.
