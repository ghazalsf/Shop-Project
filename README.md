# Project README

## Project Title: Shop

### Overview
Shop is a Java-based desktop application designed for a retail store. It utilizes SQLite for database management and Java Swing for the graphical user interface (GUI). The application supports two types of users: Admin and Regular Users. Users can browse products, add them to their cart, purchase items, view their information, and access a 'Contact Us' page. Admins have additional functionalities, such as editing product details and viewing user information.

### Features

#### Common Features
- **Product Display**: Products are displayed on the main page where they can be sorted by price and rating.
- **Search Functionality**: Users can search for products using a search bar.
- **Shopping Cart**: Users can add products to their shopping cart and proceed to purchase.
- **User Information**: Users can view and edit their personal information.
- **Contact Us Page**: Users can access a page with contact information for support.

#### Admin Features
- **Product Management**: Admins can add, edit, and delete products.
- **User Management**: Admins can view user details and manage user accounts.

### Installation

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/ghazalsf/Shop-Project
    ```
2. **Navigate to the Project Directory**:
    ```sh
    cd src/main/java/org/example/Main.java
    ```
3. **Set Up the Database**:
    - Ensure SQLite is installed on your machine.
    ```
4. **Compile and Run the Application**:
    ```sh
    javac -cp .:sqlite-jdbc-3.36.0.3.jar Main.java
    java -cp .:sqlite-jdbc-3.36.0.3.jar Main
    ```

### Usage

#### Regular Users
1. **Login**: Start the application and log in with your user credentials.
2. **Browse Products**: Products are listed on the main page, sortable by price and rating.
3. **Search**: Use the search bar to find specific products.
4. **Add to Cart**: Select products and add them to your shopping cart.
5. **Purchase**: Proceed to checkout and complete your purchase.
6. **User Info**: View and edit your personal information from the 'Profile' section.
7. **Contact Us**: Access the 'Contact Us' page for support information.

#### Admin Users
1. **Login**: Start the application and log in with your admin credentials.
2. **Manage Products**: Access the 'Admin Panel' to add, edit, or delete products.
3. **View Users**: View user information and manage user accounts.

### Project Structure

```
Shop/
│
|
├── src/
│   ├── Main.java
│   ├── Admin.java
│   ├── Human.java
│   ├── Product.java
│   ├── User.java
│   ├── StartGui.java
│   ├── GuiUser
│   ├── GuiUser
│   └── GuiAdmin/
│   ├── models/
│      ├── ConnectDB
│      └── ManageDB/

```

### Dependencies
- Java SE Development Kit (JDK)
- SQLite
- SQLite JDBC Driver


### Contact
For any inquiries, please contact us.
