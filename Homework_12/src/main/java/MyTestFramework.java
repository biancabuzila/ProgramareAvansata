import java.io.File;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyTestFramework {
    static URLClassLoader urlcl;

    public static void main(String[] args) throws Exception {
        exploreFile(new File(args[0]));
        System.out.println();
        exploreFile(new File(args[1]));
        System.out.println();
        invokeTest(new File(args[1]));
    }

    public static void exploreFile(File inputFile) throws ClassNotFoundException, IllegalArgumentException, MalformedURLException {
        File[] fileList = inputFile.listFiles();
        for (File file : fileList) {
            if (file.isDirectory()) {
                if (file.getName().equals("classes")) {
                    File f = new File(file.getAbsolutePath());
                    URL[] cp = {f.toURI().toURL()};
                    urlcl = new URLClassLoader(cp);
                }
                exploreFile(file);
            } else {
                if (file.toString().endsWith(".class")) {
                    String className = file.getName().substring(0, file.getName().length() - 6);
                    Class<?> clazz = urlcl.loadClass(className);

                    System.out.println("Class " + className);
                    //fields
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields)
                        System.out.println("        " + field.getType() + " " + field.getName() + ";");
                    //constructors
                    Constructor<?>[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor<?> constructor : constructors) {
                        System.out.print("        " + constructor.getName() + "(");
                        for (Parameter param : constructor.getParameters()) {
                            System.out.print(param.getType());
                            if (!param.equals(Arrays.stream(constructor.getParameters()).toList().get(constructor.getParameterCount() - 1)))
                                System.out.print(", ");
                        }
                        System.out.println(");");
                    }
                    //methods
                    Method[] methods = clazz.getDeclaredMethods();
                    for (Method m : methods) {
                        System.out.print("        " + m.getName() + "(");
                        for (Parameter param : m.getParameters()) {
                            System.out.print(param.getType());
                            if (!param.equals(Arrays.stream(m.getParameters()).toList().get(m.getParameterCount() - 1)))
                                System.out.print(", ");
                        }
                        System.out.println(");");
                    }
                }
            }
        }
    }

    public static void invokeTest(File inputFile) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        File[] fileList = inputFile.listFiles();
        int passed, failed;
        for (File file : fileList)
            if (file.isDirectory()) {
                invokeTest(file);
            } else if (file.toString().endsWith(".class") &&
                    Class.forName(file.getName().substring(0, file.getName().length() - 6)).isAnnotationPresent(Test.class)) {
                String className = file.getName().substring(0, file.getName().length() - 6);
                Object object;
                List<Object> parameters;
                Random random = new Random();
                passed = failed = 0;
                for (Method m : Class.forName(className).getMethods()) {
                    if (m.isAnnotationPresent(Test.class) && Modifier.isPublic(m.getModifiers())) {
                        if (Modifier.isStatic(m.getModifiers()))
                            object = null;
                        else object = Class.forName(className).getConstructor().newInstance();

                        parameters = new ArrayList<>();
                        for (Class<?> param : m.getParameterTypes())
                            switch (param.getName()) {
                                case "int" -> parameters.add(random.nextInt(200));
                                case "java.lang.String" -> parameters.add(randomString(random.nextInt(20)));
                                case "boolean" -> parameters.add(random.nextBoolean());
                            }

                        try {
                            m.invoke(object, parameters.toArray());
                            passed++;
                        } catch (Throwable ex) {
                            System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                            failed++;
                        }
                    }
                }
                System.out.printf("Passed: %d, Failed %d%n", passed, failed);
            }
    }

    public static String randomString(int n) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (str.length() * Math.random());
            sb.append(str.charAt(index));
        }
        return sb.toString();
    }
}
