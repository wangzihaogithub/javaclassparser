### 这是一个java文件解析的类。 用一个类(只依赖jdk)实现了java文件解析，你可以用这个类获取局部变量表，字节码，行号等

 ---

* 这个类toString后是个json，你也可以直接使用get方法获取你需要的类信息（比如：常量池）。


### 你可以这样使用它（还有更多信息等你来用）. 提示：path参数可以从ClassLoader中获取

    // 示例1
    JavaClassFile javaClassFile = new JavaClassFile(MyBean.class);
    List<JavaClassFile.Attribute.LocalVariable[]> localVariableTableList = javaClassFile.getLocalVariableTableList();
    JavaClassFile.Member[] methods = javaClassFile.getMethods();
    JavaClassFile.Member helloMethod = javaClassFile.getMethod("hello", new Class[]{String.class, int.class}, void.class);
    String[] parameterNames = helloMethod.getParameterNames();
    JavaClassFile.Attribute.LocalVariable[] localVariableTable = helloMethod.getLocalVariableTable();

    // 示例2 
    JavaClassFile javaClassFile = new JavaClassFile(path,className);
    Member[] fields = javaClassFile.getFields();//字段
    Member[] methods = javaClassFile.getMethods();//方法
    ConstantPool constantPool = javaClassFile.getConstantPool();//你可以查看常量池
    Attribute[] attributes = javaClassFile.getAttributes();//你可以查看常量池
    Attribute.LocalVariable[] localVariables = attributes[0].localVariableTable();//你可以查看局部变量
    Opcodes opcodes = (Opcodes) attributes[0].get("opcodes");//你可以查看字节码
    String localVariablesName = localVariables[0].name();//局部变量名称
    
 ---
  
### 您能获得的数据如下图

* 例子

![](image/例子.jpg)

* 类依赖描述

![](image/类依赖描述.jpg)

* 方法区,局部变量表,程序指令地址

![](image/方法区局部变量表程序指令地址.jpg)

* 常量池

![](image/常量池.jpg)

* 字节码指令,栈深度

![](image/字节码栈深度.jpg)

* 数据结构如下

![](image/数据结构1.jpg)

![](image/数据结构2.jpg)

![](image/数据结构3.jpg)

 ---
 
作者邮箱 : 842156727@qq.com

github地址 : [https://github.com/wangzihaogithub/javaclassparser](https://github.com/wangzihaogithub/javaclassparser)
