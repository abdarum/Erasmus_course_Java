set root_path=%0
TITLE OurLib
cd src
mvn install & java -jar target\library-spring-api-1.0.0.jar 
