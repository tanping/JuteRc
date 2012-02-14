package juterc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.io.RCFile;
import org.apache.hadoop.hive.ql.io.RCFileOutputFormat;
import org.apache.hadoop.hive.serde2.columnar.BytesRefArrayWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.compress.DefaultCodec;

import org.junit.Test;


import junit.framework.Assert;

public class TestRc{

  private static Configuration conf = new Configuration();

  private static Path file;

  private static FileSystem fs;
  
  static {
    try {
      fs = FileSystem.getLocal(conf);
    } catch ( IOException e ) {
      e.printStackTrace();
    }
    Path dir = new Path(System.getProperty("test.data.dir", "./target")+"/TestMetaData");
    file = new Path(dir, "test_rcfile");
    try {
      fs.delete(dir, true);
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void testRc() throws IOException{
    int filedsNumber = 2;
    fs.delete(file, true);
    
    RCFileOutputFormat.setColumnNumber(conf, filedsNumber);
    RCFile.Writer writer;
    
    writer = new RCFile.Writer(fs, conf, file, null,
          new DefaultCodec());
    
    writer.append(new MyDataType("name1", "m"));
    writer.append(new MyDataType("name2", "f"));
    writer.append(new MyDataType("name3", "f"));

    writer.close();
    
    // Reader to read back
    RCFile.Reader reader = new RCFile.Reader(fs, file, conf);
    LongWritable rowID = new LongWritable();
    
    List<MyDataType> dtList = new ArrayList<MyDataType>();
    for ( int i = 0; i < 3; i++) {
      reader.next(rowID);
      BytesRefArrayWritable cols = new BytesRefArrayWritable();
      reader.getCurrentRow(cols);
      cols.resetValid(filedsNumber);
      MyDataType dt = new MyDataType();
      dt.deserialize(cols);
      System.out.println("Record["+rowID+"]: "+ dt.getName() +"\t" +dt.getGenda());
      dtList.add(dt);
    }
    reader.close();
    
    int fCount = 0;
    for (MyDataType dt : dtList) {
      if (dt.getGenda().equals("f")) {
        fCount++;
      }
    }
    Assert.assertEquals(2, fCount);
    System.out.println("Test: TestRc passed.");
  }
}
