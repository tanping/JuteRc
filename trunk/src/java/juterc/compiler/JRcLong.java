package juterc.compiler;

import org.apache.hadoop.record.compiler.Consts;

public class JRcLong extends JRcType {
  
  class JavaLong extends JavaType {
    
    JavaLong() {
      super("long", "Long", "Long", "TypeID.RIOType.LONG");
    }
    
    String getTypeIDObjectString() {
      return "org.apache.hadoop.record.meta.TypeID.LongTypeID";
    }

    void genHashCode(CodeBuffer cb, String fname) {
      cb.append(Consts.RIO_PREFIX + "ret = (int) ("+fname+"^("+
          fname+">>>32));\n");
    }
  }

  /** Creates a new instance of JLong */
  public JRcLong() {
    setJavaType(new JavaLong());
  }
  
  String getSignature() {
    return "l";
  }


}
