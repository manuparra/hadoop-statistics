# Basic statistical measures of massive datasets with APACHE HADOOP

Calculate MIN, MAX, AVG and STDDEV of one column on big data datasets with these Hadoop Applications.

These applications are the resolution of the exercises for the practices of the course of BigData within the Master in Science of Data of the University of Granada (March 2016). 

The practical master class has been done by Francisco J. Baldán and Manuel J. Parra.


Index of measures:

- [MIN](#min-of-a-column)
- [MAX](#max-of-a-column)
- [AVG](#avg-of-a-column)
- [STD DEV](#std-dev-of-a-column)




## MIN of a column

Code: [HADOOP MIN](./hadoop-min/)

### How to compile and execute:

```
# Compile
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-0.20-mapreduce/* -d min_classes Min.java MinMapper.java MinReducer.

# Create JAR

jar -cvf min.jar -C min_classes / .

# Execute 
hadoop jar min.jar oldapi.Min ./sample1.txt ./min/output_2/
```


## MAX of a column

Code: [HADOOP MAX](./hadoop-max/)

### How to compile and execute:

```
# Compile
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-0.20-mapreduce/* -d max_classes Max.java MaxMapper.java MaxReducer.

# Create JAR

jar -cvf max.jar -C max_classes / .

# Execute
hadoop jar max.jar oldapi.Max ./sample1.txt ./min/output_2/
```

## AVG of a column:

Code: [HADOOP AVG](./hadoop-avg/)

### How to compile and execute:

```
# Compile
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-0.20-mapreduce/* -d avg_classes Avg.java AvgMapper.java AvgReducer.

# Create JAR

jar -cvf avg.jar -C avg_classes / .

# Execute
hadoop jar avg.jar oldapi.Avg ./sample1.txt ./avg/output_2/
```



## STD DEV of a column:

Code: [HADOOP STD DEV](./hadoop-stddev/)

### How to compile and execute:

```
# Compile
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-0.20-mapreduce/* -d desv_classes Desv.java DesvMapper.java DesvReducer.

# Create JAR

jar -cvf desv.jar -C desv_classes / .

# Execute
hadoop jar desv.jar oldapi.Desv ./sample1.txt ./desv/output_2/
```

