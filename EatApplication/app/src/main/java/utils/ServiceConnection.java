package utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.eatapplication.LoginActivity;

import java.io.InputStream;
import java.util.Properties;

public class ServiceConnection {

    private  static ServiceConnection serviceConnection;
    public  String url;
    private PropertyReader propertyReader;
    private Context context;
    public Properties properties;

    private ServiceConnection(Context activityContext){
        context = activityContext;
        propertyReader = new PropertyReader(context);
        properties = propertyReader.getMyProperties("application.properties");
        url = properties.getProperty("register.url");
    }

    public static ServiceConnection getInstance(Context activityContext){
        if(serviceConnection == null){
            serviceConnection = new ServiceConnection(activityContext);
        }
        return serviceConnection;
    }

    public class PropertyReader {

        private Context context;
        private Properties properties;

        public PropertyReader(Context context){
            this.context=context;
            properties = new Properties();
        }

        public Properties getMyProperties(String file){
            try{
                AssetManager assetManager = context.getAssets();
                InputStream inputStream = assetManager.open(file);
                properties.load(inputStream);

            }catch (Exception e){
                System.out.print(e.getMessage());
            }
            return properties;
        }
    }
}
