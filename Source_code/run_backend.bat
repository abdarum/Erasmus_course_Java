TITLE Backend Rest API server - Spring
cd RestAPI\src
mvn install & java -javaagent:%homepath%\.m2\repository\org\springframework\spring-instrument\5.0.5.RELEASE\spring-instrument-5.0.5.RELEASE.jar -javaagent:%homepath%\.m2\repository\org\aspectj\aspectjweaver\1.8.12\aspectjweaver-1.8.12.jar -jar target\library-spring-api-1.0.0.jar 
rem static directory
