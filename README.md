# 🍽OOPDinner
- OOPDinner: is a project for Object Oriented Programming of our student group.
- Topic: Restaurant chain management website.

### User roles: 
- **Client** can view menu with paginating, sorting and filtering; add dishes to cart, change count or delete them from cart. Can make an order and observe status of order.
- **Manager/Employee** can view all orders with filtering, change their status.

## Database schema
(Update later)
  
## Used technologies
- Java EE, java 21
  - Servlets
  - Filters
  - Listeners
  - JSP
- MySql (used standart JDBC for connection)
## Used patterns
- MVC
- DAO
- Abstract factory for dao for different databases
- Singleton for ConnectionPool
- Builder for model
## Set up project
- The app uses MySql database. If you don't have it, you should download it <a href="https://dev.mysql.com/downloads/">here</a>
- Clone current repository
- Set your database connect rules in ``` myRestaurantOopPrj/src/main/webapp/META-INF/context.xml ```
- Run ``` myRestaurantOopPrj/sql/create_oopdinnerdb.sql ``` to set up database on your devise
- Build app with (recomended) Maven, or using .war file at submit/ forder 
- Run app using servlet container (Recommended Tomcat v.9.0.52)
- Use âpp in your browser
## Screenshots
### For user
<details>
<summary>Show</summary>

<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/about.png?token=GHSAT0AAAAAAC2NSP5RLDXWB5BJQAWLESNAZ2EYMLQ" width="800" /><br>
<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/account.png?token=GHSAT0AAAAAAC2NSP5QUTIRAROLJYOGW5T2Z2EYO2A" width="800" /><br>
<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/signup.png?token=GHSAT0AAAAAAC2NSP5R54J3CYT5O7EYBQEKZ2EYPYQ" width="800" /><br>
<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/changeinfo.png?token=GHSAT0AAAAAAC2NSP5RVOZYPWSZ2P5IQJN6Z2EYPIA" width="800" /><br>
<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/changepassword.png?token=GHSAT0AAAAAAC2NSP5QZMAPDNFO27OBH3ZIZ2EYPKA" width="800" /><br>
<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/cart.png?token=GHSAT0AAAAAAC2NSP5RFMC52DQLPUZ6GEQIZ2EYPEQ" width="800" /><br>
<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/findtable.png?token=GHSAT0AAAAAAC2NSP5RV2ALWKLNCEHAU6OQZ2EYPMA" width="800" /><br>
<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/menu.png?token=GHSAT0AAAAAAC2NSP5RC3WPK3YWDLEDAEU2Z2EYPVQ" width="800" /><br>
<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/login.png?token=GHSAT0AAAAAAC2NSP5QPG5AC6YK7JZHVUHSZ2EYPRQ" width="800" /><br>
</details>

### For manager/employee

<details>
<summary>Show</summary>

<img src="https://raw.githubusercontent.com/tientt3006/myRestaurantOopPrj/refs/heads/main/submit/manager.png?token=GHSAT0AAAAAAC2NSP5QDVQCW3SJ43VUGJQKZ2EYPUA" width="800" /><br>

</details>

## License
Copyright (c) 2024 Team 03.14 <br>
Clone and develop from github  <a href="https://github.com/denbondd/restaurant">denbond/restaurant</a><br>
<a href="./LICENSE">MIT License</a> <br>

