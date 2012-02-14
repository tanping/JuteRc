package juterc.compiler;

import org.apache.hadoop.record.compiler.Consts;

public class JRcFloat extends JRcType{
  
  class JavaFloat extends JavaType {
    
    JavaFloat() {
      super("float", "Float", "Float", "TypeID.RIOType.FLOAT");
    }
    
    String getTypeIDObjectString() {
      return "org.apache.hadoop.record.meta.TypeID.FloatTypeID";
    }

    void genHashCode(CodeBuffer cb, String fname) {
      cb.append(Consts.RIO_PREFIX + "ret = Float.floatToIntBits("+fname+");\n");
    }
  }


  /** Creates a new instance of JFloat */
  public JRcFloat() {
    setJavaType(new JavaFloat());
  }
  
  String getSignature() {
    return "f";
  }


}
