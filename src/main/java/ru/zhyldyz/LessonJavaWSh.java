package ru.zhyldyz;

import lombok.Data;

@Data
public class LessonJavaWSh {

   String country = "%s";

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
