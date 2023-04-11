package common;

import org.testng.annotations.DataProvider;

public class DataProviderTestNG {

    @DataProvider(name="telephone")
    public Object[][] getPhone()
    {
         return new Object[][]{
                 {"+9370123456789"},
                 {"+358457012345678"},
                 {"+3584570123456789"},
                 {"+35845701234567890"},
                 {"+35567123456789"},
                 {"+2135123456789"},
                 {"+97335512345678",}
         };
    }

}
