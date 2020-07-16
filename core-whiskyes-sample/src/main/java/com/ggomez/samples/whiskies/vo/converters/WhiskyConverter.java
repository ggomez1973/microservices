package com.ggomez.samples.whiskies.vo.converters;

import com.ggomez.samples.whiskies.domain.Whisky;
import com.ggomez.samples.whiskies.vo.WhiskyValueObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WhiskyConverter implements Converter<Whisky, WhiskyValueObject> {
    @Override
    public WhiskyValueObject convert(Whisky whisky) {
        return new WhiskyValueObject(whisky.getName(), whisky.isPeated());
    }
}
