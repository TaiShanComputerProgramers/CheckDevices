package com.example.administrator.checkdevices.network;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by wd on 2018/4/16.
 *
 * @author wd
 * @date 2018/4/16
 * @describe TODO
 * @package com.example.administrator.checkdevices.network
 */

public class ToByteConvertFactory extends Converter.Factory {
    private static final MediaType MEDIA_TYPE=MediaType.parse("application/octet-stream");
    private static final String TAG="ToByteConvertFactory";

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        if(byte[].class.equals(type)){
            return new Converter<ResponseBody,byte[]>(){
                @Override
                public byte[] convert(ResponseBody value) throws IOException {
                    return value.bytes();
                }
            };
        }
        return super.responseBodyConverter(type,annotations,retrofit);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        /*if(byte[].class.equals(type)){
            return
        }
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new GsonRequestBodyConverter<>(gson, adapter);*/
        return null;
    }
}
