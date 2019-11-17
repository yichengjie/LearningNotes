package com.yicj.postprocessor.component;

import lombok.Getter;
import lombok.Setter;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {
    @Getter
    @Setter
    private String datePattern = "YYYY/MM/DD";

    //如果仅支持从string到相应对象类型的转换，只要覆写setAsText即可
    //如果想支持双向转换，需要同时考虑getAsText方法覆写
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat(datePattern) ;
        Date parse = null ;
        try {
            parse = format.parse(text);
        } catch (ParseException e) {
            setValue(null);
        }
        this.setValue(parse);
    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }
}
