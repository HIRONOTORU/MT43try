import org.graalvm.compiler.replacements.SnippetTemplate;

import java.util.concurrent.atomic.AtomicMarkableReference;

import static java.lang.System.exit;

public class EarthquakeEarlyWarningService {
    int mt43try_1_32 = 0x53ADF2C5;
    int mt43try_2_32 = 0x14000510;
    int mt43try_3_32 = 0x0E000000;
    int mt43try_4_32 = 0x00000000;
    int mt43try_5_32 = 0x00000000;
    int mt43try_6_32 = 0x00000000;
    int mt43try_7_32 = 0x00000010;
    int mt43try_8_32 = 0x1E295D4_0;

    boolean ReportClassification;
    boolean ReportClassificationTrainingTest;

    int DisasterCategory;
    int Rt_month;
    int Rt_day;
    int Rt_hour;
    int Rt_minute;
    boolean Issue;
    boolean Cancellation;
    int Information1;
    int Information2;
    int Information3;
    int Ot_day;
    int Ot_hour;
    int Ot_minute;
    int DepthKilometers;
    boolean DepthKilometersOver500km;
    boolean DepthKilometersUnkown;
    int Magnitude_x10;
    boolean MagnitudeOver10;
    boolean MagnitudeUnkown;
    int SeismicEpicenter;
    int SeismicIntensity;

    int IntensityLowerLimit;
    boolean IntensityLowerLimitNone;
    boolean IntensityLowerLimitUnkown;
    int IntensityUpperLimit;
    boolean IntensityUpperLimitMoreThanAbout;
    boolean IntensityUpperLimitNone;
    boolean IntensityUpperLimitUnkown;

    int RegionNameBits1;
    int RegionNameBits2;
    int RegionNameBits3;

    int JMADCReportVersion;

    ReportClassification;
    int DisasterCategory;

    public void Rc_3(int input){
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
                exit(1);
        }
    }

    public void Dc_4(int input){
        if(input == 1) {
            DisasterCategory = input;
        } else {
            exit(1);
        }
    }

    public At_20(int input) {
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
    public int AtMo(int input){
        if (input > 12) {
            exit(1);
        } else {
            return input;
        }
    }

    public int AtD(int input){
        if (input > 31){
            exit(1);
        } else {
            return input;
        }
    }

    public int AtH(int input){
        if (input > 24) {
            exit(1);
        } else {
            return input;
        }
    }

    public int AtMi(int input){
        if (input > 59){
            exit(1);
        } else {
            return input;
        }
    }

    public void It_2(int input){
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
                exit(1);
        }
    }

    public void Spare1_10(int input){
        if(input){
            exit(1);
        }
    }

    public void Co_1_9(int input){
        // Table 4.1.2-6 Notifications on Disaster Prevention
        if (input == 0){
            Information1 = input;
        }
        if ((input < 101) || (input > 500)) {
            exit(1);
        } else {
            Information1 = input;
        }
    }

    public void Co_2_9(int input){
        // Table 4.1.2-6 Notifications on Disaster Prevention
        if (input == 0){
            Information2 = input;
        }
        if ((input < 101) || (input > 500)) {
            exit(1);
        } else {
            Information2 = input;
        }
    }

    public void Co_3_9(int input){
        // Table 4.1.2-6 Notifications on Disaster Prevention
        if (input == 0){
            Information3 = input;
        }
        if ((input < 101) || (input > 500)) {
            exit(1);
        } else {
            Information3 = input;
        }
    }

    public void Ot_16(int input) {
        Ot_day =  (0b1111_1000_0000_0000 & input) >> 11;
        Ot_hour =  (0b0000_0111_1100_0000 & input) >> 6;
        Ot_minute = (0b0000_0000_0011_1111 & input);
    }

    public void De_9(int input){
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

    public void Ma_7(int input){
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

    public void Ep_10(int input){
        // Table 4.1.2-7 Epicenter and Hypocenter
        if (input < 11 || input > 1000){
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

    public void L1_4(int input) {
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

    public void U1_4(int input){
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

    public void P1_80_1_80(int input1, int input2, int input3) {
        //Table 4.1.2-10 Forecast Region_Earthquake Early
        //http://www.data.jma.go.jp/svd/eqev/data/joho/shindo-name.html
        RegionNameBits1 = input1;
        RegionNameBits2 = input2;
        RegionNameBits3 = ( 0b1111_1111_1111_1111_0000_0000_0000_0000 & input3 );

    }

    public void Spare2_4(int input){
        if(input){
            exit(1);
        }
    }

    public void Vn_6(int input){
        JMADCReportVersion = input;
    }

}
