NB_NODES=3
MEMORY=60G
numactl -m $NB_NODES -N $NB_NODES \
	java -Xms$MEMORY -Xmx$MEMORY -Dqfs.pool.nodes=$NB_NODES \
		-jar `pwd`/target/activepivot-sandbox-jdbc-1.0.0-SNAPSHOT.jar
