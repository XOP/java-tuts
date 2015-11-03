package user;

import java.time.LocalDateTime;

public class Login {
    private LocalDateTime date;
    private String ip;

    public Login(LocalDateTime date, String ip) {
        this.date = date;
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
