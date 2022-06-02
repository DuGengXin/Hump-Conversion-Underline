public class Main {
    public static void main(String[] args) {
        String[] testData = new String[]{
                "myFirstName", "OnlineUsers", "Address", "validHTTPRequest", "SpringMVC",
                "userInfo", "SpringCloud", "uniqueIdentifier", "DevelopmentGuide", "className123","PutAApple"
        };

        for (String str : testData) {
            System.out.println(humpConversionUnderline(str));
        }
    }

    public static String humpConversionUnderline(String humpStr) {
        StringBuilder underLineBuilder = new StringBuilder();
        //连续大写字母单词开关
        boolean switchTag = true;
        for (int i = 0; i < humpStr.length(); i++) {
            //转为ASCII
            int asciiNum = humpStr.charAt(i);
            if (asciiNum > 64 && asciiNum < 91) {
                //首字母不加下划线
                boolean temp1 = i != 0;
                //下一位为小写字母时
                boolean temp2 = i < humpStr.length() - 1 && humpStr.charAt(i + 1) > 95 && humpStr.charAt(i + 1) < 123;
                //添加下划线
                if (temp1 && (switchTag || temp2))
                    underLineBuilder.append("_");
                //大写字母转为小写
                asciiNum += 32;
                switchTag = false;
            } else {
                switchTag = true;
            }
            underLineBuilder.append((char) (asciiNum));
        }
        return underLineBuilder.toString();
    }

}
