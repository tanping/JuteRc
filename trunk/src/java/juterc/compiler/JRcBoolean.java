package juterc.compiler;

/**
 * Because JRcBoolean needs to extend JRcType, it can not extends another class
 * JBoolean at the same time. We have to copy the majority code of
 * org.apache.hadoop.record.compiler.JBoolean here in order to keep all the 
 * functionality of JBoolean and add genRCWriteMethod and genRCReadMethod to it
 * which both are inheritated from JRcType.
 */

import org.apache.hadoop.record.compiler.Consts;


public class JRcBoolean extends JRcType{
  
  class JavaBoolean extends JRcType.JavaType {
    
    JavaBoolean() {
      super("boolean", "Bool", "Boolean", "TypeID.RIOType.BOOL");
    }
    
    void genCompareTo(CodeBuffer cb, String fname, String other) {
      cb.append(Consts.RIO_PREFIX + "ret = ("+fname+" == "+other+")? 0 : ("+
          fname+"?1:-1);\n");
    }
    
    String getTypeIDObjectString() {
      return "org.apache.hadoop.record.meta.TypeID.BoolTypeID";
    }

    void genHashCode(CodeBuffer cb, String fname) {
      cb.append(Consts.RIO_PREFIX + "ret = ("+fname+")?0:1;\n");
    }
  }
  

  /** Creates a new instance of JBoolean */
  public JRcBoolean() {
    setJavaType(new JavaBoolean());
  }
  
  String getSignature() {
    return "z";
  }


}
