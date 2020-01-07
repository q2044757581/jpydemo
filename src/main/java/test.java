import org.python.core.Py;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        // 2. 面向对象式编程: 在Java中调用Python对象实例的方法
        String pythonClass = "src/demo.py";
        // python对象名
        String pythonObjName = "t";
        // python类名
        String pythonClazzName = "PersonConsumerCallback";
        PythonInterpreter pi2 = new PythonInterpreter();
        // 加载python程序
        pi2.execfile(pythonClass);
        // 实例化python对象
        pi2.exec(pythonObjName + "=" + pythonClazzName + "()");
        // 获取实例化的python对象
        PyObject pyObj = pi2.get(pythonObjName);
        // 调用python对象方法,传递参数并接收返回值
        PyObject result = pyObj.invoke("say_words", new PyObject[] {Py.newString("hello cyp")});
        Boolean java_result = Py.py2boolean(result);
        System.out.println(java_result);
        pi2.cleanup();
        pi2.close();
    }
}
