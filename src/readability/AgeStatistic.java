package readability;

/**
 * @author Grankin Maxim (maximgran@gmail.com) at 21:57 05.06.2020
 */
public class AgeStatistic {


    public static int getAge(int score) {
        if (score <= 0) {
            return 0;
        }
        int upper;
        switch (score) {
            case 1:
                upper = 6;
                break;
            case 2:
                upper = 7;
                break;
            case 3:
                upper = 9;
                break;
            case 4:
                upper = 10;
                break;
            case 5:
                upper = 11;
                break;
            case 6:
                upper = 12;
                break;
            case 7:
                upper = 13;
                break;
            case 8:
                upper = 14;
                break;
            case 9:
                upper = 15;
                break;
            case 10:
                upper = 16;
                break;
            case 11:
                upper = 17;
                break;
            case 12:
                upper = 18;
                break;
            case 13:
                upper = 24;
                break;
            default:
                upper = 25;
                break;
        }
        return upper;

    }

}
