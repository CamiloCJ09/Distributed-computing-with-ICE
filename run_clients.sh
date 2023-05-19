#!/bin/bash
file="clients.txt"
numbers=7000
machine=1

mapfile -t clients < "$file"


for client in "${clients[@]}";do
  cd client/build/libs || exit
  echo "enviando archivos jar a xhgrid$machine"
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no  client.jar swarch@xhgrid$machine:/home/swarch/deploy-fibbo 
   sshpass -p "swarch" scp -o StrictHostKeyChecking=no  ice-3.7.6.jar swarch@xhgrid$machine:/home/swarch/deploy-fibbo 
  cd ../../.. || exit
  ((machine++))
done
machine=1
echo "Ejecutando archivos jar"
for client in "${clients[@]}";do
  echo "ejecutando archivo jar en xhgrid$machine"
  sshpass -p "swarch" ssh -o StrictHostKeyChecking=no swarch@xhgrid$machine "cd deploy-fibbo; nohup java -cp "./*" Client $numbers > output.txt 2>&1" &
  ((machine++))
done

wait

echo "Obteniendo reportes"
machine=1
for client in "${clients[@]}";do
  echo "reporte de xhgrid$machine"
  sshpass -p "swarch" scp -o StrictHostKeyChecking=no swarch@xhgrid$machine:/home/swarch/deploy-fibbo/output.txt ./report/log_"$client".txt
  ((machine++))
done

cd reports || exit

cat log_*.txt > finalLog.txt


