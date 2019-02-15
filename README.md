## Running a simple local cluster

First, create a user-defined bridge network to allow the containers to communicate with each other: ```sudo docker network create spark-network```.

Start the Spark master: ```sudo docker run -d --rm --name spark-master -p 4040:4040 -p 8080-8081:8080-8081 -p 7077:7077 --network spark-network gettyimages/spark bin/spark-class org.apache.spark.deploy.master.Master```.

Finally, start one or more workers: ```sudo docker run -d --rm --name spark-worker1 --network spark-network gettyimages/spark bin/spark-class org.apache.spark.deploy.worker.Worker spark://spark-master:7077``` (change the name of the container and the allocated resources when running multiple Spark workers).