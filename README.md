## Running a Simple Local Cluster

First, create a user-defined bridge network to allow the containers to communicate with each other: ```docker network create spark-network```.

Start the Spark master: ```docker run -d --name spark-master -p 4040:4040 -p 8080-8081:8080-8081 -p 7077:7077 --network spark-network -e SPARK_MODE=master bitnami/spark```.

Finally, start one or more workers: ```docker run -d --name spark-worker --network spark-network -e SPARK_MODE=worker -e SPARK_MASTER_URL=spark://spark-master:7077 bitnami/spark``` (change the name of the container and the allocated resources when running multiple Spark workers).

## Deploy Application to Cluster

Assemble the Scala project using ```sbt assembly```.

Submit the JAR file to the cluster by running ```docker run --rm -v /path/to/jar/:/spark-submit-dir/ --name spark-submit --network spark-network bitnami/spark spark-submit --master spark://spark-master:7077 --class nl.rug.sc.app.SparkSubmitMain --deploy-mode client  /spark-submit-dir/spark-bootcamp-assembly-0.1.jar```.

Of course, instead of directly mounting the directory into the container, the use of volumes would be preferred. Alternatively, it is possible to download Spark locally and use the submit script that comes with it to submit the application to the cluster. 