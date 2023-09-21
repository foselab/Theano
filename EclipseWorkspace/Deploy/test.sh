java -jar Theano.jar -i ./Table1.rt -o ./UeArFsTable1.py -e UeArFs -t consistency

python3 ./UeArFsTable1.py

java -jar Theano.jar -i ./Table2.rt -o ./UeArFsTable2.py -e UeArFs -t consistency

python3 ./UeArFsTable2.py

java -jar Theano.jar -i ./Table3.rt -o ./UeArFsTable3.py -e UeArFs -t consistency

python3 ./UeArFsTable3.py
