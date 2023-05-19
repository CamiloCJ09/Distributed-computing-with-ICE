#!/bin/bash
pass="swarch"
host="10.147.19.157"
folder="test-folder"
sshpass -p "$pass" ssh -o StrictHostKeyChecking=no $pass@$host "mkdir $folder"