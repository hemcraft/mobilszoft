package com.example.mobilszoft.selector;

import com.example.mobilszoft.R;

public class CountrySelector {

    public static int selectCountryImage(String country){
        int ret = 0;

        switch(country) {
            case "United States":
                // code block
                ret = R.drawable.us;
                break;
            case "Hungary":
                // code block
                ret = R.drawable.hu;
                break;
            case "Norway":
                // code block
                ret = R.drawable.no;
                break;
            case "Germany":
                // code block
                ret = R.drawable.de;
                break;
            case "Russia":
                // code block
                ret = R.drawable.ru;
                break;
            case "India":
                // code block
                ret = R.drawable.in;
                break;
            case "Netherlands":
                // code block
                ret = R.drawable.ne;
                break;
            case "Mexico":
                // code block
                ret = R.drawable.mx;
                break;
            case "Austria":
                // code block
                ret = R.drawable.at;
                break;
            case "Spain":
                // code block
                ret = R.drawable.es;
                break;
            case "Japan":
                // code block
                ret = R.drawable.ja;
                break;
            case "Poland":
                // code block
                ret = R.drawable.pl;
                break;
            default:
                ret = R.drawable.hu;
                // code block
        }

        return ret;
    }
}
