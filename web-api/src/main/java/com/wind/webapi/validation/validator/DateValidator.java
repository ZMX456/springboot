package com.wind.webapi.validation.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.google.common.base.Strings;

import java.text.MessageFormat;
import java.util.regex.Pattern;

/**
 * @Title: DateValidator
 * @Package com.wind.webapi.validation.validator
 * @Description: 日期格式校验器（yyyy-MM-dd）
 * @author wind
 * @date 2018/9/17 18:04
 * @version V1.0
 */
public class DateValidator extends ValidatorHandler<String> implements Validator<String> {
    
    private String fieldName;

    private String regex = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$";
    
    public DateValidator(String fieldName) {
        super();
        this.fieldName = fieldName;
    }

    @Override
    public boolean validate(ValidatorContext context, String t) {
        
        if (Strings.isNullOrEmpty(t)) {
            context.addErrorMsg(MessageFormat.format("{0} can not be empty", fieldName));
            return false;
        }
        
        if (!Pattern.matches(regex, t)) {
            context.addErrorMsg(MessageFormat.format("{0} format should be yyyy-MM-dd", fieldName));
            return false;
        }
        
        return true;
    }
    
}
