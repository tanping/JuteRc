package juterc.compiler;

public class JRcInt extends JRcType {
  
  class JavaInt extends JavaType {
    
    JavaInt() {
      super("int", "Int", "Integer", "TypeID.RIOType.INT");
    }
    
    String getTypeIDObjectString() {
      return "org.apache.hadoop.record.meta.TypeID.IntTypeID";
    }
  }


  /** Creates a new instance of JInt */
  public JRcInt() {
    setJavaType(new JavaInt());
  }
  
  String getSignature() {
    return "i";
  }


}
