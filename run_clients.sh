#!/bin/bash
clientsFile="hosts.txt"
argsFile="input.txt"
machine=1
clients=("xhgrid1" "xhgrid2" "xhgrid3")
args=("40" "47" "50")


#mapfile -t clients < "$hosts"
#mapfile -t args < "$numbers"
#IFS=','
#while IFS= read -r line; do
#     IFS=',' read -ra elements <<< "$line"
#    clients+=("${elements[@]}")
#done < "$clientsFile"

#while IFS= read -r line; do
  #   IFS=',' read -ra elements <<< "$line"
 #   args+=("${elements[@]}")
#done < "$argsFile"

echo "enviando archivos jar"

for client in "${clients[@]}";do
  cd client/build/libs || exit
  echo "enviando jar al cliente swarch@$client"
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no  client.jar swarch@"$client":/home/swarch/deploy-fibbo 
   #sshpass -p "swarch" scp -o StrictHostKeyChecking=no  ice-3.7.6.jar swarch@xhgrid"$client":/home/swarch/deploy-fibbo 
  cd ../../.. || exit
done

machine=1
echo "Ejecutando archivos jar"
for arg in "${args[@]}";do
 trimed_arg="$(echo -e "${arg}" | sed -e 's/[[:space:]]*$//')"
 for client in "${clients[@]}";do
    echo "ejecutando archivo jar en $client"
    echo "se esta probando con el valor $trimed_arg"
    sshpass -p "swarch" ssh -o StrictHostKeyChecking=no swarch@"$client" "cd deploy-fibbo; nohup java -jar client.jar $trimed_arg >> output_$machine.txt 2>&1" &
    ((machine++))
  done
  machine=1
done 

wait

echo "Obteniendo reportes"
machine=1
for client in "${clients[@]}";do
  echo "reporte de $client"
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no swarch@"$client":/home/swarch/deploy-fibbo/output_$machine.txt  ./reports
  ((machine++))
done

cd reports || exit


cat output_*.txt > finalLog.txt

rm output_*.txt


  
