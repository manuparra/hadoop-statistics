package oldapi;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;


public class MaxReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	
		// Funcion Reduce:		
		public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {

		// Para extraer el Minimo usamos de valor incial el máximo de JAVA
		Double maxValue = Double.MIN_VALUE;
		
		// Leemos cada tupla  y nos quedamos con el menor valor
		while (values.hasNext()) {
			maxValue = Math.max(maxValue, values.next().get());
		}
		
		// Hacemos el collect con la key el valor mínimo encontrado en esta fase de reducción
		output.collect(key, new DoubleWritable(maxValue));
	}
}

