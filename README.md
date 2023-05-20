# Distributed-computing-with-ICE
Project with ICE and distributed programming and making a fibonacci algorithm   

We will use Gradle to create our application projects. You must install Gradle before continuing with this tutorial.
Open a new Command Prompt and run the following commands to generate a new project:

The main design goals of **Ice** are:

- Provide an object-oriented RPC framework suitable for use in heterogeneous environments.
- Provide a full set of features that support development of realistic distributed applications for a wide variety of domains.
- Avoid unnecessary complexity, making the platform easy to learn and to use.
- Provide an implementation that is efficient in network bandwidth, memory use, and CPU overhead.
- Provide an implementation that has built-in security, making it suitable for use over insecure public networks.


## Configuration 👓

For this demo we're going to use a project with two sub-projects to build the Client and Server applications. The requirements for our sub-projects are the same so we'll do all the setup in the subprojects block of the root project, which applies to all sub-projects. Edit the generated build.gradle file to look like the one below:

```gradle
...
"Class-Path": configurations.runtimeClasspath.resolve().collect { it.toURI() }.join(' ')
...
```

We must also edit the generated settings.gradle to define our sub-projects:

```gradle
rootProject.name = 'printer'
include 'client'
include 'server'
```

## Compiling the client and server ⭐️

```bash
./gradlew :server:build
./gradlew :client:build
```

## Run the java jars to execute the program 🎇
Configure the host of the server in the config.server file
```bash
java -jar server/build/libs/server.jar
java -jar client/build/libs/client.jar
```
The client runs and exits without producing any output; however, in the server window, we see the fibonaccidd that is produced by the printer. To get rid of the server, we interrupt it on the command line for now. 

## Now you can run the clients automatically  🎇
use the script <b>run_clients.sh</b> and send all the jar files remotly <br> and check the ouput in the file <b>finalLog.txt</b> to the their behaivour with multiple requests to the server , all al the same time.

You can also check a report that explain the results of this test [here]()