# Demo-Boot-Vue
This demo projects combines several technologies to a working project.
Spring boot 2 - Jpa repository (H2)  
VueJs - Axios - VueX - Webpack  
It has a backend module in spring boot that defines an api (with jpa support using H2 and actuator).  
It has a frontend module using VueJs that connects to the backend.  

It is written in Kotlin and uses gradle to build.

## Backend
Build using standard gradle build task then run using BootRun.  
The backend will run on 8088

## Frontend
For dev use 'npm run dev'. This will start a webpack dev server that will run on 8080 and wiill connect to 8088 for backend connection.  
For production use 'npm build' then use the CopyDist task to copy package to backend.  
Then run bootJar to create a runnable Jar file.

## Use-case
Only 1 use-case is included. User Login.  
There is a login page that will check user/password combination using teh backend.
Users are stored in the database.