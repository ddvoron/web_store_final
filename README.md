Проект - учебный. Для сборки и запуска данного приложения потребуется:

SOFT: jdk 1.8
      Apache Tomcat 9.0.0.M13 (user: tomcat; password: tomcat) - http://localhost:8080/web/  - для запуска
      hibernate 5.2.6.Final
      spring 4.3.6.RELEASE
      javax.servlet-api 3.1.0
      mysql-driver 5.1.38
      hicariCP2.5.1 
      lombok 1.16.12
      ehcache 2.10.3
      jsp-api 2.0
      jstl 1.2
      aspectj 1.7.3
      cglib 3.2.4
      tiles 3.0.5
      
DataBase connection (Mysql mariaDB):
      url - jdbc:mysql://localhost:2016/webstore_hib
      user - root
      password - 
      
Вход в приложение админ:
      Login - superman
      Password - superman

TODO - хранить добавленные товары в сессии без авторизации, перенос в корзину после аутентификации
TODO - уменьшить объем передаваемой информации - use JSON
TODO - коррекция верстки admin/users menu
TODO - перенос на @REST CONTROLLER максимально
