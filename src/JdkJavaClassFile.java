import com.sun.org.apache.bcel.internal.classfile.ClassParser;

import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;

/**
 * Created by acer01 on 2019/1/5/005.
 */
public class JdkJavaClassFile {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalClassFormatException {
        //这里换成自己的class包路径
        ClassParser classParser = new ClassParser(
                "G:\\githubs\\spring-boot-protocol\\target\\classes\\com\\github\\netty\\protocol\\servlet\\ServletContext.class");
        classParser.parse();
        System.out.println("end..");
    }

}
