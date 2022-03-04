/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package murach.business;

/**
 *
 * @author hoangduongngg
 */
public class Message {
    private String fn , ln , email ;
    
    public Message() {
        this.fn = "";
        this.ln = "";
        this.email = "";
    }
    
    public Message(String fn, String ln, String email) {
        this.fn = fn;
        this.ln = ln;
        this.email = email;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }

    public String getEmail() {
        return email;
    }
    
    
}
