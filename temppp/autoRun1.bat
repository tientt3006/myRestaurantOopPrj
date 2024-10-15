@echo off
REM Đặt các biến cho các đường dẫn
set TOMCAT_HOME=E:\ProgramFile\apache-tomcat-9.0.95-windows-x64\apache-tomcat-9.0.95
set PROJECT_HOME=E:\HK_PTIT\myRestaurantPrj
set WAR_NAME=myRestaurantPrj-1.0-SNAPSHOT.war

REM Bước 1: Dừng Tomcat
echo Stopping Tomcat...
cd %TOMCAT_HOME%\bin
pause
call "%TOMCAT_HOME%\bin\shutdown.bat"
pause

REM Bước 2: Xóa file .war và thư mục cùng tên trong thư mục webapps của Tomcat
echo Removing old WAR file and directory...
cd %TOMCAT_HOME%\webapps
pause
IF EXIST %WAR_NAME% del /F /Q %WAR_NAME%
IF EXIST %WAR_NAME:\.war=% rmdir /S /Q %WAR_NAME:\.war=%
pause

REM Bước 3: Chuyển sang thư mục project và build lại ứng dụng
echo Building the project...
cd %PROJECT_HOME%
pause
call mvn clean package || (
    echo Maven build failed. Please check the error logs.
    pause
    exit /b
)
pause

REM Bước 4: Copy file .war mới sang thư mục webapps của Tomcat
echo Deploying the new WAR file...
copy %PROJECT_HOME%\target\%WAR_NAME% %TOMCAT_HOME%\webapps\
pause

REM Bước 5: Khởi động lại Tomcat
echo Starting Tomcat...
cd %TOMCAT_HOME%\bin
pause
call "%TOMCAT_HOME%\bin\startup.bat"
pause

echo Deployment completed successfully.
pause
