package juterc.compiler;

import org.apache.hadoop.record.compiler.Consts;

public class JRcBuffer extends JRcCompType {
  
  class JavaBuffer extends JavaCompType {
  JavaBuffer() {
    super("org.apache.hadoop.record.Buffer", "Buffer", 
        "org.apache.hadoop.record.Buffer", "TypeID.RIOType.BUFFER");
  }
  
  String getTypeIDObjectString() {
    return "org.apache.hadoop.record.meta.TypeID.BufferTypeID";
  }

  void genCompareTo(CodeBuffer cb, String fname, String other) {
    cb.append(Consts.RIO_PREFIX + "ret = "+fname+".compareTo("+other+");\n");
  }
  
  void genEquals(CodeBuffer cb, String fname, String peer) {
    cb.append(Consts.RIO_PREFIX + "ret = "+fname+".equals("+peer+");\n");
  }
  
  void genHashCode(CodeBuffer cb, String fname) {
    cb.append(Consts.RIO_PREFIX + "ret = "+fname+".hashCode();\n");
  }
  }
  /** Creates a new instance of JBuffer */
  public JRcBuffer() {
    setJavaType(new JavaBuffer());
  }
  
  String getSignature() {
    return "B";
  }
}
