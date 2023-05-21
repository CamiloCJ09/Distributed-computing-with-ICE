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


## Part 1 🎈
In this part we will learn how to test the timeout exception in a non concurrent system.
To execute a Bash script file, you can use the bash command or directly invoke the script file. Here are the steps to execute a Bash script file:

Make sure the script file has executable permissions. You can set the executable permission using the chmod command. For example, if your script file is named script.sh, you can run the following command to make it executable:

bash
```bash
chmod +x script.sh
Option 1: Using the bash command:
```
```bash
./script.sh
```
In this approach, you use the path to the script file directly, preceded by ./.

Note: Make sure you are in the correct directory or provide the full path to the script file when executing it.

By executing the Bash script file using one of the methods mentioned above, the commands and instructions in the script file will be executed sequentially in the Bash shell.

With this you can see how with different fibonacci numbers the system is no longer able to respond appropriately.
## Part 2 
The service must comply with the following:
1. with multithreading so that it can respond to multiple requests from different clients, concurrently. This concurrency is virtual or real? how can you prove it? attach a screenshot of the test.
2. answer, with this new version, the two points of Part I.
3. to allow a client to "register", with the hostname and what is necessary for callback.
4. as for the messages, if the message received:
    a. starts with "list clients", it must return the list of clients (hostnames or their prefix) registered on the server.
    b. starts with "to X:", you must send the following message to X, where X is the destination hostname (or its prefix).
    c. starts with "BC" (broadcast), the message must be returned by the server to ALL clients registered with it.
If we execute the code in the client and in the server through the client we will send the desired option at the same time that the server executes "out of session" the option and once it has it ready it sends the answer.