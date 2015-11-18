package sk.upjs.ics.mealplanet;

import java.util.List;

public class User {
    private String name;
    private String password;
    private List<Long> userRecipes;
    private long rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getUserRecipes() {
        return userRecipes;
    }

    public void setUserRecipes(List<Long> userRecipes) {
        this.userRecipes = userRecipes;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
   
}
