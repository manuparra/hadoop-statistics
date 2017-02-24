# hadoop-min
Calculate MIN of one column in big data Datasets with this simply Hadoop Application 


## How to compile and execute:

```
# Compile
javac -cp /usr/lib/hadoop/*:/usr/lib/hadoop-0.20-mapreduce/* -d min_classes Min.java MinMapper.java MinReducer.

# Create JAR

jar -cvf min.jar -C min_classes / .

# Execute
hadoop jar min.jar oldapi.Min ./sample1.txt ./maxtemp/output_2/
```


