package prac24.controllers;

import prac24.constraint.FieldMatch;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "login", second = "confirmLogin", message = "The login fields must match")
})
public class UserRegistrationDto {

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private String login;

    @NotNull
    private String confirmLogin;

    @AssertTrue
    private Boolean terms;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getConfirmLogin() {
        return confirmLogin;
    }

    public void setConfirmLogin(String confirmEmail) {
        this.confirmLogin = confirmLogin;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

}
