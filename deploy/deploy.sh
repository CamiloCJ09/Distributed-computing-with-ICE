#!/bin/bash
clients=$(cat clients.txt | wc -l)
cd ..
gradle clean



echo "Deploy Server"
#Set de amount of clients 
sed -i "s/#Ice.ThreadPool.Server.Size=n/Ice.ThreadPool.Server.Size=$clients/g" server/src/main/resources/config.server
gradle build

cd server/build/libs || exit

sshpass -p "swarch" scp -o StrictHostKeyChecking=no -r ./*.jar swarch@10.147.19.158:/home/swarch/johanRicardo-CamiloCampaz/callback-server-deploy


cd ../..
echo "Deploy Clients"

#TODO: implement reading for all the clients choosen. read from clients.txt file

#TODO: create folder in clients machines 
