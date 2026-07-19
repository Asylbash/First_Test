package ru.zhyldyz.helpers;

import com.codeborne.selenide.Selenide;

public class JavaScriptHelper {

    public JavaScriptHelper removeFixedElements(){
        Selenide.executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        return this;
    }
}
