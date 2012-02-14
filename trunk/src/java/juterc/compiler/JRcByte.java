package juterc.compiler;

/**
 * Because JRcByte needs to extend JRcType, it can not extends another class
 * JByte at the same time. We have to copy the majority code of
 * org.apache.hadoop.record.compiler.JByte here in order to keep all the 
 * functionality of JByte and add genRCWriteMethod and genRCReadMethod to it
 * which both are inheritated from JRcType.
 */

public class JRcByte extends JRcType{
  
  class JavaByte extends JavaType {
    JavaByte() {
      super("byte", "Byte", "Byte", "TypeID.RIOType.BYTE");
    }
    
    String getTypeIDObjectString() {
      return "org.apache.hadoop.record.meta.TypeID.ByteTypeID";
    }
  }

  public JRcByte() {
    setJavaType(new JavaByte());
  }
  
  String getSignature() {
    return "b";
  }
}
