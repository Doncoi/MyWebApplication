package main.java.bean;

//用户类
public class User {
    private int id;
    private String name;
    private String gender;
    private String phone;
    private String email;

    public User() {}

    public User(String _name, String _gender, String _phone, String _email) {
//        this.id = _id;
        this.name = _name;
        this.gender = _gender;
        this.phone = _phone;
        this.email = _email;
    }

    public int getId() {return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    //打印信息
    public void show() {
        System.out.println(this.id + " " + this.name + " " + this.gender + " " + this.phone + " " + this.email);
    }
}
