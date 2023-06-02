
```java
public class User {
    private String id;
    private String name;
}
```
## 1.情景一：`@Data`
编译前：
```java
import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
}
```
编译后：
```java
public class User {
    private String id;
    private String name;

    public User() {
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof User)) {
            return false;
        } else {
            User other = (User)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", name=" + this.getName() + ")";
    }
}
```
## 2.情景二：继承User，并增加属性
### 2.1 使用注解
```java
@Data
public class UserExtend extends User{
    private String other;
}
```
出现：
`Generating equals/hashCode implementation but without a call to superclass, even though this class does not extend java.lang.Object.
If this is intentional, add '(callSuper=false)' to your type.`
原因：
`@Data`相当于`@Getter` `@Setter` `@RequiredArgsConstructor` `@ToString` `@EqualsAndHashCode`这5个注解的合集。
1. 此注解会生成equals(Object other) 和 hashCode()方法。
2. 它默认使用非静态，非瞬态的属性
3. 可通过参数exclude排除一些属性
4. 可通过参数of指定仅使用哪些属性
5. 它默认仅使用该类中定义的属性且不调用父类的方法
6. 可通过callSuper=true解决上一点问题。让其生成的方法中调用父类的方法。
因为`@EqualsAndHashCode`默认不继承父类 就是说 重写`hashcode`和`equals`的时候 不包含父类的字段值，所有只会比较自己对象里面的字段值,显然这是错误的
解决：直接在子类上声明 `@EqualsAndHashCode(callSuper = true)`
```java
@Data
@EqualsAndHashCode(callSuper = true)
public class UserExtend extends User{
    private String other;
}
```

### 2.2：不使用注解
```java
public class UserExtend2 extends User{
    private String other;
    // 情景三
}
```