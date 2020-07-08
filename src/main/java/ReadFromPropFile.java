package BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadFromPropFile {

    public String path = System.getProperty("user.dir");
    public FileInputStream fileInputStream;
    public Properties properties;

    public ReadFromPropFile(String fileName){
        properties = new Properties();
        try{
            fileInputStream = new FileInputStream(path + "//src//main//resources//" + fileName);
            properties.load(fileInputStream);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

//*****************SuperAdminLoginPage********************//

    public String getUrl(){ return properties.getProperty("url");    }
    public String getBrowser(){ return properties.getProperty("browser");  }
    public String getEmail(){ return properties.getProperty("email");    }
    public String getPwd(){ return properties.getProperty("password");    }
    //public String getPath(){return properties.getProperty("loadDriverPath");    }
    public String getAddress(){return properties.getProperty("address");    }
    public String getCity(){return properties.getProperty("city");    }
    public String getState(){return properties.getProperty("state");    }
    public String getZip(){return properties.getProperty("zip");    }

    public String getTitle(){return properties.getProperty("title");    }
    public String getJobDesc(){return properties.getProperty("jobdesc");    }
    public String getCity1(){return properties.getProperty("city1");    }
    public String getPayRate(){return properties.getProperty("payrate");    }



}
