package com.wind.webapi.validation;


import com.wind.webapi.exception.IllegalParameterException;
import com.baidu.unbiz.fluentvalidator.DefaultValidateCallback;
import com.baidu.unbiz.fluentvalidator.ValidateCallback;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.validator.element.ValidatorElementList;
import java.util.List;

/**
 * @Title: CustomValidateCallback
 * @Package com.wind.webapi.validator
 * @Description: 普通参数检验回调类
 * @author wind
 * @date 2018/9/17 18:04
 * @version V1.0
 */
public class CustomValidateCallback extends DefaultValidateCallback implements ValidateCallback {

    @Override
    public void onFail(ValidatorElementList validatorElementList, List<ValidationError> errors) {
        throw new IllegalParameterException(errors.get(0).getErrorMsg());
    }

    @Override
    public void onSuccess(ValidatorElementList validatorElementList) {
    }

    @Override
    public void onUncaughtException(Validator validator, Exception e, Object target) throws Exception {
        throw e;
    }

}
