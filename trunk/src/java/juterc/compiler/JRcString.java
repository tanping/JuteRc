package juterc.compiler;

import org.apache.hadoop.record.compiler.Consts;

public class JRcString extends JRcCompType {
    
  class JavaString extends JavaCompType {
    
    JavaString() {
      super("String", "String", "String", "TypeID.RIOType.STRING");
    }
    
    String getTypeIDObjectString() {
      return "org.apache.hadoop.record.meta.TypeID.StringTypeID";
    }
    
    void genClone(CodeBuffer cb, String fname) {
      cb.append(Consts.RIO_PREFIX + "other."+fname+" = this."+fname+";\n");
    }
  }

  
  /** Creates a new instance of JString */
  public JRcString() {
    setJavaType(new JavaString());
  }
    
  String getSignature() {
    return "s";
  }


}
