import org.graalvm.compiler.replacements.SnippetTemplate;

import java.util.concurrent.atomic.AtomicMarkableReference;

import static java.lang.System.exit;

public class EarthquakeEarlyWarningService {
    int month;
    int day;
    int hour;
    int minute;
    boolean Issue;
    boolean Cancellation;
    int Information1;
    int Information2;
    int Information3;

    public int Rc_3(int input){
        switch(input){
            case 1:
                return 1;
            case 7:
                return 7;
            default:
                exit(1);
        }
    }

    public int Dc_4(int input){
        switch(input){
            case 1:
                return 1;
            default:
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

        month = AtMo(forMo_4);
        day = AtD(forD_5);
        hour = AtH(forH_5);
        minute = AtMi(forMi_6);
    }
    int AtMo(int input){
        if (input > 12) {
            exit(1);
        } else {
            return input;
        }
    }

    int AtD(int input){
        if (input > 31){
            exit(1);
        } else {
            return input;
        }
    }

    int AtH(int input){
        if (input > 24) {
            exit(1);
        } else {
            return input;
        }
    }

    int AtMi(int input){
        if (input > 59){
            exit(1);
        } else {
            return input;
        }
    }

    public It_2(int input){
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

    public Spare1_10(int input){
        if(input){
            exit(1);
        } else {
            return;
        }
    }

    public Co_1_9(int input){
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

    public Co_2_9(int input){
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

    public Co_3_9(int input){
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
}
