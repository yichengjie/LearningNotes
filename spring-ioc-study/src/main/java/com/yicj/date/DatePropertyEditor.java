package com.yicj.date;

import lombok.Setter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//<!--使用自定义属性编辑器，继承PropertyEditorSupport,重写setAsText方法-->
//当spring在注入bean的属性时一旦遇到了java.util.
// Date类型的属性会自动调用自定义的DatePropertyEditor解析器进行解析，
// 并用解析结果代替配置属性进行注入
public class DatePropertyEditor extends PropertyEditorSupport {
    @Setter
    private String format = "yyyy-MM-dd" ;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("text : " + text);
        SimpleDateFormat sdf = new SimpleDateFormat(format) ;
        try {
            Date d = sdf.parse(text) ;
            this.setValue(d);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
