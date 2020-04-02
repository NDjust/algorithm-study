package etc;

import java.util.*;
import java.util.stream.Collectors;

public class baekjoon10814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            users.add(new User(sc.nextInt(), sc.next()));
        }

        Collections.sort(users);

        for (int i = 0; i < n; i++) {
            System.out.println(users.get(i).getAge() + " " + users.get(i).getName());
        }
    }
}

class User implements Comparable<User> {

    public int age;
    public String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User user) {
        return this.age - user.age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}