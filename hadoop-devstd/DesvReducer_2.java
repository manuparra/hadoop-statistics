package oldapi;
import java.io.IOException;
import java.util.Iterator;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
public class DesvReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
		Double sumDifValue = 0.0;
		//Double mean=-1.2354093582139625;
		//int cont = 31992921;
		//Iterator<DoubleWritable> values_aux=values;
		
		Collection<DoubleWritable> cache = new ArrayList<DoubleWritable>();
		while (values.hasNext()) cache.add(values.next());
		Iterator<DoubleWritable> values_aux = cache.iterator();

		Double sumValue = 0.0;
		Double count = 0.0;
		while (values_aux.hasNext()) {
			count=count+1.0;
			sumValue = sumValue+values_aux.next().get();
		}
		Double mean = sumValue/count;
		
		Iterator<DoubleWritable> values_aux2 = cache.iterator();

		while (values_aux2.hasNext()) {
			sumDifValue = sumDifValue+Math.pow(values_aux2.next().get()-mean,2);
		}
	output.collect(key, new DoubleWritable(sumDifValue/(count-1)));
	}
}

