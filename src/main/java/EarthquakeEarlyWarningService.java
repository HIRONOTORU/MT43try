
import static java.lang.System.exit;

public class EarthquakeEarlyWarningService {
    public static int mt43try_1_32 = 0x53ADF2C5;
    public static int mt43try_2_32 = 0x14000510;
    public static int mt43try_3_32 = 0x0E000000;
    public static int mt43try_4_32 = 0x00000000;
    public static int mt43try_5_32 = 0x00000000;
    public static int mt43try_6_32 = 0x00000000;
    public static int mt43try_7_32 = 0x00000010;
    public static int mt43try_8_32 = 0x1E295D4_0;

    public static String PAB;
    public static int MT;

    public static int ReportClassificationInt;
    public static boolean ReportClassification;
    public static boolean ReportClassificationTrainingTest;

    public static int DisasterCategory;
    public static int Rt_month;
    public static int Rt_day;
    public static int Rt_hour;
    public static int Rt_minute;
    public static boolean Issue;
    public static boolean Cancellation;
    public static int Information1;
    public static int Information2;
    public static int Information3;
    public static int Ot_day;
    public static int Ot_hour;
    public static int Ot_minute;
    public static int DepthKilometers;
    public static boolean DepthKilometersOver500km;
    public static boolean DepthKilometersUnkown;
    public static int Magnitude_x10;
    public static boolean MagnitudeOver10;
    public static boolean MagnitudeUnkown;
    public static int SeismicEpicenter;
    public static int SeismicIntensity;

    static int IntensityLowerLimit;
    static boolean IntensityLowerLimitNone;
    static boolean IntensityLowerLimitUnkown;
    static int IntensityUpperLimit;
    static boolean IntensityUpperLimitMoreThanAbout;
    static boolean IntensityUpperLimitNone;
    static boolean IntensityUpperLimitUnkown;

    static int RegionNameBits1;
    static int RegionNameBits2;
    static int RegionNameBits3;

    static int JMADCReportVersion;



    public static void PAB_8(int input) {
        switch (input) {
            case 0x53:
                PAB = "PatternA";
                break;
            case 0x9A:
                PAB = "PatternB";
                break;
            case 0xC6:
                PAB = "PatternC";
                break;
            default:
                System.out.println("1");
                exit(1);
        }
    }

    public static void MT_6(int input){
        switch(input){
            case 43:
            case 44:
                MT = input;
                break;
            default:
                System.out.println("2");
                exit(1);
        }
    }

    public static void Rc_3(int input){
        ReportClassificationInt = input;
        switch(input){
            case 1:
                ReportClassification = true;
                ReportClassificationTrainingTest = false;
                break;
            case 7:
                ReportClassification = false;
                ReportClassificationTrainingTest = true;
                break;
            default:
                return;
                // System.out.println("3");
                // exit(1);
        }
    }

    public static void Dc_4(int input){
        DisasterCategory = input;
        /*
        if(input == 1) {
            DisasterCategory = input;
        } else {
            exit(1);
        }
        */

    }

    public static void At_20(int input) {
        int forMo_4;
        int forD_5;
        int forH_5;
        int forMi_6;

        forMo_4 = (0b1111_0000_0000_0000_0000 & input) >> 16;
        forD_5  = (0b0000_1111_1000_0000_0000 & input) >> 11;
        forH_5  = (0b0000_0000_0111_1100_0000 & input) >> 6;
        forMi_6 = (0b0000_0000_0000_0011_1111 & input);

        Rt_month = AtMo(forMo_4);
        Rt_day = AtD(forD_5);
        Rt_hour = AtH(forH_5);
        Rt_minute = AtMi(forMi_6);

    }
    public static int AtMo(int input) {
        if (input > 12) {
            System.out.println("5");
            exit(1);
        }
        return input;
    }

    public static int AtD(int input){
        if (input > 31){
            System.out.println("6");
            exit(1);
        }
        return input;
    }

    public static int AtH(int input){
        if (input > 24) {
            System.out.println("7");
            exit(1);
        }
        return input;
    }

    public static int AtMi(int input){
        if (input > 59){
            System.out.println("8");
            exit(1);
        }
        return input;
    }

    public static void It_2(int input){
        switch(input){
            case 0:
                Issue = true;
                Cancellation = false;
                return;
            case 2:
                Issue = false;
                Cancellation = true;
                return;
            default:
                System.out.println("9");
                exit(1);
        }
    }

    public static void Spare1_10(int input){
        if(input != 0){
            System.out.println("10");
            exit(1);
        }
    }

    public static void Co_1_9(int input){
        // Table 4.1.2-6 Notifications on Disaster Prevention
        if (input == 0){
            Information1 = input;
        }
        if ((input < 101) || (input > 500)) {
            System.out.println("11");
            exit(1);
        } else {
            Information1 = input;
        }
    }

    public static void Co_2_9(int input){
        // Table 4.1.2-6 Notifications on Disaster Prevention
        if (input == 0){
            Information2 = input;
        }
        if ((input < 101) || (input > 500)) {
            System.out.println("12");
            exit(1);
        } else {
            Information2 = input;
        }
    }

    public static void Co_3_9(int input){
        // Table 4.1.2-6 Notifications on Disaster Prevention
        if (input == 0){
            Information3 = input;
        }
        if ((input < 101) || (input > 500)) {
            System.out.println("13");
            exit(1);
        } else {
            Information3 = input;
        }
    }

    public static void Ot_16(int input) {
        Ot_day =  (0b1111_1000_0000_0000 & input) >> 11;
        Ot_hour =  (0b0000_0111_1100_0000 & input) >> 6;
        Ot_minute = (0b0000_0000_0011_1111 & input);
    }

    public static void De_9(int input){
        if (input < 501 ){
            DepthKilometers = input;
            DepthKilometersOver500km = false;
            DepthKilometersUnkown = false;
        } else if ( input == 501 ) {
            DepthKilometers = -1;
            DepthKilometersOver500km = true;
            DepthKilometersUnkown = false;
        } else {
            DepthKilometers = -1;
            DepthKilometersOver500km = false;
            DepthKilometersUnkown = true;
        }
    }

    public static void Ma_7(int input){
        if (input < 101){
            Magnitude_x10 = input;
            MagnitudeOver10 = false;
            MagnitudeUnkown = false;
        } else if (input == 101) {
            Magnitude_x10 = -1;
            MagnitudeOver10 = true;
            MagnitudeUnkown = false;
        } else {
            Magnitude_x10 = -1;
            MagnitudeOver10 = false;
            MagnitudeUnkown = true;
        }
    }

    public static void Ep_10(int input){
        // Table 4.1.2-7 Epicenter and Hypocenter
        if (input < 11 || input > 1000){
            System.out.println("14");
            exit(1);
        }
        SeismicEpicenter = input;
    }
    /*
    public LatLon_41(long input){
        LatNs = (0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000 & input) >> 63;
        LatD =  (0b0111_1111_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000 & input) >> 56;
        LatM =  (0b0000_0000_1111_1100_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000 & input) >> 50;
        LatS =  (0b0000_0000_0000_0011_1111_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000 & input) >> 44;

        LonEw = (0b0000_0000_0000_0000_0000_1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000 & input) >> 43;
        LonD =  (0b0000_0000_0000_0000_0000_0111_1111_1000_0000_0000_0000_0000_0000_0000_0000_0000 & input) >> 35;
        LonM =  (0b0000_0000_0000_0000_0000_0000_0000_0111_1110_0000_0000_0000_0000_0000_0000_0000 & input) >> 29;
        LonS =  (0b0000_0000_0000_0000_0000_0000_0000_0000_0001_1111_1000_0000_0000_0000_0000_0000 & input) >> 23;

        return;
    }
    */

    public static void L1_4(int input) {
        //Table 4.1.2-8 Seismic Intensity Lower Limit
        if (input == 14) {
            IntensityLowerLimit = -1;
            IntensityLowerLimitNone = true;
            IntensityLowerLimitUnkown = false;
        } else if (input == 15) {
            IntensityLowerLimit = -1;
            IntensityLowerLimitNone = false;
            IntensityLowerLimitUnkown = true;
        } else {
            IntensityLowerLimit = input;
            IntensityLowerLimitNone = false;
            IntensityLowerLimitUnkown = false;
        }
    }

    public static void U1_4(int input){
        //Table 4.1.2-9 Seismic Intensity Upper Limit
        if (input == 14) {
            IntensityUpperLimit = -1;
            IntensityUpperLimitMoreThanAbout = false;
            IntensityUpperLimitNone = true;
            IntensityUpperLimitUnkown = false;
        } else if (input == 15) {
            IntensityUpperLimit = -1;
            IntensityUpperLimitMoreThanAbout = false;
            IntensityUpperLimitNone = false;
            IntensityUpperLimitUnkown = true;
        } else if (input == 11) {
            IntensityUpperLimit = -1;
            IntensityUpperLimitMoreThanAbout = true;
            IntensityUpperLimitNone = false;
            IntensityUpperLimitUnkown = false;
        } else {
            IntensityUpperLimit = input;
            IntensityUpperLimitMoreThanAbout = false;
            IntensityUpperLimitNone = false;
            IntensityUpperLimitUnkown = false;

        }
    }

    public static void P1_80_1_80(int input1, int input2, int input3) {
        //Table 4.1.2-10 Forecast Region_Earthquake Early
        //http://www.data.jma.go.jp/svd/eqev/data/joho/shindo-name.html
        RegionNameBits1 = input1;
        RegionNameBits2 = input2;
        RegionNameBits3 = ( 0b1111_1111_1111_1111_0000_0000_0000_0000 & input3 );

    }

    public static void Spare2_4(int input){
        if(input != 0){
            exit(1);
        }
    }

    public static void Vn_6(int input) {
        JMADCReportVersion = input;
    }

    public static void main(String[] args){
        PAB_8((mt43try_1_32 & 0xff000000) >> 24 );
        MT_6((mt43try_1_32 & 0x00fc0000) >> 18 );
        Rc_3((mt43try_1_32 & 0x00038000) >> 15 );
        Dc_4((mt43try_1_32 & 0x00007800) >> 11);
        int tmp;
        tmp = (((mt43try_1_32 & 0x000007ff) << 21 ) | ((mt43try_2_32 & 0xff800000) >> 11 ));
        tmp = tmp >> 12;
        At_20(tmp);
        It_2((mt43try_2_32 & 0x00600000) >> 21);
        /*
        Spare1_10((mt43try_2_32 & 0x001ff800) >> 11);
        Co_1_9((mt43try_2_32 & 0x000007fc) >> 2);
        tmp = (((mt43try_2_32 & 0x00000003) << 30 ) | ((mt43try_3_32 & 0xfe000000) >> 2 ));
        tmp = tmp >> 23;
        Co_2_9(tmp);
        Co_3_9((mt43try_3_32 & 0x01ff0000) >> 16 );
        Ot_16((mt43try_3_32 & 0x0000ffff) );
        De_9((mt43try_4_32 & 0xff800000) >> 23);
        Ma_7((mt43try_4_32 & 0x007f0000) >> 16);
        Ep_10((mt43try_4_32 & 0x0000ffc0) >> 6);
        L1_4((mt43try_4_32 & 0x0000003c) >> 2);
        tmp = (((mt43try_4_32 & 0x00000003) << 30 ) | ((mt43try_5_32 & 0xc0000000) >> 2 ));
        tmp = tmp >> 28;
        U1_4(tmp);
        tmp = (((mt43try_5_32 & 0x3fffffff) << 2 ) | ((mt43try_6_32 & 0xc0000000) >> 30));
        int tmp2, tmp3;
        tmp2 = (((mt43try_6_32 & 0x3fffffff) << 2) | ((mt43try_7_32 & 0xc0000000) >> 30));
        tmp3 = (((mt43try_7_32 & 0x3fffc000) >> 14 ));
        P1_80_1_80(tmp,tmp2,tmp3);
        Spare2_4((mt43try_7_32 & 0x00003c00) >> 10);
        */

        Vn_6((mt43try_7_32 & 0x000003f0) >> 4);
        // mt43try_8_32 not Use.

        System.out.println("## input ##");
        System.out.printf("%08x",mt43try_1_32);
        System.out.printf("%08x",mt43try_2_32);
        System.out.printf("%08x",mt43try_3_32);
        System.out.printf("%08x",mt43try_4_32);
        System.out.printf("%08x",mt43try_5_32);
        System.out.printf("%08x",mt43try_6_32);
        System.out.printf("%08x",mt43try_7_32);
        System.out.printf("%08x\n",mt43try_8_32);

        System.out.println("## output ##");
        System.out.printf("{\n");
        System.out.printf("\"%s\":\"%s\",\n","PAB",PAB);
        System.out.printf("\"%s\":\"%d\",\n","MT",MT);
        System.out.printf("\"%s\":\"%b\",\n","ReportClassification",ReportClassification);
        System.out.printf("\"%s\":\"%b\",\n","ReportClassificationTrainingTest",ReportClassificationTrainingTest);

        System.out.printf("\"%s\":\"%d\",\n","DisasterCategory",DisasterCategory);
        System.out.printf("\"%s\":\"%02d\",\n","Rt_month",Rt_month);
        System.out.printf("\"%s\":\"%02d\",\n","Rt_day",Rt_day);
        System.out.printf("\"%s\":\"%02d\",\n","Rt_hour",Rt_hour);
        System.out.printf("\"%s\":\"%02d\",\n","Rt_minute",Rt_minute);

        System.out.printf("\"%s\":\"%b\",\n","Issue",Issue);
        System.out.printf("\"%s\":\"%b\",\n","Cancellation",Cancellation);

        /*
        System.out.printf("\"%s\":\"%03d\",\n","Information1",Information1);
        System.out.printf("\"%s\":\"%03d\",\n","Information2",Information2);
        System.out.printf("\"%s\":\"%03d\",\n","Information3",Information3);

        System.out.printf("\"%s\":\"%02d\",\n","Ot_day",Ot_day);
        System.out.printf("\"%s\":\"%02d\",\n","Ot_hour",Ot_hour);
        System.out.printf("\"%s\":\"%02d\",\n","Ot_minute",Ot_minute);
        System.out.printf("\"%s\":\"%03d\",\n","DepthKilometers",DepthKilometers);

        System.out.printf("\"%s\":\"%b\",\n","DepthKilometersOver500km",DepthKilometersOver500km);
        System.out.printf("\"%s\":\"%b\",\n","DepthKilometersUnkown",DepthKilometersUnkown);

        System.out.printf("\"%s\":\"%03d\",\n","Magnitude_x10",Magnitude_x10);

        System.out.printf("\"%s\":\"%b\",\n","DepthKilometersUnkown",DepthKilometersUnkown);
        System.out.printf("\"%s\":\"%b\",\n","MagnitudeOver10",MagnitudeOver10);
        System.out.printf("\"%s\":\"%b\",\n","MagnitudeUnkown",MagnitudeUnkown);

        System.out.printf("\"%s\":\"%04d\",\n","SeismicEpicenter",SeismicEpicenter);
        System.out.printf("\"%s\":\"%02d\",\n","SeismicIntensity",SeismicIntensity);
        System.out.printf("\"%s\":\"%02d\",\n","IntensityLowerLimit",IntensityLowerLimit);

        System.out.printf("\"%s\":\"%b\",\n","IntensityLowerLimitNone",IntensityLowerLimitNone);
        System.out.printf("\"%s\":\"%b\",\n","IntensityLowerLimitUnkown",IntensityLowerLimitUnkown);

        System.out.printf("\"%s\":\"%02d\",\n","IntensityUpperLimit",IntensityUpperLimit);

        System.out.printf("\"%s\":\"%b\",\n","IntensityUpperLimitMoreThanAbout",IntensityUpperLimitMoreThanAbout);
        System.out.printf("\"%s\":\"%b\",\n","IntensityUpperLimitNone",IntensityUpperLimitNone);
        System.out.printf("\"%s\":\"%b\",\n","IntensityUpperLimitUnkown",IntensityUpperLimitUnkown);

        System.out.printf("\"%s\":\"%08X%08X%08X\"\n","RegionNameBits",RegionNameBits1,RegionNameBits2,RegionNameBits3);
       */
        System.out.printf("\"%s\":\"%d\"\n","JMADCReportVersion",JMADCReportVersion);

        System.out.printf("}\n");


    }

}
