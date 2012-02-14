package juterc.compiler;

import org.apache.hadoop.record.compiler.Consts;

import juterc.compiler.JRcType.JavaType;

public class JRcDouble extends JRcType{
  
  class JavaDouble extends JRcType.JavaType {
    
    JavaDouble() {
      super("double", "Double", "Double", "TypeID.RIOType.DOUBLE");
    }
    
    String getTypeIDObjectString() {
      return "org.apache.hadoop.record.meta.TypeID.DoubleTypeID";
    }

    void genHashCode(CodeBuffer cb, String fname) {
      String tmp = "Double.doubleToLongBits("+fname+")";
      cb.append(Consts.RIO_PREFIX + "ret = (int)("+tmp+"^("+tmp+">>>32));\n");
    }
  }
  
  /** Creates a new instance of JDouble */
  public JRcDouble() {
    setJavaType(new JavaDouble());
  }
  
  String getSignature() {
    return "d";
  }


}
