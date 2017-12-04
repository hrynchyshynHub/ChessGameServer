package com.chess.util;



import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ivan.hrynchyshyn on 17.11.2017.
 */

public class Player {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String username;
    private String firstName;
    private String secondName;
    private String password;
    private Integer id;
    private Color color;

    public Player(String username, String firstName, String secondName, String password){
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.id = count.incrementAndGet();
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(username, player.username) &&
                Objects.equals(firstName, player.firstName) &&
                Objects.equals(secondName, player.secondName) &&
                Objects.equals(password, player.password) &&
                Objects.equals(id, player.id) &&
                color == player.color;
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, firstName, secondName, password, id, color);
    }
}
