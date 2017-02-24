package oldapi;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class MaxMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {


        private static final int MISSING = 9999;
        
        // Numero de la Columna del Dataset de donde vamos a buscar el valor maximo
        public static int col=5;

		public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
                
                // Como el fichero de datos cada columna está separada por el caracter , (coma)
				// Usamos el caracter , (coma) para dividir cada línea del fichero en el map en las columnas
                String line = value.toString();
                String[] parts = line.split(",");

                // Hacemos el collect de la key=1 y el valor de la columna (el valor corresponde con el número de columna
                // indicado anteriormente)
                output.collect(new Text("1"), new DoubleWritable(Double.parseDouble(parts[col])));
        }
}
