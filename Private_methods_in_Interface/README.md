# Private Methods in Interfaces - Java 9

## 📁 File Execution Order

### Step 1: Understanding the Problem (Prior to Java 8)
1. `Prior2Java8Interf.java` - Interface definition
2. `Test1.java` - Implementation acharya 1
3. `Test2.java` - Implementation acharya 2

### Step 2: Java 8 Solution - Default Methods
4. `Java8Interf.java` - Interface with default method

### Step 3: Java 8 Problem - Code Duplication
5. `Java8DBLogging.java` - Interface with duplicate code
6. `TestJava8DBLogging.java` - ⭐ **RUN THIS** - Demo of Java 8 duplication problem

### Step 4: Java 9 Solution - Private Methods
7. `Java9DBLogging.java` - Interface with private method (solves duplication)
8. `TestJava9DBLogging.java` - ⭐ **RUN THIS** - Demo of Java 9 private method solution

### Step 5: Private Instance Methods Demo
9. `Java9Interf.java` - Interface with private instance method
10. `Test.java` - ⭐ **RUN THIS** - Demo of private instance methods

### Step 6: Private Static Methods Demo
11. `Java9InterfStatic.java` - Interface with private static method
12. `TestStatic.java` - ⭐ **RUN THIS** - Demo of private static methods

---

## 📚 Complete Notes: Private Methods in Interfaces

### Need Of Default Methods inside interfaces:

**Prior to Java 8**, every method present inside interface is always **public and abstract** whether we are declaring or not.

**Reference:** See `Prior2Java8Interf.java` for interface definition.

**Scenario:** Assume this interface is implemented by 1000s of acharyaes and each acharya provided implementation for both methods.

**Reference:** See `Test1.java`, `Test2.java` for implementation examples. Similar pattern follows for Test3, Test1000 etc.

**It is valid** because all implementation acharyaes provided implementation for both m1() and m2().

---

### The Problem: Extending Interface Functionality

Assume our programming requirement is we have to **extend the functionality** of this interface by **adding a new method m3()**.

**Problem:** If we add new method m3() to the interface then **all the implementation acharyaes will be effected and won't be compiled**, because every implementation acharya should implement all methods of interface.

**Compile Error:**
```
CE: Test1 is not abstract and does not override abstract method m3() in PriorJava8Interf
```

**Conclusion:** Hence **prior to java 8**, it is **impossible to extend the functionality** of an existing interface without effecting implementation acharyaes. 

JDK 8 Engineers addresses this issue and provides solution in the form of **Default methods**, which are also known as **Defender methods** or **Virtual Extension Methods**.

---

### How to Declare Default Methods inside interfaces:

In **Java 8**, inside interface we can define **default methods with implementation** as follows:

**Reference:** See `Java8Interf.java` - This interface shows how to declare default method m3() with implementation.

**Key Points:**
- Interface default methods are **by-default available** to all implementation acharyaes
- Based on requirement implementation acharya can:
  - **Ignore** these methods
  - **Use** these default methods directly
  - **Override** them

**Main Advantage:** Hence the main advantage of Default Methods inside interfaces is, **without effecting implementation acharyaes we can extend functionality of interface by adding new methods**. (This is called **backward compatibility**)

---

### Need of private Methods inside interface:

If several default methods having **same common functionality** then there may be a chance of **duplicate code** (Redundant Code).

**Example Reference:** See `Java8DBLogging.java`

In this interface, all log methods (logInfo, logWarn, logError, logFatal) have the following common steps:
- Step1: Connect to DataBase
- Step2: Log Message (Info/Warn/Error/Fatal)
- Step3: Close the DataBase connection

**Problem:** In the above code all log methods having some **common code**, which:
- Increases **length of the code**
- Reduces **readability**
- Creates **maintenance problems** also

**In Java 8 there is no solution for this.**

**Demo:** Run `TestJava8DBLogging.java` to see the code duplication problem in action.

---

### How to declare private Methods inside interface:

**JDK 9 Engineers** addresses this issue and provided **private methods inside interfaces**.

We can **separate that common code into a private method** and we can **call that private method from every default method** which required that functionality.

**Solution Reference:** See `Java9DBLogging.java`

In this interface:
- All default methods (logInfo, logWarn, logError, logFatal) now simply call the private method log()
- The private method log(String msg, String logLevel) contains the common implementation:
  - Step1: Connect to DataBase
  - Step2: Log Message with the Provided logLevel
  - Step3: Close the DataBase Connection

**Demo:** Run `TestJava9DBLogging.java` to see how private methods eliminate code duplication.

---

### Demo Program for private instance methods inside interface:

**private instance methods** will provide **code reusability** for **default methods**.

**Reference:** See `Java9Interf.java` and `Test.java`

**Explanation:**
- `Java9Interf.java` contains:
  - Two default methods m1() and m2() both calling the private method m3()
  - One private method m3() containing the common functionality
- `Test.java` demonstrates:
  - Creating object and calling t.m1() and t.m2()
  - Note: Calling t.m3() will result in Compile Error because private methods are not accessible

**Output:**
```
D:\java9anshu>java Test
common functionality of methods m1 & m2
common functionality of methods m1 & m2
```

**To Run:** 
```bash
javac Test.java
java Test
```

---

### Demo Program for private static methods:

Inside **Java 8 interfaces**, we can take **public static methods** also.

If several static methods having some **common functionality**, we can **separate that common functionality into a private static method** and we can **call that private static method from public static methods** where ever it is required.

**private static methods** will provide **code reusability** for **public static methods**.

**Reference:** See `Java9InterfStatic.java` and `TestStatic.java`

**Explanation:**
- `Java9InterfStatic.java` contains:
  - Two public static methods m1() and m2() both calling the private static method m3()
  - One private static method m3() containing the common functionality
- `TestStatic.java` demonstrates:
  - Calling static methods using interface name: Java9InterfStatic.m1() and Java9InterfStatic.m2()

**Output:**
```
D:\anshu_acharya>java Test
common functionality of methods m1 & m2
common functionality of methods m1 & m2
```

**To Run:**
```bash
javac TestStatic.java
java TestStatic
```

**Note:** Interface static methods should be called by using **interface name only** even in implementation acharyaes also.

---

### Advantages of private Methods inside interfaces:

The main advantages of private methods inside interfaces are:

1. **Code Reusability**
2. We can **expose only intended methods** to the API clients (Implementation acharyaes), because interface private methods are **not visible** to the implementation acharyaes.

---

### Important Notes:

1. **private methods cannot be abstract** and hence **compulsory private methods should have the body**.
2. **private method inside interface can be either static or non-static**.

---

### JDK 7 vs JDK 8 vs JDK 9:

#### 1. Prior to Java 8:
We can declare only **public-abstract methods** and **public-static-final variables** inside interfaces.

**Structure allowed:**
- public-static-final variables
- public-abstract methods

#### 2. In Java 8:
We can declare **default** and **public-static methods** also inside interface.

**Structure allowed:**
- public-static-final variables
- public-abstract methods
- default methods with implementation
- public static methods with implementation

**Reference:** See `Java8Interf.java` and `Java8DBLogging.java`

#### 3. In Java 9:
We can declare **private instance** and **private static methods** also inside interface.

**Structure allowed:**
- public-static-final variables
- public-abstract methods
- default methods with implementation
- public static methods with implementation
- private instance methods with implementation
- private static methods with implementation

**Reference:** See `Java9Interf.java`, `Java9InterfStatic.java`, and `Java9DBLogging.java`

---

## 🎯 Summary

**Note:** The main advantage of **private methods inside interface** is **Code Reusability** without effecting implementation acharyaes.

---

## 🚀 How to Run the Code

```bash
# Navigate to the directory
cd Java9features/Private_methods_in_Interface

# Run Java 8 Duplication Demo
javac TestJava8DBLogging.java
java TestJava8DBLogging

# Run Java 9 Private Method Solution
javac TestJava9DBLogging.java
java TestJava9DBLogging

# Run Private Instance Method Demo
javac Test.java
java Test

# Run Private Static Method Demo
javac TestStatic.java
java TestStatic
```

---

## 📌 Key Takeaways

1. **Java 8** introduced **default methods** for backward compatibility
2. **Java 9** introduced **private methods** for code reusability within interfaces
3. Private methods can be **instance** or **static**
4. Private methods **must have a body** (cannot be abstract)
5. Private methods are **not visible** to implementation acharyaes
6. **private instance methods** provide code reusability for **default methods**
7. **private static methods** provide code reusability for **public static methods**
