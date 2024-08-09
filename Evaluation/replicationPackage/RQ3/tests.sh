echo "\n\n*************************\n"
echo "Consistency Check\n"
echo "*************************\n"

echo "Requirements Table v1"
java -jar Theano.jar -i ./ATv1.rt -o ./scripts/ATv1Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv1Consistency.py

echo "Requirements Table v2"
java -jar Theano.jar -i ./ATv2.rt -o ./scripts/ATv2Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv2Consistency.py

echo "Requirements Table v3"
java -jar Theano.jar -i ./ATv3.rt -o ./scripts/ATv3Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv3Consistency.py

echo "Requirements Table v4"
java -jar Theano.jar -i ./ATv4.rt -o ./scripts/ATv4Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv4Consistency.py

echo "Requirements Table v5"
java -jar Theano.jar -i ./ATv5.rt -o ./scripts/ATv5Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv5Consistency.py

echo "Requirements Table v6"
java -jar Theano.jar -i ./ATv6.rt -o ./scripts/ATv6Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv6Consistency.py

echo "Requirements Table v7"
java -jar Theano.jar -i ./ATv7.rt -o ./scripts/ATv7Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv7Consistency.py

echo "Requirements Table v8"
java -jar Theano.jar -i ./ATv8.rt -o ./scripts/ATv8Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv8Consistency.py

echo "Requirements Table v9"
java -jar Theano.jar -i ./ATv9.rt -o ./scripts/ATv9Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv9Consistency.py

echo "Requirements Table v10"
java -jar Theano.jar -i ./ATv10.rt -o ./scripts/ATv10Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv10Consistency.py

echo "Requirements Table v11"
java -jar Theano.jar -i ./ATv11.rt -o ./scripts/ATv11Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv11Consistency.py

echo "Requirements Table v12"
java -jar Theano.jar -i ./ATv12.rt -o ./scripts/ATv12Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv12Consistency.py

echo "Requirements Table v13"
java -jar Theano.jar -i ./ATv13.rt -o ./scripts/ATv13Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv13Consistency.py

echo "Requirements Table v14"
java -jar Theano.jar -i ./ATv14.rt -o ./scripts/ATv14Consistency.py -e BeUfFs -t consistency -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv14Consistency.py


echo "\n\n*************************\n"
echo "Completeness Check\n"
echo "*************************\n"

echo "Requirements Table v1"
java -jar Theano.jar -i ./ATv1.rt -o ./scripts/ATv1Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv1Completeness.py

echo "Requirements Table v2"
java -jar Theano.jar -i ./ATv2.rt -o ./scripts/ATv2Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv2Completeness.py

echo "Requirements Table v3"
java -jar Theano.jar -i ./ATv3.rt -o ./scripts/ATv3Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv3Completeness.py

echo "Requirements Table v4"
java -jar Theano.jar -i ./ATv4.rt -o ./scripts/ATv4Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv4Completeness.py

echo "Requirements Table v5"
java -jar Theano.jar -i ./ATv5.rt -o ./scripts/ATv5Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv5Completeness.py

echo "Requirements Table v6"
java -jar Theano.jar -i ./ATv6.rt -o ./scripts/ATv6Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv6Completeness.py

echo "Requirements Table v7"
java -jar Theano.jar -i ./ATv7.rt -o ./scripts/ATv7Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv7Completeness.py

echo "Requirements Table v8"
java -jar Theano.jar -i ./ATv8.rt -o ./scripts/ATv8Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv8Completeness.py

echo "Requirements Table v9"
java -jar Theano.jar -i ./ATv9.rt -o ./scripts/ATv9Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv9Completeness.py

echo "Requirements Table v10"
java -jar Theano.jar -i ./ATv10.rt -o ./scripts/ATv10Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv10Completeness.py

echo "Requirements Table v11"
java -jar Theano.jar -i ./ATv11.rt -o ./scripts/ATv11Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv11Completeness.py

echo "Requirements Table v12"
java -jar Theano.jar -i ./ATv12.rt -o ./scripts/ATv12Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv12Completeness.py

echo "Requirements Table v13"
java -jar Theano.jar -i ./ATv13.rt -o ./scripts/ATv13Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv13Completeness.py

echo "Requirements Table v14"
java -jar Theano.jar -i ./ATv14.rt -o ./scripts/ATv14Completeness.py -e BeUfFs -t completeness -b 33 > /dev/null 2>&1
timeout 10 python3 ./scripts/ATv14Completeness.py
