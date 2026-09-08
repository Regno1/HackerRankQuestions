

//Write your code here
class MyRegex {

    String num =
        "([0-9]|[0-9]{2}|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5])";

    String pattern = num + "\\." + num + "\\." + num + "\\." + num;
}
