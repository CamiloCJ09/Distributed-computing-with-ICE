#!/bin/bash
remote_clients=$(cat clients.txt) #Lee los clientes que estan en el archivo
ssh_pass_user="swarch" #Para ejecutar los comandos ssh y scp apoyados sshpass

cd ..
gradle clean 1>&2
echo "Desplegano maquinas y probando la funcion de fibbonacci"

gradle build -p client 1>&2

for client in "${remote_clients[@]}"; do
  # Usar sshpass para evitar tener que ingresar la contraseña manualmente
  #TODO: poner directorio 
  sshpass -p $ssh_pass_user  scp client/build/libs/*.jar $ssh_pass_user@"$client":/home/swarch/??
done

#TODO: implementar un el ciclo para ingresar por ssh y ejecutar el jar el en directorio 
#TODO: leer las entradas desde el archivo input.txt y agregarle el comando nohub para correr en segundo plano
#for client in "${remote_clients[@]}"; do
  
#done

